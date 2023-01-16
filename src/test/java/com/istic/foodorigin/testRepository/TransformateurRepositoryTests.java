package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link TransformateurRepository}
 */
@SpringBootTest
public class TransformateurRepositoryTests {

    @Autowired
    private TransformateurRepository transformateurRepository;

    @Test
    public void testFindBySiretExists() {
        String siret = "82193733100014";
        List<Transformateur> transformateurL = transformateurRepository.findBySiret(siret);

        assertThat(transformateurL.size()).isEqualTo(1);
        Transformateur transformateur = transformateurL.get(0);
        assertThat(transformateur.getSiret()).isEqualTo(siret);
    }

    @Test
    public void testFindBySiretDontExist() {
        String siret = "8219373310001456";
        List<Transformateur> transformateurL = transformateurRepository.findBySiret(siret);

        assertThat(transformateurL.size()).isEqualTo(0);
    }

    @Test
    public void testFindBySiretNull() {
    }

    @Test
    public void testFindByNumAgrementExists() {
        String num_agrement = "01.320.003";
        List<Transformateur> transformateurL = transformateurRepository.findByNumAgrement(num_agrement);

        assertThat(transformateurL.size()).isEqualTo(1);
        Transformateur transformateur = transformateurL.get(0);
        assertThat(transformateur.getNum_agrement()).isEqualTo(num_agrement);
    }

    @Test
    public void testFindByNumAgrementNotExists() {
        String num_agrement = "125.320.003";
        List<Transformateur> transformateurL = transformateurRepository.findByNumAgrement(num_agrement);

        assertThat(transformateurL.size()).isEqualTo(0);
    }

    @Test
    public void testFindByNumAgrementNull() {
        List<Transformateur> transformateurL = transformateurRepository.findByNumAgrement(null);

        assertThat(transformateurL.size()).isEqualTo(0);
    }
}
