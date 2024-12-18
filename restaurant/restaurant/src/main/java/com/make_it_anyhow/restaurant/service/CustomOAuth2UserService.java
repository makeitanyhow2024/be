package com.make_it_anyhow.restaurant.service;

import com.make_it_anyhow.common.configuation.Constant;
import com.make_it_anyhow.restaurant.entity.User;
import com.make_it_anyhow.restaurant.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String picture = (String) attributes.get("picture");

        // 사용자 정보 저장/업데이트
        User user = userRepository.findByEmail(email)
                .orElseGet(() -> registerNewUser(email, name, picture));

        return oAuth2User;
    }

    private User registerNewUser(String email, String name, String picture) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPicture(picture);
        newUser.setProvider(Constant.AuthProvider.GOOGLE);
        return userRepository.save(newUser);
    }
}
