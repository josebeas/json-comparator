package com.jbeas.jsoncomparator.dto;

/**
 * POJO to store actual differences between inputs
 */
public class Offset {

    Integer position;

    Integer length;

    //In case needed here can be added a content string variable to store actual difference

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
