package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.ERole;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsernameExists () {
        String username = "emile.georget@outlook.fr";
        Optional <User> user = userRepository.findByUsername(username);

        assertThat(user.isPresent()).isTrue();
        assertThat(user.get().getUsername()).isEqualTo(username);

    }

    @Test
    public void testFindByUsernameNotExists () {
        String username = "test@outlook.fr";
        Optional <User> user = userRepository.findByUsername(username);

        assertThat(user.isPresent()).isFalse();
    }

    @Test
    public void testFindByUsernameNull () {
        String username = null;
        Optional <User> user = userRepository.findByUsername(username);

        assertThat(user.isPresent()).isFalse();
    }

    @Test
    public void testExistsByUsernameExists () {
        String username = "emile.georget@outlook.fr";
        boolean usernameExist = userRepository.existsByUsername(username);

        assertThat(usernameExist).isTrue();
    }

    @Test
    public void testExistsByUsernameNotExists () {
        String username = "test@outlook.fr";
        boolean usernameExist = userRepository.existsByUsername(username);

        assertThat(usernameExist).isFalse();
    }

    @Test
    public void testExistsByUsernameNull () {
        String username = null;
        boolean usernameExist = userRepository.existsByUsername(username);

        assertThat(usernameExist).isFalse();
    }

    @Test
    public void testFindUserBySiretExists () {
        String siret = "08678020200031";
        Optional<User> user = userRepository.findUserBySiret(siret);

        assertThat(user.isPresent()).isTrue();
        assertThat(user.get().getTransformateur().getSiret()).isEqualTo(siret);
    }

    @Test
    public void testFindUserBySiretExistsNotUser () {
        String siret = "33889585700013";
        Optional<User> user = userRepository.findUserBySiret(siret);

        assertThat(user.isPresent()).isFalse();
    }

    @Test
    public void testFindUserBySiretNotExists () {
        String siret = "5140808370017215";
        Optional<User> user = userRepository.findUserBySiret(siret);

        assertThat(user.isPresent()).isFalse();
    }

    @Test
    public void testFindUserBySiretNull () {
        String siret = null;
        Optional<User> user = userRepository.findUserBySiret(siret);

        assertThat(user.isPresent()).isFalse();
    }

    @Test
    public void testFindByRoleUser () {
        List<User> users = userRepository.findByRole(ERole.ROLE_USER);
        assertThat(users.size()).isEqualTo(2);
        assertThat(users.get(0).getRole().getName()).isEqualTo(ERole.ROLE_USER);
    }

    @Test
    public void testFindByRoleAdmin () {
        List<User> users = userRepository.findByRole(ERole.ROLE_ADMIN);
        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getRole().getName()).isEqualTo(ERole.ROLE_ADMIN);
    }

    @Test
    public void testFindByRoleNull () {
        List<User> users = userRepository.findByRole(null);
        assertThat(users.size()).isEqualTo(0);
    }
}
