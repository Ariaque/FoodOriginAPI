package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.InfosTransformateur;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.service.InfosTransformateurService;
import com.istic.foodorigin.service.TransformateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InfosTServiceTests {

    @Autowired
    private InfosTransformateurService infosTService;

    @Autowired
    private TransformateurService transformateurService;


    @Test
    public void testGetInfosByIdExist() {
        Long id = Integer.toUnsignedLong(4);
        InfosTransformateur found = infosTService.getInfosById(id);
        assertThat(found.getId()).isEqualTo(id);
        assertThat(found.getNombre_employes()).isEqualTo("150");
    }

    @Test
    public void testGetInfosByIdNotExist() {
        Long id = Integer.toUnsignedLong(1);
        InfosTransformateur found = infosTService.getInfosById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetInfosByIdNull() {
        InfosTransformateur found = infosTService.getInfosById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testSaveInfos () {
        Long id = Integer.toUnsignedLong(18);
        InfosTransformateur infos = new InfosTransformateur();
        infos.setNombre_employes("25");
        infos.setAppartient_groupe(false);
        Transformateur transformateur = transformateurService.getTransformateurById(id);
        infos.setTransformateur(transformateur);
        InfosTransformateur ret = this.infosTService.saveInfos(infos);
        assertThat(ret.getTransformateur().getId()).isEqualTo(id);
        assertThat(ret.getNombre_employes()).isEqualTo("25");
        assertThat(ret.isAppartient_groupe()).isFalse();
    }

    @Test
    public void testSaveInfosNull () {
        InfosTransformateur ret = this.infosTService.saveInfos(null);
        assertThat(ret).isNull();
    }

    @Test
    public void testGetInfosByTransformateurExist() {
        Long id = Integer.toUnsignedLong(1);
        InfosTransformateur found = infosTService.getInfosByTransformateur(id);
        assertThat(found.getId()).isEqualTo(Integer.toUnsignedLong(4));
    }

    @Test
    public void testGetInfosByTransformateurNotExist() {
        Long id = Integer.toUnsignedLong(5);
        InfosTransformateur found = infosTService.getInfosByTransformateur(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetInfosByTransformateurNull() {
        InfosTransformateur found = infosTService.getInfosByTransformateur(null);
        assertThat(found).isNull();
    }

}
