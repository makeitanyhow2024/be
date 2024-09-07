package com.make_it_anyhow.restaurant.service;

import com.make_it_anyhow.restaurant.Entity.User;
import com.make_it_anyhow.restaurant.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final UserRepository userRepository;

    public void processOAuthPostLogin(OidcUser oidcUser) {
        String email = oidcUser.getEmail();
        User existUser = userRepository.findByEmail(email);

        if (existUser == null) {
            User newUser = User.builder()
                .email(email).name(oidcUser.getFullName()).build();

            userRepository.save(newUser);
        }
    }
}
