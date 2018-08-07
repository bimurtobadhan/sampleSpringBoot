package com.bimurto.sampleSpringBoot.dao;

import com.bimurto.sampleSpringBoot.domain.User;

import java.util.List;

/**
 * Created by Shawrup on 07-Aug-18.
 */
public interface UserDao {
    User save(User user);
    User findOne(Long id);
    List<User> findAll();
}
