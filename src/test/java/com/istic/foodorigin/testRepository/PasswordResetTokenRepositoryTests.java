package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.PasswordResetToken;
import com.istic.foodorigin.repository.OrigineDenreeRepository;
import com.istic.foodorigin.repository.PasswordResetTokenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link PasswordResetTokenRepository}
 */
@SpringBootTest
public class PasswordResetTokenRepositoryTests {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;


    @Test
    public void testFindByFkUserExists () {
        Long id = Integer.toUnsignedLong(28);
        List<PasswordResetToken> ret = passwordResetTokenRepository.findByFkUser(id);
        assertThat (ret.size()).isEqualTo(1);
    }

    @Test
    public void testFindByFkUserNotExists () {
        Long id = Integer.toUnsignedLong(5);
        List<PasswordResetToken> ret = passwordResetTokenRepository.findByFkUser(id);
        assertThat (ret.size()).isEqualTo(0);
    }

    @Test
    public void testFindByFkUserNull () {
        List<PasswordResetToken> ret = passwordResetTokenRepository.findByFkUser(null);
        assertThat (ret.size()).isEqualTo(0);
    }

    @Test
    public void findByToken () {
        String token = "dbb19edb-4fb1-4b9b-ab5a-e4ee9280da0e";
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
        assertThat(passwordResetToken.getToken()).isEqualTo(token);
    }

    @Test
    public void findByTokenNotExists () {
        String token = "dbb19edb-4fb1-4b9b-ab5a";
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
        assertThat(passwordResetToken).isNull();
    }

    @Test
    public void findByTokenNull () {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(null);
        assertThat(passwordResetToken).isNull();
    }
}
