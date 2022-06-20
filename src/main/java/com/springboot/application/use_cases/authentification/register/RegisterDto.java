package com.springboot.application.use_cases.authentification.register;

import lombok.Data;

@Data
public class RegisterDto {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
}
