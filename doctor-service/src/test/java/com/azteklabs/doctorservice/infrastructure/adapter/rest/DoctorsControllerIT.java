package com.azteklabs.doctorservice.infrastructure.adapter.rest;

import com.azteklabs.doctorservice.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
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
        this.mockMvc.perform(
                        get("/api/doctors/e2f5b1e0-f38e-4a60-9f39-1e6144e2a1be").contentType(MediaType.APPLICATION_JSON)
                )
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

    @Test
    void shouldReturnPaginatedDoctorsWithHateoasLinks() throws Exception {
        this.mockMvc.perform(
                        get("/api/doctors")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("page", "1")
                                .param("size", "4")
                ).andDo(print())
                .andExpect(jsonPath("$._embedded.doctorViewModelList[0].firstname").value("David"))
                .andExpect(jsonPath("$._embedded.doctorViewModelList[0]._links.self.href").value("http://localhost/api/doctors/9e9a0e3e-5d8e-401d-b7d9-6f5f8e7a1e38"));
    }
}