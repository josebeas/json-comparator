package com.jbeas.jsoncomparator.validator;

import com.jbeas.jsoncomparator.form.DiffResultsForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;


@Component
public class DiffResultsFormValidator {

    public boolean supports(Class clazz) {
        return DiffResultsForm.class.equals(clazz);
    }

    public void validate(Object object, Errors e) {
        DiffResultsForm resuls = (DiffResultsForm) object;
        if (resuls.getId() == null || resuls.getId() < 0) {
            e.rejectValue("id", "diffresults.id");
        }
        if (resuls.getLength() == null || resuls.getLength() < 0) {
            e.rejectValue("length", "diffresults.length");
        }
        if (resuls.getOffset() == null || resuls.getOffset() < 0) {
            e.rejectValue("offset", "diffresults.offset");
        }
    }
}
