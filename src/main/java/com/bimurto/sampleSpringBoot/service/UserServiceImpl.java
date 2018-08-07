package com.bimurto.sampleSpringBoot.service;

import com.bimurto.sampleSpringBoot.api.model.UserRequest;
import com.bimurto.sampleSpringBoot.dao.UserDao;
import com.bimurto.sampleSpringBoot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(Long id){
        return userDao.findOne(id);
    }

    @Override
    public List<User> getUserList(){
        return userDao.findAll();
    }

    @Override
    public User createUser(UserRequest request){
        User user = User.builder()
                .name(request.getName())
                .city(request.getCity())
                .dob(request.getDob())
                .build();
        return userDao.save(user);
    }

}
