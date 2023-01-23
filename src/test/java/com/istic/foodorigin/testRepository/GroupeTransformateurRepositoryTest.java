package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.GroupeTransformateurRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GroupeTransformateurRepositoryTest {

    @Autowired
    private GroupeTransformateurRepository groupeTransformateurRepository;

    @Autowired
    private TransformateurRepository transformateurRepository;

    @Test
    public void testFindByTransformateursId() {
        Long id = Integer.toUnsignedLong(20);
        Transformateur transformateur = transformateurRepository.findById(id).get();

        // Call the findByTransformateurs_Id method with the Transformateur's id as the parameter
        Optional<GroupeTransformateur> result = groupeTransformateurRepository.findByTransformateurs_Id(id);

        // Assert that the returned Optional contains the same GroupeTransformateur that was retreived earlier
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), transformateur.getGroupeTransformateur().getId());
    }

    @Test
    public void testFindByTransformateursIdNotExist() {
        Long id = Integer.toUnsignedLong(1000000000);

        Optional<GroupeTransformateur> result = groupeTransformateurRepository.findByTransformateurs_Id(id);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindByTransformateursIdNull() {
        Optional<GroupeTransformateur> result = groupeTransformateurRepository.findByTransformateurs_Id(null);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindByLabels() {
        String lab = "rouge";
        Optional<Set<GroupeTransformateur>> result = groupeTransformateurRepository.findByLabel(lab);

        assertTrue(result.isPresent());

        Set<GroupeTransformateur> groupeTransformateurs = new HashSet<>(result.get());
        boolean contains;
        for (GroupeTransformateur groupeTransformateur : groupeTransformateurs) {
            Set<Label> labels = groupeTransformateur.getLabels();
            contains = labels.stream().anyMatch(label -> label.getLibelle().toLowerCase().contains(lab.toLowerCase()));
            assertTrue(contains);
        }
    }

    @Test
    public void testFindByLabelsNoMatch() {
        // Call the findByLabels method with a libelle that does not match any of the Label's libelle in the repository
        Optional<Set<GroupeTransformateur>> result = groupeTransformateurRepository.findByLabel("notExistLabel");
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindByLabelsIsNull() {
        // Call the findByLabels method with a libelle that does not match any of the Label's libelle in the repository
        Optional<Set<GroupeTransformateur>> result = groupeTransformateurRepository.findByLabel(null);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }
}
