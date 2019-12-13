package com.jbeas.jsoncomparator.repository;

import com.jbeas.jsoncomparator.dto.DiffResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component //TODO: move this into @Repository
public class DiffResultsRepository {

    //TODO: move this into a hibernet handled EM and a MySQL DB
    HashMap<Integer, DiffResult> entityManager = new HashMap<>();

    //TODO: add custom exceptions when entity not found
    public DiffResult getById(Integer id){
        DiffResult result = entityManager.get(id);
        if(result == null){
            //TODO: create a empty constructor defaulting values
            result = new DiffResult(-1, -1, -1);
        }
        return result;
    }

    //TODO: throw custom exceptions when entity not valid
    public void add(DiffResult entity){
        if(entity != null)
            entityManager.put(entity.getId(), entity);
    }
}
