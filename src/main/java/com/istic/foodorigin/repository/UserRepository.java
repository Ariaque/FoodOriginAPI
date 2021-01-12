package com.istic.foodorigin.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.istic.foodorigin.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    @Query("SELECT u FROM User u, Transformateur t WHERE u.transformateur.id = t.id AND t.siret =(:siret) ")
    Optional<User> findUserBySiret(@Param("siret")String siret);
}
