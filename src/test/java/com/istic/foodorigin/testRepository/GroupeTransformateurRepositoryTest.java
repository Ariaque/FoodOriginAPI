package com.istic.foodorigin.testRepository;

import com.istic.foodorigin.models.GroupeTransformateur;
import com.istic.foodorigin.models.Transformateur;
import com.istic.foodorigin.repository.GroupeTransformateurRepository;
import com.istic.foodorigin.repository.TransformateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GroupeTransformateurRepositoryTest {

    @Autowired
    private GroupeTransformateurRepository groupeTransformateurRepository;

    @Autowired
    private TransformateurRepository transformateurRepository;

    @Test
    public void testFindByTransformateursId() {
        Long id = Integer.toUnsignedLong(1);
        Transformateur transformateur = transformateurRepository.findById(id).get();

        // Call the findByTransformateurs_Id method with the Transformateur's id as the parameter
        Optional<GroupeTransformateur> result = groupeTransformateurRepository.findByTransformateurs_Id(id);

        // Assert that the returned Optional contains the same GroupeTransformateur that was retreived earlier
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), transformateur.getGroupeTransformateur().getId());
    }

   /* @Test
    public void testFindByLabels() {
        // Create a test GroupeTransformateur object and save it to the repository
        GroupeTransformateur groupeTransformateur = new GroupeTransformateur();
        groupeTransformateur = groupeTransformateurRepository.save(groupeTransformateur);

        // Create a test Label object with a specific libelle and set it as one of the labels for the GroupeTransformateur
        Label label = new Label();
        label.setLibelle("testLabel");
        label = labelRepository.save(label);
        groupeTransformateur.getLabels().add(label);
        groupeTransformateur = groupeTransformateurRepository.save(groupeTransformateur);

        // Call the findByLabels method with the Label's libelle as the parameter
        Optional<Set<GroupeTransformateur>> result = groupeTransformateurRepository.findByLabels("testLabel");

        // Assert that the returned Optional contains a set that includes the same GroupeTransformateur that was saved earlier
        assertTrue(result.isPresent());
        assertTrue(result.get().contains(groupeTransformateur));
    }*/


}
