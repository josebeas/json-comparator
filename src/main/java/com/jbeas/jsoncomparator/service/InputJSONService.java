package com.jbeas.jsoncomparator.service;

import com.jbeas.jsoncomparator.builer.JSONInputBuilder;
import com.jbeas.jsoncomparator.dto.JSONInput;
import com.jbeas.jsoncomparator.form.JSONInputForm;
import com.jbeas.jsoncomparator.repository.JSONInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
