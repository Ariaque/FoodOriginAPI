package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.FermePartenaire;
import com.istic.foodorigin.service.FermePartenaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FermePartenaireServiceTests {

    @Autowired
    private FermePartenaireService fermePartenaireService;

    @Test
    public void testGetFermeByIdExist() {
        Long id = Integer.toUnsignedLong(58);
        FermePartenaire found = fermePartenaireService.getFermeById(id);
        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getNom()).isEqualTo("Domaine Abotia");
        assertThat(found.getUrl()).isEqualTo("https://www.irouleguy.net/domaine-abotia/");
    }

    @Test
    public void testGetFermeByIdNotExist() {
        Long id = Integer.toUnsignedLong(5);
        FermePartenaire found = fermePartenaireService.getFermeById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetFermeByIdNull() {
        FermePartenaire found = fermePartenaireService.getFermeById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetAllFermes () {
        Iterable<FermePartenaire> itFerme = fermePartenaireService.getAllFermes();
        List<FermePartenaire> found = StreamSupport.stream(itFerme.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(7);
    }
}
