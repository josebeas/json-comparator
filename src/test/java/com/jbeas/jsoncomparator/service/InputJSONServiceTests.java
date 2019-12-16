package com.jbeas.jsoncomparator.service;

import com.jbeas.jsoncomparator.dto.DiffResult;
import com.jbeas.jsoncomparator.exception.MissingJSONInputException;
import com.jbeas.jsoncomparator.form.JSONInputForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
public class InputJSONServiceTests {

    @Autowired
    InputJSONService classUnderTest;

    @BeforeEach
    public void initialize(){
        classUnderTest.repository.clearJSONInputRepositories();
    }

    @Test
    public void testSave_left_element(){
        JSONInputForm inputForm =  new JSONInputForm();
        inputForm.setContent("word");
        inputForm.setType("LEFT");
        Integer id = classUnderTest.save(1, inputForm);
        assertEquals("Id must be the expected", 1, id);
    }

    @Test
    public void testCompare_missing_right_element() throws MissingJSONInputException {
        JSONInputForm leftInput =  new JSONInputForm();
        leftInput.setContent("word");
        leftInput.setType("LEFT");
        classUnderTest.save(1, leftInput);
        Assertions.assertThrows(MissingJSONInputException.class, () -> {
            classUnderTest.compare(1);
        });
    }

    @Test
    public void testCompare_missing_left_element() throws MissingJSONInputException {
        JSONInputForm rightInput =  new JSONInputForm();
        rightInput.setContent("word");
        rightInput.setType("RIGHT");
        classUnderTest.save(1, rightInput);
        Assertions.assertThrows(MissingJSONInputException.class, () -> {
            classUnderTest.compare(1);
        });
    }

    @Test
    public void testCompare_same_elements() throws MissingJSONInputException {
        JSONInputForm leftInput =  new JSONInputForm();
        leftInput.setContent("word");
        leftInput.setType("LEFT");
        classUnderTest.save(1, leftInput);
        JSONInputForm rightInput =  new JSONInputForm();
        rightInput.setContent("word");
        rightInput.setType("RIGHT");
        classUnderTest.save(1, rightInput);
        DiffResult actualResults = classUnderTest.compare(1);
        assertEquals("Id must be the expected", 1, actualResults.getId());
        assertTrue("should not be any offset present", actualResults.getOffsets().isEmpty());
    }

    @Test
    public void testCompare_different_elements_one_offset_one_char_long() throws MissingJSONInputException {
        JSONInputForm leftInput =  new JSONInputForm();
        leftInput.setContent("word");
        leftInput.setType("LEFT");
        classUnderTest.save(1, leftInput);
        JSONInputForm rightInput =  new JSONInputForm();
        rightInput.setContent("ward");
        rightInput.setType("RIGHT");
        classUnderTest.save(1, rightInput);
        DiffResult actualResults = classUnderTest.compare(1);
        assertEquals("Id must be the expected", 1,actualResults.getId());
        assertEquals("should be only one offset present", 1,actualResults.getOffsets().size());
        assertEquals("Offset should be present at position 1", 1,actualResults.getOffsets().get(0).getPosition());
        assertEquals("Offset should be 1 char long", 1, actualResults.getOffsets().get(0).getLength());
    }

    @Test
    public void testCompare_different_elements_one_offset_more_than_one_char_long() throws MissingJSONInputException {
        JSONInputForm leftInput =  new JSONInputForm();
        leftInput.setContent("comparision");
        leftInput.setType("LEFT");
        classUnderTest.save(1, leftInput);
        JSONInputForm rightInput =  new JSONInputForm();
        rightInput.setContent("compafffoon");
        rightInput.setType("RIGHT");
        classUnderTest.save(1, rightInput);
        DiffResult actualResults = classUnderTest.compare(1);
        assertEquals("Id must be the expected", 1, actualResults.getId());
        assertEquals("should be only one offset present", 1, actualResults.getOffsets().size());
        assertEquals("Offset should be present at position 5",  5, actualResults.getOffsets().get(0).getPosition());
        assertEquals("Offset should be 4 char long", 4, actualResults.getOffsets().get(0).getLength());
    }

    @Test
    public void testCompare_different_elements_some_offsets_one_char_long() throws MissingJSONInputException {
        JSONInputForm leftInput =  new JSONInputForm();
        leftInput.setContent("comparision");
        leftInput.setType("LEFT");
        classUnderTest.save(1, leftInput);
        JSONInputForm rightInput =  new JSONInputForm();
        rightInput.setContent("conparizion");
        rightInput.setType("RIGHT");
        classUnderTest.save(1, rightInput);
        DiffResult actualResults = classUnderTest.compare(1);
        assertEquals("Id must be the expected", 1, actualResults.getId());
        assertEquals("should be only one offset present", 2, actualResults.getOffsets().size());
        assertEquals("Offset should be present at position 5",  2, actualResults.getOffsets().get(0).getPosition());
        assertEquals("Offset should be 1 char long", 1, actualResults.getOffsets().get(0).getLength());
        assertEquals("Offset should be present at position 7",  7, actualResults.getOffsets().get(1).getPosition());
        assertEquals("Offset should be 1 char long", 1, actualResults.getOffsets().get(1).getLength());
    }

    @Test
    public void testCompare_different_elements_some_offsets_more_than_one_char_long() throws MissingJSONInputException {
        JSONInputForm leftInput =  new JSONInputForm();
        leftInput.setContent("comparision");
        leftInput.setType("LEFT");
        classUnderTest.save(1, leftInput);
        JSONInputForm rightInput =  new JSONInputForm();
        rightInput.setContent("connarizzzn");
        rightInput.setType("RIGHT");
        classUnderTest.save(1, rightInput);
        DiffResult actualResults = classUnderTest.compare(1);
        assertEquals("Id must be the expected", 1, actualResults.getId());
        assertEquals("should be only one offset present", 2, actualResults.getOffsets().size());
        assertEquals("Offset should be present at position 5",  2, actualResults.getOffsets().get(0).getPosition());
        assertEquals("Offset should be 2 char long", 2, actualResults.getOffsets().get(0).getLength());
        assertEquals("Offset should be present at position 7",  7, actualResults.getOffsets().get(1).getPosition());
        assertEquals("Offset should be 3 char long", 3, actualResults.getOffsets().get(1).getLength());
    }

}
