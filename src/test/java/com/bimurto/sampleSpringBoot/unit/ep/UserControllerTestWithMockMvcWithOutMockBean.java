package com.bimurto.sampleSpringBoot.unit.ep;

import com.bimurto.sampleSpringBoot.api.user.model.UserRequest;
import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestWithMockMvcWithOutMockBean {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup(){
        User user = new User(1L, "Name0", "Dhaka", new Date(1533477604046L));
        userRepository.save(user);
    }

    @Test
    public void shouldReturnUserWhenRequestWithId() throws Exception {
        User user = new User(1L, "Name0", "Dhaka", new Date(1533477604046L));
        mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(user)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void shouldSaveWhenRequestWithUser() throws Exception {
        UserRequest userRequest = new UserRequest("Name0", "Dhaka", new Date(1533477604046L));
        User user = new User(2L, "Name0", "Dhaka", new Date(1533477604046L));

        mockMvc.perform(
                post("/api/user")
                       .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(asJsonString(userRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        .andExpect(content().json(asJsonString(user)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
