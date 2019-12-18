package com.jbeas.jsoncomparator.controller;

import com.jbeas.jsoncomparator.service.DiffResultsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//TODO: ensure exception handler is being called in this tests
@SpringBootTest
@AutoConfigureMockMvc
public class DiffResultsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiffResultsService mockService;

    @Test
    public void diff_id_present() throws Exception {
        mockMvc.perform(get("/v1/diff/{id}", 1)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        verify(mockService, times(1)).compare(any(Integer.class));
    }

    @Test
    @Disabled("Disabled until custom exception handles is being called on tests")
    public void diff_invalid_id_present() throws Exception {

        mockMvc.perform(get("/v1/diff/-1")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());

        verify(mockService, times(0)).compare(any(Integer.class));
    }
}
