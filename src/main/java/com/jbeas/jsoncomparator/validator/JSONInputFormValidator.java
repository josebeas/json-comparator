package com.jbeas.jsoncomparator.validator;

import com.jbeas.jsoncomparator.form.JSONInputForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Spring validator for Json inputs
 */
@Component
public class JSONInputFormValidator  implements Validator {

    public boolean supports(Class clazz) {
        return JSONInputForm.class.equals(clazz);
    }

    /**
     * Validates given input form based on business logic defined
     * @param object object to be validated
     * @param e list of actual errors
     */
    public void validate(Object object, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "content", "content must not be null or empty");
        JSONInputForm input = (JSONInputForm) object;
        if (input.getType() == null || input.getType().isEmpty()) {
            e.rejectValue("type", "type cannot be null or empty");
        }
    }
}
