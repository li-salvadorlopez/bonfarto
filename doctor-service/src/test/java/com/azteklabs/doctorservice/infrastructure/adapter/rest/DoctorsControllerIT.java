package com.azteklabs.doctorservice.infrastructure.adapter.rest;

import com.azteklabs.doctorservice.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class DoctorsControllerIT extends BaseIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldReturn200() throws Exception {
        this.mockMvc.perform(get("/api/doctors/e2f5b1e0-f38e-4a60-9f39-1e6144e2a1be"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpectAll(
                        jsonPath("$.id").value("e2f5b1e0-f38e-4a60-9f39-1e6144e2a1be"),
                        jsonPath("$.firstname").value("John"),
                        jsonPath("$.lastname").value("Doe"),
                        jsonPath("$.addresses[0].street").value("123 Elm St"),
                        jsonPath("$.addresses[0].city").value("Springfield"),
                        jsonPath("$.addresses[0].state").value("IL")
                );
    }
}