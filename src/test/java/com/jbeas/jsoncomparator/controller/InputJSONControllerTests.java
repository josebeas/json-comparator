package com.jbeas.jsoncomparator.controller;

import com.jbeas.jsoncomparator.form.JSONInputForm;
import com.jbeas.jsoncomparator.service.InputJSONService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
public class InputJSONControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InputJSONService mockService;

    @Test
    public void saveRightInput() throws Exception {

        String inputJson = "{\"type\":\"RIGHT\", \"content\":\"abc\"}";

        mockMvc.perform(post("/v1/diff/{id}/right", 1)
                .content(inputJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(mockService, times(1)).save(any(Integer.class), any(JSONInputForm.class));
    }

    @Test
    public void saveLeftInput() throws Exception {

        String inputJson = "{\"type\":\"LEFT\", \"content\":\"abc\"}";

        mockMvc.perform(post("/v1/diff/{id}/left", 1)
                .content(inputJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(mockService, times(1)).save(any(Integer.class), any(JSONInputForm.class));
    }

    @Test
    public void saveRightInput_missing_input_type() throws Exception {

        String inputJson = "{\"content\":\"abc\"}";

        mockMvc.perform(post("/v1/diff/{id}/right", 1)
                .content(inputJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(mockService, times(1)).save(any(Integer.class), any(JSONInputForm.class));
    }

    @Test
    public void saveLeftInput_missing_input_type() throws Exception {

        String inputJson = "{\"content\":\"abc\"}";

        mockMvc.perform(post("/v1/diff/{id}/left", 1)
                .content(inputJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(mockService, times(1)).save(any(Integer.class), any(JSONInputForm.class));
    }

    @Test
    public void saveRightInput_empty_content() throws Exception {

        String inputJson = "{\"type\":\"RIGHT\", \"content\":\"\"}";

        mockMvc.perform(post("/v1/diff/{id}/right", 1)
                .content(inputJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(mockService, times(1)).save(any(Integer.class), any(JSONInputForm.class));
    }

    @Test
    public void saveLeftInput_empty_content() throws Exception {

        String inputJson = "{\"type\":\"LEFT\", \"content\":\"\"}";

        mockMvc.perform(post("/v1/diff/{id}/left", 1)
                .content(inputJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(mockService, times(1)).save(any(Integer.class), any(JSONInputForm.class));
    }
}
