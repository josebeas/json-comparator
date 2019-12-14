package com.jbeas.jsoncomparator.service;

import com.jbeas.jsoncomparator.builer.JSONInputBuilder;
import com.jbeas.jsoncomparator.dto.DiffResult;
import com.jbeas.jsoncomparator.dto.InputType;
import com.jbeas.jsoncomparator.dto.JSONInput;
import com.jbeas.jsoncomparator.exception.MissingJSONInputException;
import com.jbeas.jsoncomparator.form.JSONInputForm;
import com.jbeas.jsoncomparator.repository.JSONInputRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InputJSONService {

    @Autowired
    JSONInputRepository repository;

    public Integer save(Integer id, JSONInputForm inputForm){
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
            throw new MissingJSONInputException(String.format("Missing %s JSON Input",left == null?"LEFT":"RIGHT"));
        }
        /*
        o If equal return that
        o If not of equal size just return that
        o If of same size provide insight in where the diffs are, actual diffs are not needed.
         So mainly offsets + length in the data
        */
        int pos = 0;
        List<Integer> offsets = new ArrayList<>();
        if(left != null && right != null){
            if(StringUtils.equals(left.getContent(), right.getContent()) || (left.getContent().length() != right.getContent().length())){
                result.setLength(0);
                result.setOffset(offsets);
            } else {
                while(pos < left.getContent().length()){
                    if(left.getContent().charAt(pos) != right.getContent().charAt(pos)){
                        offsets.add(pos);
                    }
                    if(pos >= right.getContent().length()){
                        break;
                    }
                    pos++;
                }
            }
            result.setOffset(offsets);
        }
        return result;
    }
}
