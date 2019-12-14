package com.jbeas.jsoncomparator.builer;

import com.jbeas.jsoncomparator.dto.InputType;
import com.jbeas.jsoncomparator.dto.JSONInput;
import com.jbeas.jsoncomparator.form.JSONInputForm;

public class JSONInputBuilder {

    //TODO: turn this into a GenericBuilder
    public static JSONInput buildFromForm(JSONInputForm form){
        JSONInput input = new JSONInput(InputType.getFromString(form.getType()), form.getContent());
        return input;
    }
}
