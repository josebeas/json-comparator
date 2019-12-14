package com.jbeas.jsoncomparator.service;

import com.jbeas.jsoncomparator.dto.DiffResult;
import com.jbeas.jsoncomparator.exception.MissingJSONInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiffResultsService {

    @Autowired
    InputJSONService inputJSONService;

    public DiffResult compare(Integer id) throws MissingJSONInputException {
        return inputJSONService.compare(id);
    }
}
