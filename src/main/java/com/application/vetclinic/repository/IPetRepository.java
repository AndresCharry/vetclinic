package com.application.vetclinic.repository;

import com.application.vetclinic.dto.PetData;
import com.application.vetclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {
    @Query("""
    SELECT p
    FROM Pet p
    WHERE p.species = :species
    AND p.breed = :breed
    """)
    List<PetData> findAllPetsWithSpeciesAndBreed(String species, String breed);
}
