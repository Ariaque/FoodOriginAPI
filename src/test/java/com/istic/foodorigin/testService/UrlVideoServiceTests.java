package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.UrlVideo;
import com.istic.foodorigin.service.UrlVideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UrlVideoServiceTests {

    @Autowired
    private UrlVideoService urlVideoService;

    @Test
    public void testUrlByIdExists () {
        Long id = Integer.toUnsignedLong(39);
        UrlVideo url = urlVideoService.getUrlById(id);
        assertThat(url.getId()).isEqualTo(id);
        assertThat(url.getLibelle()).isEqualTo("https://www.youtube.com/watch?v=gt_a7OfxBLI");
        assertThat(url.getTitre()).isEqualTo("Rencontre avec Bernard Leguille");
    }

    @Test
    public void testGetUrlByIdNotExist() {
        Long id = Integer.toUnsignedLong(3);
        UrlVideo found = urlVideoService.getUrlById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetUrlByIdNull() {
        UrlVideo found = urlVideoService.getUrlById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetAllUrls () {
        Iterable<UrlVideo> itUrl = urlVideoService.getAllUrls();
        List<UrlVideo> found = StreamSupport.stream(itUrl.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(14);
    }
}
