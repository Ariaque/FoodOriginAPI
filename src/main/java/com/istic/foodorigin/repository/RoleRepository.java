package com.istic.foodorigin.repository;


import com.istic.foodorigin.models.ERole;
import com.istic.foodorigin.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * End point to request the database's table associated to {@link Role} entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
