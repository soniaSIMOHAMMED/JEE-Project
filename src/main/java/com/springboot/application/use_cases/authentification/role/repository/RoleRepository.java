package com.springboot.application.use_cases.authentification.role.repository;

import com.springboot.application.use_cases.authentification.role.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role);
}
