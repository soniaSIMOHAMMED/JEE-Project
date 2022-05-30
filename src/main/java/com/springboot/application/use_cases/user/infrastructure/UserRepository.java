package com.springboot.application.use_cases.user.infrastructure;

import com.springboot.application.use_cases.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);
    User getByEmail(String email);

}
