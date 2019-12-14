package com.jbeas.jsoncomparator.dto;

public class JSONInput {

    private Integer id;

    private InputType type;

    private String content;

    public JSONInput(Integer id, InputType type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public JSONInput(InputType type, String content) {
        this.type = type;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InputType getType(){
        return type;
    }

    public void setType(InputType type) {
        if(type != null)
            this.type = type;
        else
            this.type = InputType.LEFT;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(content != null)
            this.content = content;
        else
            this.content = "";
    }
}
