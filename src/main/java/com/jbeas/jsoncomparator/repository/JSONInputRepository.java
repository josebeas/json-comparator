package com.jbeas.jsoncomparator.repository;

import com.jbeas.jsoncomparator.dto.InputType;
import com.jbeas.jsoncomparator.dto.JSONInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component //TODO: Move this into a @Repository
public class JSONInputRepository {

    private static final Logger logger = LoggerFactory.getLogger(JSONInputRepository.class);

    //TODO: move this into a hibernet handled EM and a MySQL DB
    HashMap<Integer, JSONInput> leftEntityManager = new HashMap<>();
    HashMap<Integer, JSONInput> rightEntityManager = new HashMap<>();

    //TODO: add custom exceptions when entity not found
    public JSONInput getById(Integer id, InputType type){
        JSONInput result = new JSONInput();
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

    public void add(JSONInput entity){
        if(entity != null)
            switch(entity.getType()){
                case LEFT:
                    leftEntityManager.put(entity.getId(), entity);
                    logger.info("Entities on LEFT repository");
                    for(Integer key : leftEntityManager.keySet()) {
                        logger.info(leftEntityManager.get(key).toString());
                    }
                    break;
                case RIGHT:
                    rightEntityManager.put(entity.getId(), entity);
                    logger.info("Entities on RIGHT repository");
                    for(Integer key : rightEntityManager.keySet()) {
                        logger.info(rightEntityManager.get(key).toString());
                    }
                    break;
            }
    }

    public void clearJSONInputRepositories(){
        this.leftEntityManager.clear();
        this.rightEntityManager.clear();
    }
}
