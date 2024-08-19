package com.make_it_anyhow.restaurant.user.controller;

import com.make_it_anyhow.restaurant.user.dto.ResponseDto;
import com.make_it_anyhow.restaurant.user.dto.UserLoginDto;
import com.make_it_anyhow.restaurant.user.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/worklist")
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;
    @Operation(summary = "login", description = "사용자 로그인")
    @PostMapping("/login")
    public ResponseEntity<ResponseDto<Void>> login(@RequestBody @Validated UserLoginDto userDto) {
        return ResponseEntity.ok(
            ResponseDto.buildSuccessResponse(null)
        );
    }
}
