package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.FermePartenaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FermePartenaireRepository extends CrudRepository <FermePartenaire, Long> {
}
