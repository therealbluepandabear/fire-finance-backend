package com.example.firefinancebackend;

import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FireFinanceBackendApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void shouldGetUserByIdOf1() throws Exception {
        String dummyEmail = "dummyuser@gmail.com";

        User dummyUser = new User();
        dummyUser.setEmail(dummyEmail);

        when(userService.getUserById(1L)).thenReturn(dummyUser);

        mockMvc.perform(get("/api/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.email").value(dummyEmail));
    }
}
