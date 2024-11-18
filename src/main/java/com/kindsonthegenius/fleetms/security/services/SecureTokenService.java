package com.kindsonthegenius.fleetms.security.services;

import com.kindsonthegenius.fleetms.security.models.SecureToken;

public interface SecureTokenService {
    SecureToken createToken();

    void saveSecureToken(SecureToken secureToken);

    SecureToken findByToken(String token);

    void removeToken(SecureToken token);
}
