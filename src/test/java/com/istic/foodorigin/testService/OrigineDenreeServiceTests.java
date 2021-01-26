package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.OrigineDenree;
import com.istic.foodorigin.service.OrigineDenreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class that tests {@link OrigineDenreeService}
 */
@SpringBootTest
public class OrigineDenreeServiceTests {

    @Autowired
    private OrigineDenreeService origineDenreeService;

    @Test
    public void getAllOrigineDenree () {
        List<OrigineDenree> origines = origineDenreeService.getAllOrigineDenree();
        assertThat(origines.size()).isEqualTo(61);
    }

    @Test
    public void testGetAllPays () {
        Set<String> pays = origineDenreeService.getAllPays();
        assertThat(pays.size()).isEqualTo(3);
    }

    @Test
    public void testGetRegionByPaysMonde () {
        String pays = "Monde";
        Set<String> regions = origineDenreeService.getRegionByPays(pays);
        assertThat(regions.size()).isEqualTo(5);
    }

    @Test
    public void testGetRegionByPaysEurope () {
        String pays = "Europe";
        Set<String> regions = origineDenreeService.getRegionByPays(pays);
        assertThat(regions.size()).isEqualTo(38);
    }

    @Test
    public void testGetRegionByPaysFrance () {
        String pays = "France";
        Set<String> regions = origineDenreeService.getRegionByPays(pays);
        assertThat(regions.size()).isEqualTo(18);
    }

    @Test
    public void testGetRegionByPaysNotExists () {
        String pays = "Allemagne";
        Set<String> regions = origineDenreeService.getRegionByPays(pays);
        assertThat(regions.size()).isEqualTo(0);
    }

    @Test
    public void testGetRegionByPaysNull () {
        Set<String> regions = origineDenreeService.getRegionByPays(null);
        assertThat(regions.size()).isEqualTo(0);
    }
}
