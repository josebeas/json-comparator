package com.jbeas.jsoncomparator.repository;

import com.jbeas.jsoncomparator.dto.InputType;
import com.jbeas.jsoncomparator.dto.JSONInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class JSONInputRepositoryTests {

    @Autowired
    JSONInputRepository classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest.leftEntityManager.clear();
        classUnderTest.rightEntityManager.clear();
    }

    @Test
    public void testAdd_null_element(){
        classUnderTest.add(null);
        assertTrue("No null element should be added", classUnderTest.leftEntityManager.size() == 0);
        assertTrue("No null element should be added", classUnderTest.rightEntityManager.size() == 0);
    }

    @Test
    public void testAdd_valid_RIGHT_element(){
        JSONInput input = new JSONInput(1, InputType.RIGHT, "");
        classUnderTest.add(input);
        assertTrue("No null element should be added", classUnderTest.leftEntityManager.size() == 0);
        assertTrue("No null element should be added", classUnderTest.rightEntityManager.size() == 1);
    }

    @Test
    public void testAdd_valid_LEFT_element(){
        JSONInput input = new JSONInput(1, InputType.LEFT, "");
        classUnderTest.add(input);
        assertTrue("No null element should be added", classUnderTest.leftEntityManager.size() == 1);
        assertTrue("No null element should be added", classUnderTest.rightEntityManager.size() == 0);
    }

    @Test
    public void testGetById_LEFT_element(){
        JSONInput input = new JSONInput(1, InputType.LEFT, "");
        classUnderTest.add(input);
        JSONInput found = classUnderTest.getById(1, InputType.LEFT);
        assertTrue("Found wrong element", found.getId() == 1);
    }

    @Test
    public void testGetById_RIGHT_element(){
        JSONInput input = new JSONInput(1, InputType.RIGHT, "");
        classUnderTest.add(input);
        JSONInput found = classUnderTest.getById(1, InputType.RIGHT);
        assertTrue("Found wrong element", found.getId() == 1);
    }

    @Test
    public void testGetById_RIGHT_element_not_found_wrong_id(){
        JSONInput input = new JSONInput(1, InputType.RIGHT, "");
        classUnderTest.add(input);
        JSONInput found = classUnderTest.getById(2, InputType.RIGHT);
        assertNull("Found wrong element", found);
    }

    @Test
    public void testGetById_RIGHT_element_not_found_wrong_type(){
        JSONInput input = new JSONInput(1, InputType.RIGHT, "");
        classUnderTest.add(input);
        JSONInput found = classUnderTest.getById(2, InputType.LEFT);
        assertNull("Found wrong element", found);
    }
    //TODO: add more tests

}
