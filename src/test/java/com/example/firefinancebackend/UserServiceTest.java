package com.example.firefinancebackend;

import com.example.firefinancebackend.domain.User;
import com.example.firefinancebackend.repository.UserRepository;
import com.example.firefinancebackend.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void shouldGetUserByIdOf1() {
        String email = "veryrealemail@gmail.com";

        User dummyUser = new User();
        dummyUser.setEmail(email);
        dummyUser.setPassword("123ASD123");

        Long id = 1L;

        when(userRepository.findById(id)).thenReturn(Optional.of(dummyUser));

        assertThat(userService.getUser(id).getEmail()).isEqualTo(email);
    }

    @Test
    void shouldCreateUser() {
        String email = "myemail@gmail.com";

        User dummyUser = new User();
        dummyUser.setEmail(email);
        dummyUser.setPassword("abc");

        when(userRepository.save(dummyUser)).thenReturn(dummyUser);

        assertThat(userService.createUser(dummyUser).getEmail()).isEqualTo(email);
    }
}
