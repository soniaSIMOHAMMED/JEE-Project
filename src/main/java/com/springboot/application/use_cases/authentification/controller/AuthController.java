package com.springboot.application.use_cases.authentification.controller;

import com.springboot.application.use_cases.authentification.exposition.LoginDto;
import com.springboot.application.use_cases.user.domain.User;
import com.springboot.application.use_cases.user.infrastructure.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authentificateUser(@RequestBody LoginDto loginDto){

        if(userRepository.existsByEmail(loginDto.getEmail())){
            User user = userRepository.getByEmail(loginDto.getEmail());
            if(loginDto.getPassword().equals(user.getPassword())){
                return new ResponseEntity<>("User loged in successfully", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Incorrect password", HttpStatus.UNAUTHORIZED);
            }
        }else{
            return new ResponseEntity<>("User does not exist in database", HttpStatus.NOT_FOUND);
        }


    }



}
