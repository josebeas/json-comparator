package com.jbeas.jsoncomparator.form;

public class JSONInputForm {

    private String type;

    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return "{\"type\":\"" + this.type + "\", \"content\":\""+ this.content + "\"}";
    }
}
