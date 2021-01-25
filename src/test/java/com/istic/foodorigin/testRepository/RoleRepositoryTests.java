package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.ERole;
import com.istic.foodorigin.models.Role;
import com.istic.foodorigin.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testFindByNameRoleUser () {
        Optional<Role> roleUser = roleRepository.findByName(ERole.ROLE_USER);
        assertThat (roleUser.isPresent()).isTrue();

        Role role = roleUser.get();
        assertThat(role.getName()).isEqualTo(ERole.ROLE_USER);
    }

    @Test
    public void testFindByNameRoleAdmin () {
        Optional<Role> roleUser = roleRepository.findByName(ERole.ROLE_ADMIN);
        assertThat (roleUser.isPresent()).isTrue();

        Role role = roleUser.get();
        assertThat(role.getName()).isEqualTo(ERole.ROLE_ADMIN);
    }

    @Test
    public void testFindByNameRoleNull () {
        Optional<Role> roleUser = roleRepository.findByName(null);
        assertThat (roleUser.isPresent()).isFalse();
    }
}
