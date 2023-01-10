package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.TypeDenree;
import com.istic.foodorigin.service.TypeDenreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link TypeDenreeService}
 */
@SpringBootTest
public class TypeDenreeServiceTests {

    @Autowired
    private TypeDenreeService typeDenreeService;

    @Test
    public void testGetAll() {
        List<TypeDenree> denrees = typeDenreeService.getAll();
        assertThat(denrees.size()).isEqualTo(35);
    }

    @Test
    public void testGetAllNom() {
        Set<String> denrees = typeDenreeService.getAllNom();
        assertThat(denrees.size()).isEqualTo(4);
    }

    @Test
    public void testGetEspeceByNomExists() {
        String nom = "Viande";
        Set<String> denrees = typeDenreeService.getEspeceByNom(nom);
        assertThat(denrees.size()).isEqualTo(7);
    }

    @Test
    public void testGetEspeceByNomNotExists() {
        String nom = "Légumes";
        Set<String> denrees = typeDenreeService.getEspeceByNom(nom);
        assertThat(denrees.size()).isEqualTo(0);
    }

    @Test
    public void testGetEspeceByNomNull() {
        Set<String> denrees = typeDenreeService.getEspeceByNom(null);
        assertThat(denrees.size()).isEqualTo(0);
    }

    @Test
    public void testGetAnimalByEspeceExists() {
        String espece = "Autre";
        Set<String> denrees = typeDenreeService.getAnimalByEspece(espece);
        assertThat(denrees.size()).isEqualTo(4);
    }

    @Test
    public void testGetAnimalByEspeceNotExists() {
        String espece = "Crabe";
        Set<String> denrees = typeDenreeService.getAnimalByEspece(espece);
        assertThat(denrees.size()).isEqualTo(0);
    }

    @Test
    public void testGetAnimalByEspeceNull() {
        Set<String> denrees = typeDenreeService.getAnimalByEspece(null);
        assertThat(denrees.size()).isEqualTo(0);
    }
}
