package com.dmart.store.repository;

import com.dmart.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(String role);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
