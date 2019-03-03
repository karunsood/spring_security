package com.karunsood.security.DBExample.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karunsood.security.DBExample.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
