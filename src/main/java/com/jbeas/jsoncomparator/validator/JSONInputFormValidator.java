package com.jbeas.jsoncomparator.validator;

import com.jbeas.jsoncomparator.dto.JSONInput;
import com.jbeas.jsoncomparator.form.JSONInputForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;


@Component
public class JSONInputFormValidator {

    public boolean supports(Class clazz) {
        return JSONInputForm.class.equals(clazz);
    }

    public void validate(Object object, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "jsoninput.content", "jsoninput.content");
        JSONInput input = (JSONInput) object;
        if (input.getId() == null || input.getId() < 0) {
            e.rejectValue("id", "jsoninput.id");
        }
        if (input.getType() == null) {
            e.rejectValue("type", "jsonninput.type");
        }
    }
}
