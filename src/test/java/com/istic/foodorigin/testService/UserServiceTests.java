package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.*;
import com.istic.foodorigin.repository.RoleRepository;
import com.istic.foodorigin.service.TransformateurService;
import com.istic.foodorigin.service.TypeTransformateurService;
import com.istic.foodorigin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link UserService}
 */
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TransformateurService transformateurService;

    @Autowired
    private TypeTransformateurService typeTransformateurService;

    @Test
    public void testGetAllUsers () {
        Iterable<User> itUser = userService.getAllUsers();
        List<User> found = StreamSupport.stream(itUser.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(10);
    }

    @Test
    public void testGetAllRoleUser () {
        Iterable<User> itUser = userService.getAllRoleUser();
        List<User> found = StreamSupport.stream(itUser.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(9);
    }

    @Test
    public void testSaveUser () {
        User user = new User();
        String username = "test@test.fr";
        String numeroTel = "0299920417";
        user.setUsername(username);
        user.setPassword(encoder.encode("test"));
        Role role = roleRepository.findByName(ERole.ROLE_USER).get();
        user.setRole(role);
        Transformateur transformateur = transformateurService.getTransformateurById(Integer.toUnsignedLong(200));
        user.setTransformateur(transformateur);
        TypeTransformateur typeT = typeTransformateurService.getTypeById(Integer.toUnsignedLong(2));
        user.setTypeTransformateur(typeT);
        user.setUserActivation(false);
        user.setNumeroTelephone(numeroTel);

        User saveU = userService.saveUser(user);
        assertThat(saveU.getRole().getName()).isEqualTo(role.getName());
        assertThat(saveU.getUsername()).isEqualTo(username);
        assertThat(encoder.matches("test", saveU.getPassword())).isTrue();
        assertThat(saveU.getTransformateur().getId()).isEqualTo(Integer.toUnsignedLong(200));
        assertThat(saveU.getTypeTransformateur().getLibelle()).isEqualTo(typeT.getLibelle());
        assertThat(saveU.getNumeroTelephone()).isEqualTo(numeroTel);
    }

    @Test
    public void testSaveUserNull () {
        User user = userService.saveUser(null);
        assertThat(user).isNull();
    }

    @Test
    public void testUserByNameExists () {
        String name = "test@free.com";
        User user = userService.getUserByName(name);
        assertThat(user.getUsername()).isEqualTo(name);
    }

    @Test
    public void testGetUserByNameNotExist() {
        String name = "admin@test.fr";
        User user = userService.getUserByName(name);
        assertThat(user).isNull();
    }

    @Test
    public void testGetUserByNameNull() {
        User found = userService.getUserByName(null);
        assertThat(found).isNull();
    }

    @Test
    public void testUserBySiretTransfoExists () {
        String siret = "37784209100029";
        User user = userService.getUserBySiretTransfo(siret);
        assertThat(user.getTransformateur().getSiret()).isEqualTo(siret);
    }

    @Test
    public void testUserBySiretTransfoNoUser () {
        String siret = "39239584400021";
        User user = userService.getUserBySiretTransfo(siret);
        assertThat(user).isNull();
    }

    @Test
    public void testGetUserBySiretTransfoNotExist() {
        String siret = "5030889810001715";
        User user = userService.getUserBySiretTransfo(siret);
        assertThat(user).isNull();
    }

    @Test
    public void testGetUserBySiretTransfoNull() {
        User found = userService.getUserBySiretTransfo(null);
        assertThat(found).isNull();
    }

    @Test
    public void testChangeUserPassword () {
        String username = "test@test.fr";
        User user = userService.getUserByName("test@test.fr");
        String password = "test12340";
        User ret = userService.changeUserPassword(user, password);

        assertThat(ret.getUsername()).isEqualTo(username);
        assertThat(encoder.matches(password,ret.getPassword())).isTrue();
    }

    @Test
    public void testChangeUserPasswordUserNull () {
        User user = new User();
        user.setId(Integer.toUnsignedLong(55));
        String password = "test1";
        User ret = userService.changeUserPassword(user, password);

        assertThat(ret).isNull();
    }

    @Test
    public void testChangeUserPasswordNull () {
        String username = "test@test.fr";
        User user = userService.getUserByName("test@test.fr");
        User ret = userService.changeUserPassword(user, null);

        assertThat(ret).isEqualTo(null);
    }

    @Test
    public void testChangeUserPasswordAllNull () {
        User ret = userService.changeUserPassword(null, null);
        assertThat(ret).isEqualTo(null);
    }

    @Test
    public void deleteUserExists () {
        String username = "test@test.fr";
        User user = userService.getUserByName(username);
        boolean ret = userService.deleteUser(user);
        assertThat(ret).isTrue();
        assertThat(userService.getUserByName(username)).isNull();
    }

    @Test
    public void deleteUserNotExists () {
        User user = new User();
        user.setId(Integer.toUnsignedLong(110));
        boolean ret = userService.deleteUser(user);
        assertThat(ret).isFalse();
    }

    @Test
    public void deleteUserNull () {
        boolean ret = userService.deleteUser(null);
        assertThat(ret).isFalse();
    }

}
