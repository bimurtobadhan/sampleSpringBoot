package com.bimurto.sampleSpringBoot.service;

import com.bimurto.sampleSpringBoot.api.user.model.UserRequest;
import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id){
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserRequest request){
        User user = User.builder()
                .name(request.getName())
                .city(request.getCity())
                .dob(request.getDob())
                .build();
        return userRepository.save(user);
    }

}
