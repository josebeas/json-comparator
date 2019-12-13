package com.jbeas.jsoncomparator.dto;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class InputTypeTests {

    InputType classUnderTest;

    @Test
    public void testInputType_null_string_type(){
        classUnderTest = InputType.getFromString(null);
        assertTrue("Default input type must be LEFT", classUnderTest == InputType.LEFT);
    }

    @Test
    public void testInputType_null_integer_type(){
        classUnderTest = InputType.getFromInteger(null);
        assertTrue("Default input type must be LEFT", classUnderTest == InputType.LEFT);
    }

    @Test
    public void testInputType_RIGHT_string_parameter(){
        classUnderTest = InputType.getFromString("RIGHT");
        assertTrue("Expected RIGHT input type", classUnderTest == InputType.RIGHT);
    }

    @Test
    public void testInputType_LEFT_string_parameter(){
        classUnderTest = InputType.getFromString("LEFT");
        assertTrue("Expected LEFT input type", classUnderTest == InputType.LEFT);
    }

    @Test
    public void testInputType_EMPTY_string_parameter(){
        classUnderTest = InputType.getFromString("");
        assertTrue("Default input type must be LEFT", classUnderTest == InputType.LEFT);
    }

    @Test
    public void testInputType_0_integer_type(){
        classUnderTest = InputType.getFromInteger(0);
        assertTrue("Expected LEFT input type", classUnderTest == InputType.LEFT);
    }

    @Test
    public void testInputType_1_integer_type(){
        classUnderTest = InputType.getFromInteger(1);
        assertTrue("Expected RIGHT input type", classUnderTest == InputType.RIGHT);
    }

    @Test
    public void testInputType_invalid_integer_type(){
        classUnderTest = InputType.getFromInteger(null);
        assertTrue("Default input type must be LEFT", classUnderTest == InputType.LEFT);
    }

    //TODO add bunch of tests
}
