package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.service.LabelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LabelServiceTests {

    @Autowired
    private LabelService labelService;

    @Test
    public void testGetLabelByIdExist() {
        Long id = Integer.toUnsignedLong(1);
        Label found = labelService.getLabelById(id);
        assertThat(found.getLibelle()).isEqualTo("Label Rouge");
    }

    @Test
    public void testGetLabelByIdNotExist() {
        Long id = Integer.toUnsignedLong(20);
        Label found = labelService.getLabelById(id);
        assertThat(found).isNull();
    }

    @Test
    public void testGetLabelByIdNull() {
        Label found = labelService.getLabelById(null);
        assertThat(found).isNull();
    }

    @Test
    public void testGetAllLabels () {
        Iterable<Label> itLab = labelService.getAllLabels();
        List<Label> found = StreamSupport.stream(itLab.spliterator(), false).collect(Collectors.toList());
        assertThat(found.size()).isEqualTo(9);
    }
}
