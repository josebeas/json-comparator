package com.jbeas.jsoncomparator.controller;


import com.jbeas.jsoncomparator.form.JSONInputForm;
import com.jbeas.jsoncomparator.service.InputJSONService;
import com.jbeas.jsoncomparator.utils.StringUtils;
import com.jbeas.jsoncomparator.validator.JSONInputFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.UnsupportedEncodingException;

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
    @RequestMapping(value = "/v1/input/status", method = RequestMethod.GET)
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
    Integer saveLeftInput(@PathVariable("id") @Min(1) Integer id, @Valid @RequestBody JSONInputForm input) {
        return inputService.save(id, input);
    }

    /**
     * Stores given input on RIGHT repository only if it valid
     * @param id id to store
     * @param input form with information to be stored
     * @return id of given input if stored
     */
    @PostMapping(value = "/v1/diff/{id}/right", consumes = MediaType.APPLICATION_JSON_VALUE)
    Integer saveRightInput(@PathVariable("id") @Min(1) Integer id, @Valid @RequestBody JSONInputForm input) {
        return inputService.save(id, input);
    }

    /**
     * Encodes given string into Base64 using utf-8 charset url safe
     * @param input string to be encoded
     * @return encoded string
     */
    @RequestMapping(value = "/v1/input/encode", method = RequestMethod.GET)
    public String encodeString(@RequestParam("input") String input) throws UnsupportedEncodingException {
        return StringUtils.encode(input);
    }

    /**
     * Decodes given url safe string from Base64 and utf-8 charset
     * @param input string to be decoded
     * @return decoded string
     */
    @RequestMapping(value = "/v1/input/decode", method = RequestMethod.GET)
    public String decodeString(@RequestParam("input") String input) throws UnsupportedEncodingException {
        return StringUtils.decode(input);
    }

}
