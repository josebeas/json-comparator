package com.jbeas.jsoncomparator.exception;

/**
 * Custom exception to handle missing inputs
 */
public class MissingJSONInputException extends Exception {

    public MissingJSONInputException(String errorMessage) {
        super(errorMessage);
    }
}
