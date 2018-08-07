package com.bimurto.sampleSpringBoot.repository;

import com.bimurto.sampleSpringBoot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long > {
    List<User> findByName(String name);
}
