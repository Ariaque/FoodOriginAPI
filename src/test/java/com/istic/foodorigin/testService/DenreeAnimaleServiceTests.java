package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.DenreeAnimale;
import com.istic.foodorigin.service.DenreeAnimaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DenreeAnimaleServiceTests {

    @Autowired
    private DenreeAnimaleService denreeAnimaleService;

    @Test
    public void testGetDenreeByIdExist() {
        Long id = Integer.toUnsignedLong(59);
        DenreeAnimale found = denreeAnimaleService.getDenreeById(id);
        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getNom()).isEqualTo("Boeuf");
        assertThat(found.getOrigine()).isEqualTo("Région Nouvelle Aquitaine, France");
    }

    @Test
    public void testGetDenreeByIdNotExist() {
        Long id = Integer.toUnsignedLong(10);
        DenreeAnimale found = denreeAnimaleService.getDenreeById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetDenreeByIdNull() {
        DenreeAnimale found = denreeAnimaleService.getDenreeById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetAllDenrees () {
        Iterable<DenreeAnimale> itDenree = denreeAnimaleService.getAllDenrees();
        List<DenreeAnimale> found = StreamSupport.stream(itDenree.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(2);
    }
}
