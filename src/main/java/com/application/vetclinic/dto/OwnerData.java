package com.application.vetclinic.dto;

import com.application.vetclinic.model.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OwnerData (
        @NotNull Long id,
        @NotBlank String dni,
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String phone,
        @NotNull PetId petId
){
    public OwnerData(Owner owner) {
        this(owner.getId(), owner.getDni(), owner.getName(), owner.getLastName(), owner.getPhone(), new PetId(owner.getPet().getId()));
    }
}
