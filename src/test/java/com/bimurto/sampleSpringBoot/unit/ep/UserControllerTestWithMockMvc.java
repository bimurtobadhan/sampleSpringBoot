package com.bimurto.sampleSpringBoot.unit.ep;

import com.bimurto.sampleSpringBoot.api.user.model.UserRequest;
import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTestWithMockMvc {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void shouldReturnUserWhenRequestWithId() throws Exception {

        given(userService.getUser(1L)).willReturn(new User(1L, "Name0", "Dhaka", new Date(1533477604046L)));

        String jsonString = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Name0\",\n" +
                "    \"city\": \"Dhaka\",\n" +
                "    \"dob\": 1533477604046\n" +
                "}";
        mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonString))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

    @Test
    public void shouldSaveWhenRequestWithUser() throws Exception {
        UserRequest userRequest = new UserRequest("Name0", "Dhaka", new Date(1533477604046L));
        User user = new User(1L, "Name0", "Dhaka", new Date(1533477604046L));

        given(userService.createUser(userRequest)).willReturn(user);

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
