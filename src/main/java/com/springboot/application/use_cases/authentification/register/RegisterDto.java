package com.springboot.application.use_cases.authentification.register;

import lombok.Data;

@Data
public class RegisterDto {
    public String firstname;
    public String lastname;
    public String email;
    public String password;
}
