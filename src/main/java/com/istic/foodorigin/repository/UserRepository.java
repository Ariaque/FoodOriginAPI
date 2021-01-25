package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.ERole;
import com.istic.foodorigin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * End point to request the database's table associated to {@link User} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Query("SELECT u FROM User u, Transformateur t WHERE u.transformateur.id = t.id AND t.siret =(:siret) ")
    Optional<User> findUserBySiret(@Param("siret") String siret);

    @Query("SELECT u FROM User u WHERE u.role.name = (:role) ")
    List<User> findByRole(ERole role);
}
