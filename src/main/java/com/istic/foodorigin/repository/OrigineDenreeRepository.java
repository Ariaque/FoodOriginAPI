package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.OrigineDenree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrigineDenreeRepository extends CrudRepository<OrigineDenree, Long> {
    List<OrigineDenree> findByPays (String pays);
}
