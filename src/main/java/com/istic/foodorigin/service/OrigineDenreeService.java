package com.istic.foodorigin.service;

import com.istic.foodorigin.models.OrigineDenree;
import com.istic.foodorigin.repository.OrigineDenreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrigineDenreeService {

    @Autowired
    private OrigineDenreeRepository origineDenreeRepository;


    public List<OrigineDenree> getAllOrigineDenree () {
        Iterable<OrigineDenree> it = origineDenreeRepository.findAll();
        List<OrigineDenree> ret = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
        return ret;
    }

    public Set<String> getAllPays () {
        List<String> liste = new ArrayList<>();
        Iterable<OrigineDenree> it = origineDenreeRepository.findAll();
        List <OrigineDenree> all = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
        for (int i =0; i < all.size(); i++) {
            liste.add(all.get(i).getPays());
        }
        Set<String> ret = new HashSet<>(liste);
        return ret;
    }

    public Set<String> getRegionByPays (String pays) {
        List<String> liste = new ArrayList<>();
        if (pays != null) {
            List <OrigineDenree> types = origineDenreeRepository.findByPays(pays);
            for (int i =0; i < types.size(); i++) {
                liste.add(types.get(i).getRegion());
            }
        }
        Set<String> ret = new HashSet<>(liste);
        return ret;
    }

}
