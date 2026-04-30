package cg.hospital.endpoints;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
public class NurseEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllNurses() throws Exception {
        mockMvc.perform(get("/api/nurse"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.nurses").exists());
    }

    @Test
    void testGetNurseById() throws Exception {
        mockMvc.perform(get("/api/nurse/101"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.position").exists());
    }

    @Test
    void testCreateNurse() throws Exception {
        String body = """
        {
          "employeeId": 199,
          "name": "Test Nurse",
          "position": "Nurse",
          "registered": true,
          "ssn": 123456789
        }
        """;

        mockMvc.perform(post("/api/nurse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateNurse() throws Exception {

        String body = """
        {
          "employeeId": 101,
          "name": "Updated Nurse",
          "position": "Head Nurse",
          "registered": false,
          "ssn": 888888
        }
        """;

        mockMvc.perform(put("/api/nurse/101")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/nurse/101"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Nurse"))
                .andExpect(jsonPath("$.position").value("Head Nurse"))
                .andExpect(jsonPath("$.registered").value(false));
    }
}