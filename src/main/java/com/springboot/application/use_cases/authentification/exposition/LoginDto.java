package com.springboot.application.use_cases.authentification.exposition;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
