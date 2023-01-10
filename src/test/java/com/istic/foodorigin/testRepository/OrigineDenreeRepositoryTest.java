package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.OrigineDenree;
import com.istic.foodorigin.repository.OrigineDenreeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Class that tests {@link OrigineDenreeRepository}
 */
@SpringBootTest
public class OrigineDenreeRepositoryTest {

    @Autowired
    private OrigineDenreeRepository origineDenreeRepository;

    @Test
    public void testFindByPaysExists() {
        String pays = "France";
        List<OrigineDenree> origine = origineDenreeRepository.findByPays(pays);
        assertThat(origine.size()).isEqualTo(18);
        assertThat(origine.get(0).getPays()).isEqualTo(pays);
    }

    @Test
    public void testFindByPaysNotExist() {
        String pays = "Espagne";
        List<OrigineDenree> origine = origineDenreeRepository.findByPays(pays);
        assertThat(origine.size()).isEqualTo(0);
    }

    @Test
    public void testFindByPaysNull() {
        List<OrigineDenree> origine = origineDenreeRepository.findByPays(null);
        assertThat(origine.size()).isEqualTo(0);
    }
}
