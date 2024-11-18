package com.kindsonthegenius.fleetms.security.repositories;

import com.kindsonthegenius.fleetms.security.models.SecureToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecureTokenRepository extends JpaRepository<SecureToken, Long> {

    SecureToken findByToken(String token);

    Long removeByToken(String token);


}
