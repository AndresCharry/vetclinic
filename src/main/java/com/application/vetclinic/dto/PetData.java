package com.application.vetclinic.dto;

import com.application.vetclinic.model.Pet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetData(
        @NotNull Long id,
        @NotBlank String name,
        @NotBlank String species,
        @NotBlank String breed,
        @NotBlank String color
) {
    public PetData(Pet pet) {
        this(pet.getId(), pet.getName(), pet.getSpecies(), pet.getBreed(), pet.getColor());
    }
}
