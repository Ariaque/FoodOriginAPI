package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.TypeDenree;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDenreeRepository extends CrudRepository<TypeDenree, Long> {
    List<TypeDenree> findByNom (String nom);
    List<TypeDenree> findByEspece (String espece);
}
