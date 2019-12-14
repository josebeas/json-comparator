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

@RestController
public class InputJSONController {

    @Autowired
    private JSONInputFormValidator inputFormValidator;

    @Autowired
    private InputJSONService inputService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(inputFormValidator);
    }

    @RequestMapping(value = "/v1/input/status")
    public String getStatus() {
        return "JSON INPUT CONTROLLER IS RUNNING!";
    }

    @PostMapping(value = "/v1/diff/{id}/left", consumes = MediaType.APPLICATION_JSON_VALUE)
    Integer saveLeftInput(@PathVariable @Min(1) Integer id, @Valid @RequestBody JSONInputForm input) {
        return inputService.save(id, input);
    }

    @PostMapping(value = "/v1/diff/{id}/right", consumes = MediaType.APPLICATION_JSON_VALUE)
    Integer saveRightInput(@PathVariable @Min(1) Integer id, @Valid @RequestBody JSONInputForm input) {
        return inputService.save(id, input);
    }
}
