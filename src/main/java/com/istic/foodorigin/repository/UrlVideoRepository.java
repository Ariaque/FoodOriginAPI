package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.UrlVideo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlVideoRepository extends CrudRepository<UrlVideo, Long> {
}
