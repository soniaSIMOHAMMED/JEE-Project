package com.springboot.application.use_cases.user.infrastructure;

import com.springboot.application.use_cases.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
    User getByEmail(String email);

    Optional<User> findByEmail(String email);
}
