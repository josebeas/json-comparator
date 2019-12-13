package com.jbeas.jsoncomparator.dto;

public enum InputType {
    LEFT("left"), RIGHT("right");

    private String type;

    InputType(String type){
        this.type = type;
    }

    //This could add a easier way to bind object
    static InputType getFromInteger(Integer type){
        if(type == null)
            type = 0;
        switch(type) {
            case 0:
                return InputType.LEFT;
            case 1:
                return InputType.RIGHT;
            default:
                return InputType.LEFT;
        }
    }

    static InputType getFromString(String type){
        if(type != null && type.equalsIgnoreCase("RIGHT"))
            return RIGHT;
        return LEFT;
    }

    public String getType(){
        return this.type;
    }

}
