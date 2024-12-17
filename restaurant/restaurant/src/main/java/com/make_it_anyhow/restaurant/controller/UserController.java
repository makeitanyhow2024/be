package com.make_it_anyhow.restaurant.controller;

import com.make_it_anyhow.restaurant.dto.UserLoginDto;
import com.make_it_anyhow.restaurant.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> getCurrentUser(@AuthenticationPrincipal OAuth2User principal) {
        return Map.of(
                "email", principal.getAttribute("email"),
                "name", principal.getAttribute("name"),
                "picture", principal.getAttribute("picture")
        );
    }
}
