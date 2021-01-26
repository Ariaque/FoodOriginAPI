package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.TypeDenree;
import com.istic.foodorigin.repository.OrigineDenreeRepository;
import com.istic.foodorigin.repository.TypeDenreeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link TypeDenreeRepository}
 */
@SpringBootTest
public class TypeDenreeRepositoryTests {

    @Autowired
    private TypeDenreeRepository typeDenreeRepository;

    @Test
    public void testFindByNomExists () {
        String nom = "Viande";
        List<TypeDenree> denrees = typeDenreeRepository.findByNom(nom);
        assertThat (denrees.size()).isEqualTo(22);
        assertThat (denrees.get(0).getNom()).isEqualTo(nom);
    }

    @Test
    public void testFindByNomNotExists () {
        String nom = "Insecte";
        List<TypeDenree> denrees = typeDenreeRepository.findByNom(nom);
        assertThat (denrees.size()).isEqualTo(0);
    }

    @Test
    public void testFindByNomNull () {
        List<TypeDenree> denrees = typeDenreeRepository.findByNom(null);
        assertThat (denrees.size()).isEqualTo(0);
    }

    @Test
    public void testFindByEspeceExists () {
        String espece = "Ovins";
        List<TypeDenree> denrees = typeDenreeRepository.findByEspece(espece);
        assertThat (denrees.size()).isEqualTo(2);
        assertThat (denrees.get(0).getEspece()).isEqualTo(espece);
    }

    @Test
    public void testFindByEspeceNotExists () {
        String espece = "Chiens";
        List<TypeDenree> denrees = typeDenreeRepository.findByEspece(espece);
        assertThat (denrees.size()).isEqualTo(0);
    }

    @Test
    public void testFindByEspeceNull () {
        List<TypeDenree> denrees = typeDenreeRepository.findByEspece(null);
        assertThat (denrees.size()).isEqualTo(0);
    }
}
