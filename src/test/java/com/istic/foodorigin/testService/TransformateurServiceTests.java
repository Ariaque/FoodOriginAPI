package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.service.TransformateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link TransformateurService}
 */
@SpringBootTest
public class TransformateurServiceTests {

    @Autowired
    private TransformateurService transformateurService;

    @Test
    public void testGetTransformateurByIdExist() {
        Long id = Integer.toUnsignedLong(25);
        Transformateur found = transformateurService.getTransformateurById(id);
        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getNum_agrement()).isEqualTo("01.451.001");
    }

    @Test
    public void testGetTransformateurByIdNotExist() {
        Long id = Integer.toUnsignedLong(22000);
        Transformateur found = transformateurService.getTransformateurById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetTransformateurByIdNull() {
        Transformateur found = transformateurService.getTransformateurById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetTransformateurBySiretExist() {
        String siret = "34347026600028";
        Transformateur found = transformateurService.getTransformateurBySiret(siret);
        assertThat(found.getSiret()).isEqualTo(siret);
        assertThat(found.getRaison_sociale()).isEqualTo("H.D. DISTRIBUTION");
    }

    @Test
    public void testGetTransformateurBySiretNotLength() {
        String siret = "3434702660002812";
        Transformateur found = transformateurService.getTransformateurBySiret(siret);
        assertThat(found).isNull();
    }

    @Test
    public void testGetTransformateurBySiretNotExists() {
        String siret = "30580148200138";
        Transformateur found = transformateurService.getTransformateurBySiret(siret);
        assertThat(found).isNull();
    }

    @Test
    public void testGetTransformateurBySiretNull() {
        Transformateur found = transformateurService.getTransformateurBySiret(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetTransformateurByEstampilleExist() {
        String estampille = "01.405.003";
        Transformateur found = transformateurService.getTransformateurByEstampille(estampille);
        assertThat(found.getNum_agrement()).isEqualTo(estampille);
        assertThat(found.getSiret()).isEqualTo("50308898100017");
    }

    @Test
    public void testGetTransformateurByEstampilleNotExist() {
        String estampille = "01.405.00315";
        Transformateur found = transformateurService.getTransformateurByEstampille(estampille);
        assertThat(found).isNull();
    }

    @Test
    public void testGetTransformateurByEstampilleNull() {
        Transformateur found = transformateurService.getTransformateurByEstampille(null);
        assertThat(found).isNull();
    }
}
