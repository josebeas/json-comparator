package com.jbeas.jsoncomparator.dto;

import java.util.ArrayList;
import java.util.List;

public class DiffResult {

    //TODO: add custom exception in case null id
    private Integer id;

    private List<Integer> offsets;

    private Integer length;

    public DiffResult(Integer id, Integer offset, Integer length){
        this.id = id;
        this.offsets = new ArrayList<>();
        this.length = length;
    }

    public DiffResult(Integer id){
        this.id = id;
        this.offsets = new ArrayList<>();
        this.length = -1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getOffsets() {
        return offsets;
    }

    public void setOffset(List<Integer> offsets) {
        if(offsets != null)
            this.offsets = offsets;
        else
            this.offsets = new ArrayList<>();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        if(length != null)
            this.length = length;
        else
            this.length = -1;
    }
}
