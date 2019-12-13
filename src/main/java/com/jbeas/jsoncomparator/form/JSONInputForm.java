package com.jbeas.jsoncomparator.form;

import com.jbeas.jsoncomparator.dto.InputType;


public class JSONInputForm {

    private Integer id;

    private InputType type;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InputType getType() {
        return type;
    }

    public void setType(InputType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
