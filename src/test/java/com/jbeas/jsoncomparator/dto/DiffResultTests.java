package com.jbeas.jsoncomparator.dto;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class DiffResultTests {

    DiffResult classUnderTest;

    @Test
    public void testLength_null_length(){
        classUnderTest = new DiffResult(null, null, null);
        classUnderTest.setLength(null);
        assertTrue("Default input type must be LEFT", classUnderTest.getLength() == -1);
    }

    @Test
    public void testLength_valid_length(){
        classUnderTest = new DiffResult(null, null, null);
        classUnderTest.setLength(1);
        assertTrue("Default input type must be LEFT", classUnderTest.getLength() == 1);
    }

    //TODO add bunch of tests
}
