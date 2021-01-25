package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.UrlVideo;
import com.istic.foodorigin.service.UrlVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Point of contact allowing client applications
 * to retrieve information about {@link UrlVideo} from database.
 */
@RestController
@RequestMapping("/urlVideo")
public class UrlVideoController {

    @Autowired
    private UrlVideoService urlVideoService;

    @GetMapping(path = "/all", produces = "application/json")
    public Set<UrlVideo> getAllUrls() {
        Iterable<UrlVideo> itUrl = urlVideoService.getAllUrls();
        List<UrlVideo> urls = StreamSupport.stream(itUrl.spliterator(), false).collect(Collectors.toList());
        Set<UrlVideo> ret = new HashSet<>(urls);
        return ret;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public UrlVideo getUrlById(@PathVariable Long id) {
        UrlVideo url = urlVideoService.getUrlById(id);
        return url;
    }
}
