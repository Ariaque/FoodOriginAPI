package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.OrigineDenree;
import com.istic.foodorigin.service.OrigineDenreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Point of contact allowing client applications
 * to retrieve information about {@link OrigineDenree} from database.
 */
@RestController
@RequestMapping("/origineDenree")
public class OrigineDenreeController {

    @Autowired
    private OrigineDenreeService origineDService;


    @GetMapping(path = "/all", produces = "application/json")
    public List<OrigineDenree> getAll() {
        List<OrigineDenree> origines = origineDService.getAllOrigineDenree();
        return origines;
    }

    @GetMapping(path = "/pays", produces = "application/json")
    public Set<String> getAllNomPays() {
        Set<String> ret = origineDService.getAllPays();
        return ret;
    }

    @GetMapping(path = "/regions", produces = "application/json")
    public Set<String> getRegionsByPays(@RequestParam("pays") String pays) {
        Set<String> ret = origineDService.getRegionByPays(pays);
        return ret;
    }


}
