package com.bimurto.sampleSpringBoot.unit.ep;

import com.bimurto.sampleSpringBoot.api.UserController;
import com.bimurto.sampleSpringBoot.api.model.UserRequest;
import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class UserControllerTestWithMockito {

    private MockMvc mockMvc;

    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init(){

        userService = mock(UserService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldReturnUserWhenRequestWithId() throws Exception {

        when(userService.getUser(1L)).thenReturn(new User(1L,"Name0","Dhaka", new Date(1533477604046L)));


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

        when(userService.createUser(userRequest)).thenReturn(user);

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
