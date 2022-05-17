package com.springboot.application.use_cases.user.exposition;

import lombok.Data;

@Data
public class UserDto {

    public Long userId;
    public String firstname;
    public String lastname;
    public String age;
    public String email;
    public String password;

}
