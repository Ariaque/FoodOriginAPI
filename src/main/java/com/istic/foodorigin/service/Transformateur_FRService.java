package com.istic.foodorigin.service;

import com.istic.foodorigin.model.Transformateur_FR;
import com.istic.foodorigin.repository.Transformateur_FRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Transformateur_FRService {

    @Autowired
    private Transformateur_FRRepository transformateurRepository;

    public List<Transformateur_FR> getAllTransformateurs (){
        List<Transformateur_FR> transformateurs = transformateurRepository.getAllTransformateurs();
        return transformateurs;
    }

    public Transformateur_FR getTransformateurById (Long id){
        Transformateur_FR transformateur = transformateurRepository.getTransformateurById(id);
        return transformateur;
    }

    public Transformateur_FR saveTransformateur_FR (Transformateur_FR transformateur) {
        Transformateur_FR transformateur_fr = transformateurRepository.saveTransformateur(transformateur);
        return transformateur_fr;
    }

}
