package com.bimurto.sampleSpringBoot.unit.ep;

import com.bimurto.sampleSpringBoot.api.model.UserRequest;
import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTestWithTestRestTemplate {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnUserWhenRequestWithId(){
        Long id = 1L;
        String name = "Name0";
        String city = "Dhaka";
        long dateMillis = 1533477604046L;
        User user = new User(id, name, city, new Date(dateMillis));
        userRepository.save(user);

        ResponseEntity<User> getUserResponseEntity = restTemplate.getForEntity("/api/user/"+id, User.class);

        User receivedUser = getUserResponseEntity.getBody();

        Assert.assertEquals("Id must be equal", id, receivedUser.getId());
        Assert.assertEquals("Name must be equal", name, receivedUser.getName());
        Assert.assertEquals("City must be equal", city, receivedUser.getCity());
        Assert.assertEquals("Data Millis must be equal", dateMillis, receivedUser.getDob().getTime());
    }

    @Test
    public void shouldSaveWhenRequestWithUser(){
        Long id = 1L;
        String name = "Name0";
        String city = "Dhaka";
        long dateMillis = 1533477604046L;
        UserRequest userRequest = new UserRequest(name, city, new Date(1533477604046L));

        ResponseEntity<User> getUserResponseEntity = restTemplate.postForEntity("/api/user", userRequest, User.class);

        User receivedUser = getUserResponseEntity.getBody();
        Long receivedId = receivedUser.getId();

        User savedUser = userRepository.findOne(receivedId);

        Assert.assertEquals("Name must be equal", name, savedUser.getName());
        Assert.assertEquals("City must be equal", city, savedUser.getCity());
        Assert.assertEquals("Data Millis must be equal", dateMillis, savedUser.getDob().getTime());
    }
}
