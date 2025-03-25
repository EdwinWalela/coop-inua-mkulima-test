package com.edwin.nexus_api;

import com.edwin.nexus_api.DTO.UserRequestDTO;
import com.edwin.nexus_api.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends BaseControllerTest{
    public UserControllerTest(){
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void allUsersShouldReturn() throws Exception{
        String response = this.mockMvc
                .perform(get("/api/user"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<User> users = this.objectMapper.readValue(response, new TypeReference<List<User>>(){});
        assertThat(users).isNotEmpty();
    }
    @Test
    void createUser() throws Exception{
        UserRequestDTO userRequest = new UserRequestDTO(
                "edwin",
                "1234",
                "edwin1@mail.com"
        );
        String jsonBody = this.objectMapper.writeValueAsString(userRequest);

        this.mockMvc
                .perform(post("/api/user")
                        .contentType("application/json")
                        .content(jsonBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"));
    }
}
