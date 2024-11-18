package com.kindsonthegenius.fleetms.security.services;

import com.kindsonthegenius.fleetms.exceptions.InvalidTokenException;
import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.exceptions.UserAlreadyExistException;
import com.kindsonthegenius.fleetms.mailing.AccountVerificationEmailContext;
import com.kindsonthegenius.fleetms.mailing.EmailService;
import com.kindsonthegenius.fleetms.security.models.SecureToken;
import com.kindsonthegenius.fleetms.security.models.User;
import com.kindsonthegenius.fleetms.security.repositories.UserRepository;
import javax.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {


    @Value("${site.base.url.https}")
    private String baseUrl;

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final SecureTokenService secureTokenService;
    private final EmailService emailService;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public void register(User user) throws UserAlreadyExistException {
        if (checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("This user already exist");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        sendRegistrationConfirmationEmail(user);

    }

    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public void sendRegistrationConfirmationEmail(User user)  {
        SecureToken secureToken = secureTokenService.createToken();
        secureToken.setUser(user);
        secureTokenService.saveSecureToken(secureToken);

        AccountVerificationEmailContext context = new AccountVerificationEmailContext();
        context.init(user);
        context.setToken(secureToken.getToken());
        context.buildVerificationUrl(baseUrl, secureToken.getToken());

        try {
            emailService.sendMail(context);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyUser(String token) throws InvalidTokenException {
        SecureToken secureToken = secureTokenService.findByToken(token);
        if (Objects.isNull(token) || !StringUtils.equals(token, secureToken.getToken()) || secureToken.isExpired()) {
            throw new InvalidTokenException("Token is not valid");
        }
        User user = getById(secureToken.getUser().getId());
        if (Objects.isNull(user)) {
            return false;
        }
        user.setAccountVerified(true);
        userRepository.save(user);

        secureTokenService.removeToken(secureToken);
        return true;
    }


}
