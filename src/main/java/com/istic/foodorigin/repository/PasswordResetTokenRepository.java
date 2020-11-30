package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.ERole;
import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);
}
