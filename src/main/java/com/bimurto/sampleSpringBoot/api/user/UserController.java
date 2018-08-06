package com.bimurto.sampleSpringBoot.api.user;

import com.bimurto.sampleSpringBoot.api.user.model.UserRequest;
import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
    public List<User> getUserList(@PathVariable Long id){
        return userService.getUserList();
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public User getUserList(@RequestBody @Valid UserRequest request){
        log.info("Request {}", request);
        User user = userService.createUser(request);
        return user;
    }
}
