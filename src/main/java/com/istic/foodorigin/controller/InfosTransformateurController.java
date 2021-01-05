package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.InfosTransformateur;
import com.istic.foodorigin.service.ImageService;
import com.istic.foodorigin.service.InfosTransformateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/infoTransformateur")
public class InfosTransformateurController {

    @Autowired
    private InfosTransformateurService infosService;

    @Autowired
    private ImageService imageService;

    @GetMapping (path = "/{id}", produces = "application/json")
    public InfosTransformateur getInfosById (@PathVariable Long id) {
        InfosTransformateur infosTransformateur = infosService.getInfosById(id);
        return infosTransformateur;
    }

    @PostMapping (consumes = "application/json", produces = "application/json")
    public InfosTransformateur saveInfosTrans (@RequestBody InfosTransformateur infos) {
        return infosService.saveInfos(infos);
    }

    @GetMapping (path = "transformateur/{id}", produces = "application/json")
    public InfosTransformateur getInfosByTransformateur (@PathVariable Long id) {
        InfosTransformateur infosTransformateur = infosService.getInfosByTransformateur (id);
        return infosTransformateur;
    }

    @PostMapping (path = "/images/{id}")
    public boolean saveImage(@RequestParam("myFile") MultipartFile file, @PathVariable Long id) {
        return imageService.saveImageOnServer(file, id);
    }
}
