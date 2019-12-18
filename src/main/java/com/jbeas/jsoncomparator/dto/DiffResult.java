package com.jbeas.jsoncomparator.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO to store differences between inputs with given id
 */
public class DiffResult {

    private Integer id;

    private String result;

    private List<Offset> offsets;

    public DiffResult(Integer id, List<Offset> offsets){
        this.id = id;
        this.offsets = new ArrayList<>();
    }

    public DiffResult(Integer id){
        this.id = id!=null?id:-1;
        this.offsets = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Offset> getOffsets() {
        return offsets;
    }

    public void setOffset(List<Offset> offsets) {
        if(offsets != null)
            this.offsets = offsets;
        else
            this.offsets = new ArrayList<>();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
