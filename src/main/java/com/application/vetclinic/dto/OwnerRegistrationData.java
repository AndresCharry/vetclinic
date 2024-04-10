package com.application.vetclinic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OwnerRegistrationData (
        @NotBlank String dni,
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String phone,
        @NotNull PetId petId
) {
}
