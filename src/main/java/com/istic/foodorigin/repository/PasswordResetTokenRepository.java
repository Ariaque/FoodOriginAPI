package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * End point to request the database's table associated to {@link PasswordResetToken} entity.
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

    @Query("SELECT p FROM PasswordResetToken p WHERE p.user.id = (:id) ")
    List<PasswordResetToken> findByFkUser(Long id);
}
