package com.springboot.application.use_cases.user.service;

import com.springboot.application.use_cases.user.exposition.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userdto);
    UserDto getUserById(long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto, Long userId);
    void deleteUser(long userId);
}
