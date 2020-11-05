package com.istic.foodorigin.service;

import com.istic.foodorigin.domain.TransformateurFR;
import com.istic.foodorigin.repository.TransformateurFRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransformateurFRService {

    @Autowired
    private TransformateurFRRepository transformateurRepository;

    public List<TransformateurFR> getAllTransformateurs (){
        List<TransformateurFR> transformateurs = transformateurRepository.getAllTransformateurs();
        return transformateurs;
    }

    public TransformateurFR getTransformateurById (Long id){
        TransformateurFR transformateur = transformateurRepository.getTransformateurById(id);
        return transformateur;
    }

    public TransformateurFR saveTransformateur_FR (TransformateurFR transformateur) {
        TransformateurFR transformateur_fr = transformateurRepository.saveTransformateur(transformateur);
        return transformateur_fr;
    }

}
