package com.bimurto.sampleSpringBoot.repository;

import com.bimurto.sampleSpringBoot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
}
