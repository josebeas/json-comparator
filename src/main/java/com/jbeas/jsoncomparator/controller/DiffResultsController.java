package com.jbeas.jsoncomparator.controller;

import com.jbeas.jsoncomparator.dto.DiffResult;
import com.jbeas.jsoncomparator.exception.MissingJSONInputException;
import com.jbeas.jsoncomparator.service.DiffResultsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * Diff Results controller
 *
 * Analyzes left and right inputs based on given id, id must have been stored on repository and have the same size otherwise
 * default response will returned
 *
 * @author Jose Beas
 * @version 1.0
 */
@RestController
public class DiffResultsController {

    private static final Logger logger = LoggerFactory.getLogger(DiffResultsController.class);

    @Autowired
    private DiffResultsService resultsService;

    /**
     * Just a debug endpoint to confirm that it stills alive
     * @return hard-coded string for this controller
     */
    @RequestMapping(value = "/v1/diff/results/status")
    public String getStatus() {
        return "JSON DIFF RESULTS CONTROLLER IS RUNNING!";
    }

    /**
     * Compare inputs endpoint
     *
     * @param id Id to search on repository and compare its content
     * @return list of differences and his location on string if there
     * only if given id have both inputs saved and they have the same length otherwise inputs wont be compared at all.
     * @throws MissingJSONInputException when LEFT or RIGHT JsonInput is missing
     */
    @RequestMapping(value = "/v1/diff/{id}")
    DiffResult compareInput(@PathVariable @Min(1) Integer id) throws MissingJSONInputException{
        logger.info(String.format("Comparing %s JSON inputs", id));
        return resultsService.compare(id);
    }

}
