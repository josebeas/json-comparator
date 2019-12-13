package com.jbeas.jsoncomparator.repository;

import com.jbeas.jsoncomparator.dto.DiffResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class DiffResultsRepositoryTests {

    @Autowired
    DiffResultsRepository classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest.entityManager.clear();
    }

    @Test
    public void testAdd_null_element(){
        classUnderTest.add(null);
        assertTrue("No null element should be added", classUnderTest.entityManager.size() == 0);
    }

    @Test
    public void testAdd_valid_element(){
        DiffResult result = new DiffResult(1, 0, 0);
        classUnderTest.add(result);
        assertTrue("Element should be present", classUnderTest.entityManager.size() == 1);
    }

    @Test
    public void testGetById_element_integrity(){
        DiffResult result = new DiffResult(1, 0, 0);
        classUnderTest.add(result);
        DiffResult found = classUnderTest.getById(1);
        assertTrue("Element should be present", found.getId() == 1);
    }

    @Test
    public void testGetById_element_integrity_negative(){
        DiffResult result = new DiffResult(1, 0, 0);
        classUnderTest.add(result);
        DiffResult found = classUnderTest.getById(2);
        assertFalse("Element should not be present", found.getId() == 1);
    }

    //TODO: add more tests
}
