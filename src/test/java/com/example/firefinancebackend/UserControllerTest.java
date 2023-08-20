package com.example.firefinancebackend;

import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.services.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;

    @Test
    void shouldGetUserByIdOf1() throws Exception {
        String dummyEmail = "dummyuser@gmail.com";

        User dummyUser = new User();
        dummyUser.setEmail(dummyEmail);

        when(userService.getUser(1L)).thenReturn(dummyUser);

        mockMvc.perform(get("/api/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.email").value(dummyEmail));
    }

    @Test
    void shouldCreateUser() throws Exception {
        User dummyUser = new User();
        dummyUser.setEmail("realemail@gmail.com");
        dummyUser.setPassword("123ASD");

        String dummyJSON = toJson(dummyUser);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dummyJSON))
                .andExpect(status().isOk());
    }

    private static String toJson(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
