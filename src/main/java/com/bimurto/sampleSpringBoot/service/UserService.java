package com.bimurto.sampleSpringBoot.service;

import com.bimurto.sampleSpringBoot.api.user.model.UserRequest;
import com.bimurto.sampleSpringBoot.domain.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    List<User> getUserList();

    User createUser(UserRequest request);
}
