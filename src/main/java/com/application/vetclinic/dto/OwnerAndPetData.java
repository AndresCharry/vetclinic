package com.application.vetclinic.dto;

import com.application.vetclinic.model.Owner;
import jakarta.validation.constraints.NotBlank;

public record OwnerAndPetData(
        @NotBlank String petName,
        @NotBlank String species,
        @NotBlank String breed,
        @NotBlank String ownerName,
        @NotBlank String ownerLastName
        ) {
        public OwnerAndPetData(Owner owner) {
                this(owner.getPet().getName(),owner.getPet().getSpecies(),owner.getPet().getBreed(),owner.getName(), owner.getLastName());
        }
}
