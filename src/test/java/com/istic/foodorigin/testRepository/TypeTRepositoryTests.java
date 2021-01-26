package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.TypeTransformateur;
import com.istic.foodorigin.repository.OrigineDenreeRepository;
import com.istic.foodorigin.repository.TypeTransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link TypeTransformateurRepository}
 */
@SpringBootTest
public class TypeTRepositoryTests {

    @Autowired
    private TypeTransformateurRepository typeTRepository;

    @Test
    public void testFindByLibelleArtisan () {
        String type = "Artisan";
        TypeTransformateur type_artisan = typeTRepository.findByLibelle(type);

        assertThat(type_artisan.getLibelle()).isEqualTo(type);

    }

    @Test
    public void testFindByLibelleIndustriel () {
        String type = "Industriel";
        TypeTransformateur type_industriel = typeTRepository.findByLibelle(type);

        assertThat(type_industriel.getLibelle()).isEqualTo(type);

    }

    @Test
    public void testFindByLibelleNotExist () {
        String type = "Agriculteur";
        TypeTransformateur type_transformateur = typeTRepository.findByLibelle(type);

        assertThat(type_transformateur).isNull();
    }

    @Test
    public void testFindByLibelleNull () {
        TypeTransformateur type_transformateur = typeTRepository.findByLibelle(null);

        assertThat(type_transformateur).isNull();
    }
}
