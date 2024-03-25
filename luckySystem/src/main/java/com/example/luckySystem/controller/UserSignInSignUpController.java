package com.example.luckySystem.controller;

import com.example.luckySystem.config.UserAuthenticationProvider;
import com.example.luckySystem.dto.CredentialsDto;
import com.example.luckySystem.dto.SignUpDto;
import com.example.luckySystem.dto.UserDto;
import com.example.luckySystem.exceptions.EmployeeIDAlreadyExistsException;
import com.example.luckySystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserSignInSignUpController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/userlogin")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }
    @PostMapping("/userregister")
    public ResponseEntity<?> register(@RequestBody @Valid SignUpDto user) {

        try {
            UserDto createdUser = userService.register(user);
            createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (EmployeeIDAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
