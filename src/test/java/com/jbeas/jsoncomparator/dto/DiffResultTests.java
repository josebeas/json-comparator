package com.jbeas.jsoncomparator.dto;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class DiffResultTests {

    DiffResult classUnderTest;

    @Test
    public void testId_null_id(){
        classUnderTest = new DiffResult(null);
        assertTrue("Default id must be -1", classUnderTest.getId() == -1);
    }

    @Test
    public void testId_valid_Id(){
        classUnderTest = new DiffResult(1);
        assertTrue("Id must be 1", classUnderTest.getId() == 1);
    }

    //TODO add bunch of tests
}
