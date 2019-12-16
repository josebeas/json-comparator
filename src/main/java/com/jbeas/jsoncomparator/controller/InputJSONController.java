package com.jbeas.jsoncomparator.controller;


import com.jbeas.jsoncomparator.form.JSONInputForm;
import com.jbeas.jsoncomparator.service.InputJSONService;
import com.jbeas.jsoncomparator.validator.JSONInputFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Controller to store both inputs, LEFT and RIGHT
 *
 * @author Jose Beas
 * @version 1.0
 */
@RestController
public class InputJSONController {

    /**
     * Spring validator for inputs
     */
    @Autowired
    private JSONInputFormValidator inputFormValidator;

    /**
     * Service to search and store inputs
     */
    @Autowired
    private InputJSONService inputService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(inputFormValidator);
    }

    /**
     * Debug endpoint to confirm that this controller stills alive
     * @return hard coded string for this controller
     */
    @RequestMapping(value = "/v1/input/status")
    public String getStatus() {
        return "JSON INPUT CONTROLLER IS RUNNING!";
    }

    /**
     * Stores given input on RIGHT repository only if it valid
     * @param id id to be stored
     * @param input form with information to be stored
     * @return id of given input if it was stored
     */
    @PostMapping(value = "/v1/diff/{id}/left", consumes = MediaType.APPLICATION_JSON_VALUE)
    Integer saveLeftInput(@PathVariable @Min(1) Integer id, @Valid @RequestBody JSONInputForm input) {
        return inputService.save(id, input);
    }

    /**
     * Stores given input on RIGHT repository only if it valid
     * @param id id to store
     * @param input form with information to be stored
     * @return id of given input if stored
     */
    @PostMapping(value = "/v1/diff/{id}/right", consumes = MediaType.APPLICATION_JSON_VALUE)
    Integer saveRightInput(@PathVariable @Min(1) Integer id, @Valid @RequestBody JSONInputForm input) {
        return inputService.save(id, input);
    }
}
