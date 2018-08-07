package com.bimurto.sampleSpringBoot.dao;

import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shawrup on 07-Aug-18.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final UserRepository repository;

    @Autowired
    public UserDaoImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
