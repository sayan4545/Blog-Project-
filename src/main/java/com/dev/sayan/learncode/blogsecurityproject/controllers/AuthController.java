package com.dev.sayan.learncode.blogsecurityproject.controllers;

import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.AuthResponseDto;
import com.dev.sayan.learncode.blogsecurityproject.domain.dtos.LoginRequestDto;
import com.dev.sayan.learncode.blogsecurityproject.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        UserDetails userDetails = authenticationService.authenticate(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        String token = authenticationService.generateToken(userDetails);
        AuthResponseDto authResponseDto =
                AuthResponseDto.builder()
                .token(token)
                .expiresIn(86400)
                .build();
        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }
}
