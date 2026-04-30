package cg.hospital.endpoints;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PhysicianEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllPhysicians() throws Exception {
        mockMvc.perform(get("/api/physicians"))
            .andExpect(status().isOk())
            .andExpect(jsonPath(
                "$._embedded.physicians").isArray());
    }

    @Test
    public void testGetAllTotalElements() throws Exception {
        mockMvc.perform(get("/api/physicians"))
            .andExpect(status().isOk())
            .andExpect(jsonPath(
                "$.page.totalElements")
                .value(greaterThanOrEqualTo(9)));
    }

    @Test
    public void testGetWithPaging() throws Exception {
        mockMvc.perform(get("/api/physicians")
            .param("page","0")
            .param("size","5"))
            .andExpect(status().isOk());
    }

    @Test
    public void testFindByName() throws Exception {
        mockMvc.perform(
            get("/api/physicians/search/findByName")
            .param("name","John Dorian"))
            .andExpect(status().isOk());
    }

    @Test
    public void testFindByPosition() throws Exception {
        mockMvc.perform(
            get("/api/physicians/search/findByPosition")
            .param("position","Staff Internist"))
            .andExpect(status().isOk());
    }

    @Test
    public void testFindBySurgicalAttending()
        throws Exception {
        mockMvc.perform(
            get("/api/physicians/search/findByPosition")
            .param("position",
                "Surgical Attending Physician"))
            .andExpect(status().isOk())
            .andExpect(jsonPath(
                "$._embedded.physicians").isArray());
    }

    @Test
    public void testCreatePhysician() throws Exception {
        String json = """
            {
              "employeeId": 100,
              "name": "Test Doctor",
              "position": "Test Position",
              "ssn": 999999999
            }""";
        mockMvc.perform(post("/api/physicians")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testUpdatePhysician() throws Exception {
        String json = """
            {
              "employeeId": 1,
              "name": "John Dorian Updated",
              "position": "Staff Internist",
              "ssn": 111111111
            }""";
        mockMvc.perform(put("/api/physicians/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testFindByNameEmpty() throws Exception {
        mockMvc.perform(
            get("/api/physicians/search/findByName")
            .param("name","Nobody"))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetPhysicianById() throws Exception {
        mockMvc.perform(get("/api/physicians/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.position")
                .value("Staff Internist"))
            .andExpect(jsonPath("$.ssn")
                .value(111111111));
    }

    @Test
    public void testPhysicianNotFound() throws Exception {
        mockMvc.perform(get("/api/physicians/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testTrainedInForPhysician()
        throws Exception {
        mockMvc.perform(
            get("/api/trained-in/search/findByIdPhysician")
            .param("physician","3"))
            .andExpect(status().isOk());
    }

    @Test
    public void testTrainedInEmpty() throws Exception {
        mockMvc.perform(
            get("/api/trained-in/search/findByIdPhysician")
            .param("physician","1"))
            .andExpect(status().isOk());
    }
}