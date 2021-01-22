package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.TypeTransformateur;
import com.istic.foodorigin.repository.TypeTransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class TypeTRepositoryTests {

    @Autowired
    private TypeTransformateurRepository typeTRepository;

    @Test
    public void testFindByLibelleArtisan () {
        //Test avec les types enregistrés à l'initialisation de l'appli
        String type = "Artisan";
        TypeTransformateur type_artisan = typeTRepository.findByLibelle(type);

        assertThat(type_artisan.getLibelle()).isEqualTo(type);

    }

    @Test
    public void testFindByLibelleIndustriel () {
        //Test avec les types enregistrés à l'initialisation de l'appli
        String type = "Industriel";
        TypeTransformateur type_industriel = typeTRepository.findByLibelle(type);

        assertThat(type_industriel.getLibelle()).isEqualTo(type);

    }

    @Test
    public void testFindByLibelleNotExist () {
        //Test avec un type qui n'existe pas
        String type = "Agriculteur";
        TypeTransformateur type_transformateur = typeTRepository.findByLibelle(type);

        assertThat(type_transformateur).isNull();
    }

    @Test
    public void testFindByLibelleNull () {
        //Test avec un type qui n'existe pas
        TypeTransformateur type_transformateur = typeTRepository.findByLibelle(null);

        assertThat(type_transformateur).isNull();
    }
}
