package com.jbeas.jsoncomparator.dto;

public class DiffResult {

    //TODO: add custom exception in case null id
    private Integer id;

    private Integer offset;

    private Integer length;

    public DiffResult(Integer id, Integer offset, Integer length){
        this.id = id;
        this.offset = offset;
        this.length = length;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        if(offset != null)
            this.offset = offset;
        else
            this.offset = -1;
    }

    public Integer getLenght() {
        return length;
    }

    public void setLength(Integer length) {
        if(length != null)
            this.length = length;
        else
            this.length = -1;
    }
}
