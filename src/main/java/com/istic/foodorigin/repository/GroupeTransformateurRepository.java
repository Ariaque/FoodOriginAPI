package com.istic.foodorigin.repository;

import com.istic.foodorigin.models.GroupeTransformateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GroupeTransformateurRepository extends CrudRepository<GroupeTransformateur, Long> {
    @Query("select g from GroupeTransformateur g where g.id in (select t.groupeTransformateur.id from Transformateur t where t.id = ?1)")
    Optional<Set<GroupeTransformateur>> findByTransformateurs_Id(Long id);

    @Query("select g from GroupeTransformateur g inner join g.labels l where l.libelle like %?1%")
    Optional<Set<GroupeTransformateur>> findByLabels(String label);
}
