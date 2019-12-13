package com.jbeas.jsoncomparator.repository;

import com.jbeas.jsoncomparator.dto.InputType;
import com.jbeas.jsoncomparator.dto.JSONInput;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component //TODO: Move this into a @Repository
public class JSONInputRepository {

    //TODO: move this into a hibernet handled EM and a MySQL DB
    HashMap<Integer, JSONInput> leftEntityManager = new HashMap<>();
    HashMap<Integer, JSONInput> rightEntityManager = new HashMap<>();

    //TODO: add custom exceptions when entity not found
    public JSONInput getById(Integer id, InputType type){
        //TODO: create a empty constructor defaulting values
        JSONInput result = new JSONInput(null, null);
        switch(type){
            case LEFT:
                result = leftEntityManager.get(id);
                break;
            case RIGHT:
                result = rightEntityManager.get(id);
                break;
        }
        return result;
    }

    //TODO: throw custom exceptions when entity not valid
    public void add(JSONInput entity){
        if(entity != null)
            switch(entity.getType()){
                case LEFT:
                    leftEntityManager.put(entity.getId(), entity);
                    break;
                case RIGHT:
                    rightEntityManager.put(entity.getId(), entity);
                    break;
            }
    }
}
