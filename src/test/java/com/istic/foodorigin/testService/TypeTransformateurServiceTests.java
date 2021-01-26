package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.TypeTransformateur;
import com.istic.foodorigin.service.TypeTransformateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link TypeTransformateurService}
 */
@SpringBootTest
public class TypeTransformateurServiceTests {

    @Autowired
    private TypeTransformateurService typeTService;

    @Test
    public void testGetTypeByIdExistIndustriel() {
        Long id = Integer.toUnsignedLong(1);
        TypeTransformateur found = typeTService.getTypeById(id);
        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getLibelle()).isEqualTo("Industriel");
    }

    @Test
    public void testGetTypeByIdExistArtisan() {
        Long id = Integer.toUnsignedLong(2);
        TypeTransformateur found = typeTService.getTypeById(id);
        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getLibelle()).isEqualTo("Artisan");
    }

    @Test
    public void testGetTypeByIdNotExist() {
        Long id = Integer.toUnsignedLong(8);
        TypeTransformateur found = typeTService.getTypeById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetTypeByIdNull() {
        TypeTransformateur found = typeTService.getTypeById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetAllType () {
        Iterable<TypeTransformateur> itTypeT = typeTService.getAllType();
        List<TypeTransformateur> found = StreamSupport.stream(itTypeT.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(2);
    }
}
