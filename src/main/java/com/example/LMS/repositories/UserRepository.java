package com.example.LMS.repositories;

import com.example.LMS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // or use findByEmail if your login uses email
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
