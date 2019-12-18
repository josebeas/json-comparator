package com.jbeas.jsoncomparator.service;

import com.jbeas.jsoncomparator.builer.JSONInputBuilder;
import com.jbeas.jsoncomparator.dto.DiffResult;
import com.jbeas.jsoncomparator.dto.InputType;
import com.jbeas.jsoncomparator.dto.JSONInput;
import com.jbeas.jsoncomparator.dto.Offset;
import com.jbeas.jsoncomparator.exception.MissingJSONInputException;
import com.jbeas.jsoncomparator.form.JSONInputForm;
import com.jbeas.jsoncomparator.repository.JSONInputRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InputJSONService {

    private static final Logger logger = LoggerFactory.getLogger(InputJSONService.class);

    @Autowired
    JSONInputRepository repository;

    //TODO: throw custom exceptions when entity not valid
    public Integer save(Integer id, JSONInputForm inputForm){
        logger.info(String.format("Saving %s with id %s into repository", inputForm.toString(), id));
        JSONInput input = JSONInputBuilder.buildFromForm(inputForm);
        input.setId(id);
        repository.add(input);
        return  input.getId();
    }

    public DiffResult compare(Integer id) throws MissingJSONInputException {
        JSONInput left = repository.getById(id, InputType.LEFT);
        JSONInput right = repository.getById(id, InputType.RIGHT);
        DiffResult result = new DiffResult(id);
        if(left == null || right == null){
            throw new MissingJSONInputException(String.format("Missing %s JSON Input", left == null?"LEFT":"RIGHT"));
        }
        /*
        o If equal return that
        o If not of equal size just return that
        o If of same size provide insight in where the diffs are, actual diffs are not needed.
         So mainly offsets + length in the data
        */
        logger.debug(String.format("Comparing %s with %s ", left.toString(), right.toString()));
        int pos = 0;
        int offsetPosition = -1;
        int offsetLength = 0;
        boolean offsetFound = false;

        List<Offset> offsets = new ArrayList<>();
        if(left != null && right != null){
            if(StringUtils.equals(left.getContent(), right.getContent())){
                result.setResult("SAME STRINGS");
            } else if(left.getContent().length() == right.getContent().length()){
                while(pos < left.getContent().length()){
                    char leftChar = left.getContent().charAt(pos);
                    char rightChar = right.getContent().charAt(pos);
                    if(left.getContent().charAt(pos) != right.getContent().charAt(pos)){
                        if(!offsetFound){
                            offsetPosition = pos; // change this to offsetPosition = pos + 1 in case we want char positions starts at 1
                        }
                        offsetLength++;
                        //TODO: in case actual diff needed add a StringBuilder and store char
                        offsetFound = true;
                    } else {
                        if(offsetLength > 0 && offsetFound) {
                            Offset offset =  new Offset();
                            offset.setPosition(offsetPosition);
                            offset.setLength(offsetLength);
                            //TODO: in case actual diff needed get content from StringBuilder
                            offsets.add(offset);
                            offsetLength = 0;
                            offsetPosition = 0;
                        }
                        offsetFound = false;
                    }
                    pos++;
                }
                if(!offsets.isEmpty()){
                    result.setResult("DIFF STRINGS");
                }
            } else {
                result.setResult("STRINGS WITH DIFF LENGTH");
            }
        }
        result.setOffset(offsets);
        return result;
    }
}
