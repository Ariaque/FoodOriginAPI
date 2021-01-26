package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.InfosTransformateur;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.CertificationRepository;
import com.istic.foodorigin.repository.InfosTransformateurRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link InfosTransformateurRepository}
 */

@SpringBootTest
public class InfosTRepositoryTests {

    @Autowired
    private InfosTransformateurRepository infosTRepository;

    @Autowired
    private TransformateurRepository transformateurRepository;

    @Test
    public void testFindByTransformateurInfos () {
        Transformateur transformateur = transformateurRepository.findById(Integer.toUnsignedLong(1)).get();
        InfosTransformateur infosT = infosTRepository.findByTransformateur(transformateur);

        assertThat(infosT.getTransformateur().getId()).isEqualTo(transformateur.getId());
        assertThat(infosT.getNombre_employes()).isEqualTo("150");
    }

    @Test
    public void testFindByTransformateurWithoutInfos () {
        Transformateur transformateur = transformateurRepository.findById(Integer.toUnsignedLong(50)).get();
        InfosTransformateur infosT = infosTRepository.findByTransformateur(transformateur);

        assertThat(infosT).isNull();
    }

    @Test
    public void testFindByTransformateurNotExists () {
        Transformateur transformateur = new Transformateur();
        transformateur.setId(Integer.toUnsignedLong(21000));
        InfosTransformateur infosT = infosTRepository.findByTransformateur(transformateur);

        assertThat(infosT).isNull();
    }

    @Test
    public void testFindByTransformateurNull () {
        InfosTransformateur infosT = infosTRepository.findByTransformateur(null);
        assertThat(infosT).isNull();
    }
}
