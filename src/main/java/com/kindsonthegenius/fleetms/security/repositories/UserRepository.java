package com.kindsonthegenius.fleetms.security.repositories;

import com.kindsonthegenius.fleetms.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);

    User findByEmail(String email);
}
