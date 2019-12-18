package com.jbeas.jsoncomparator.service;

import com.jbeas.jsoncomparator.dto.DiffResult;
import com.jbeas.jsoncomparator.exception.MissingJSONInputException;
import com.jbeas.jsoncomparator.repository.DiffResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiffResultsService {

    @Autowired
    DiffResultsRepository resultsRepository;

    @Autowired
    InputJSONService inputJSONService;

    public DiffResult compare(Integer id) throws MissingJSONInputException {
        return inputJSONService.compare(id);
    }

    public DiffResult getById(Integer id) throws MissingJSONInputException {
        return resultsRepository.getById(id);
    }
}
