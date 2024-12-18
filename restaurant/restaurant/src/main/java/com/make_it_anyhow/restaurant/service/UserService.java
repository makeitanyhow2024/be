package com.make_it_anyhow.restaurant.service;

import com.make_it_anyhow.restaurant.entity.User;
import com.make_it_anyhow.restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void processOAuthPostLogin(OidcUser oidcUser) {
        String email = oidcUser.getEmail();
        Optional<User> existUser = userRepository.findByEmail(email);

        if (existUser == null) {
            User newUser = User.builder()
                .email(email).name(oidcUser.getFullName()).build();

            userRepository.save(newUser);
        }
    }
}
