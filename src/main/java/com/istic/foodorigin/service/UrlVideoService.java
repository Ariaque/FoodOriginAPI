package com.istic.foodorigin.service;

import com.istic.foodorigin.models.UrlVideo;
import com.istic.foodorigin.repository.UrlVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlVideoService {

    @Autowired
    private UrlVideoRepository urlVideoRepository;

    public Iterable<UrlVideo> getAllUrls () {
        Iterable<UrlVideo> urls= urlVideoRepository.findAll();
        return urls;
    }

    public UrlVideo getLabelById(Long id) {
        UrlVideo ret = null;
        Optional <UrlVideo> url = urlVideoRepository.findById(id);
        if (url.isPresent()) {
            ret = url.get();
        }
        return ret;
    }
}
