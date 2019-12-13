package com.jbeas.jsoncomparator.dto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class JSONInputTests {

    JSONInput classUnderTest;

    @BeforeEach
    public void setUp(){
        classUnderTest = new JSONInput(null, null, null);
    }

    @Test
    public void testInputType_null_type(){
        classUnderTest.setType(InputType.getFromString(null));
        classUnderTest.getType();
        assertTrue("Default input type must be LEFT", classUnderTest.getType() == InputType.LEFT);
    }

    //TODO add bunch of tests
}
