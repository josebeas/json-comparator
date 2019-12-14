package com.jbeas.jsoncomparator.controller;

import com.jbeas.jsoncomparator.dto.DiffResult;
import com.jbeas.jsoncomparator.exception.MissingJSONInputException;
import com.jbeas.jsoncomparator.service.DiffResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;


@RestController
public class DiffResultsController {

    @Autowired
    private DiffResultsService resultsService;

    @RequestMapping(value = "/v1/diff/results/status")
    public String getStatus() {
        return "JSON DIFF RESULTS CONTROLLER IS RUNNING!";
    }

    @RequestMapping(value = "/v1/diff/{id}")
    //TODO: add mapping for errors/exceptions
    DiffResult compareInput(@PathVariable @Min(1) Integer id) throws MissingJSONInputException{
        return resultsService.compare(id);
    }

}
