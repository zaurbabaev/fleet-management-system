package com.kindsonthegenius.fleetms.security.services;

import com.kindsonthegenius.fleetms.security.models.SecureToken;
import com.kindsonthegenius.fleetms.security.repositories.SecureTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class DefaultSecureTokenService implements SecureTokenService {

    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(12);

    private final SecureTokenRepository secureTokenRepository;

    @Value("2800")
    private int tokenValiditySeconds;


    @Override
    public SecureToken createToken() {
        String tokenValue = Base64.getEncoder().encodeToString(DEFAULT_TOKEN_GENERATOR.generateKey());
        SecureToken secureToken = SecureToken
                .builder()
                .token(tokenValue)
                .expiredAt(LocalDateTime.now().plusSeconds(tokenValiditySeconds))
                .build();
        this.saveSecureToken(secureToken);
        return secureToken;
    }

    @Override
    public void saveSecureToken(SecureToken secureToken) {
        secureTokenRepository.save(secureToken);
    }

    @Override
    public SecureToken findByToken(String token) {
        return secureTokenRepository.findByToken(token);
    }

    @Override
    public void removeToken(SecureToken token) {
        secureTokenRepository.delete(token);
    }
}
