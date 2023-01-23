package com.istic.foodorigin.testService;

import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Label;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.service.GroupeTransformateurService;
import com.istic.foodorigin.service.LabelService;
import com.istic.foodorigin.service.TransformateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GroupeTransformateurServiceTest {

    @Autowired
    GroupeTransformateurService groupeTransformateurService;

    @Autowired
    private TransformateurService transformateurService;
    @Autowired
    private LabelService labelService;


    @Test
    public void testCreateGroupeTransformateur() {
        String description = "Added by test";
        Set<Label> labels = StreamSupport.stream(labelService.getAllLabels().spliterator(), false).collect(Collectors.toSet());

        Set<Label> randLabs = new HashSet<>();
        for (int i = 0; i < (new Random().nextInt(5) + 1); i++) {
            randLabs.add(labels.stream().skip(new Random().nextInt(labels.size())).findFirst().get());
        }

        GroupeTransformateur groupeTransformateur = new GroupeTransformateur(randLabs, description);

        GroupeTransformateur result = groupeTransformateurService.saveGroupe(groupeTransformateur);

        assertEquals(result.getDescription(), groupeTransformateur.getDescription());
        boolean contains = result.getLabels().stream().allMatch(l1 -> randLabs.stream().anyMatch(l2 -> l1.getId().equals(l2.getId())));
        assertTrue(contains);
    }

    @Test
    public void testFindByTransformateursId() {
        Long id = Integer.toUnsignedLong(1);
        Long transformateurId = Integer.toUnsignedLong(20);
        Transformateur transformateur = transformateurService.getTransformateurById(transformateurId);

        // Call the findByTransformateurs_Id method with the Transformateur's id as the parameter
        Optional<GroupeTransformateur> result = groupeTransformateurService.findByTransformateurId(transformateurId);

        // Assert that the returned Optional contains the same GroupeTransformateur that was retreived earlier
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), transformateur.getGroupeTransformateur().getId());
    }

    @Test
    public void testFindByTransformateursIdNotExist() {
        Long id = Integer.toUnsignedLong(1000000000);

        Optional<GroupeTransformateur> result = groupeTransformateurService.findByTransformateurId(id);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindByTransformateursIdIsNull() {
        Optional<GroupeTransformateur> result = groupeTransformateurService.findByTransformateurId(null);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindByLabels() {
        String lab = "rouge";
        Optional<Set<GroupeTransformateur>> result = groupeTransformateurService.findByLabel(lab);

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
        Optional<Set<GroupeTransformateur>> result = groupeTransformateurService.findByLabel("notExistLabel");
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindByLabelsIsNull() {
        // Call the findByLabels method with a libelle that does not match any of the Label's libelle in the repository
        Optional<Set<GroupeTransformateur>> result = groupeTransformateurService.findByLabel(null);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindById() {
        Long id = Integer.toUnsignedLong(1);
        Optional<GroupeTransformateur> result = groupeTransformateurService.getGroupeTransformateurById(id);
        // Assert that the returned Optional is not empty
        assertTrue(result.isPresent());
        // Assert that the returned element has the correct Id
        assertEquals(result.get().getId(), id);
    }

    @Test
    public void testFindByIdNotExist() {
        Long id = Integer.toUnsignedLong(1000000000);
        Optional<GroupeTransformateur> result = groupeTransformateurService.getGroupeTransformateurById(id);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindByIdIsnull() {
        Optional<GroupeTransformateur> result = groupeTransformateurService.getGroupeTransformateurById(null);
        // Assert that the returned Optional is empty
        assertFalse(result.isPresent());
    }
}
