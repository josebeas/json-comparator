package com.jbeas.jsoncomparator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String getStatus() {
        return "RUNNING!";
    }

}
