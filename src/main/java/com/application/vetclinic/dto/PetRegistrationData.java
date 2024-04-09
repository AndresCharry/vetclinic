package com.application.vetclinic.dto;

import jakarta.validation.constraints.NotBlank;

public record PetRegistrationData(
        @NotBlank String name,
        @NotBlank String species,
        @NotBlank String breed,
        @NotBlank String color
) {
}
