package com.kindsonthegenius.fleetms.mailing;

import com.kindsonthegenius.fleetms.security.models.User;
import org.springframework.web.util.UriComponentsBuilder;

public class AccountVerificationEmailContext extends AbstractEmailContext {

    private String token;

    @Override
    public <T> void init(T context) {
        User user = (User) context;

        put("firstname", user.getFirstname());
        setTemplateLocation("mailing/email-verification");
        setSubject("Complete Your Registration");
        setFrom("testspringboot2024@gmail.com");
        if (isValidEmail(user.getEmail())) {
            setTo(user.getEmail());
        } else {
            throw new IllegalArgumentException("Invalid email format: " + user.getEmail());
        }

    }

    public void setToken(String token) {
        this.token = token;
        put("token", token);
    }

    public void buildVerificationUrl(final String baseURL, final String token) {
        final String url = UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("/register/verify").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
