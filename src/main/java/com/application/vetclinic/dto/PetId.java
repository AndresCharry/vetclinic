package com.application.vetclinic.dto;

import jakarta.validation.constraints.NotNull;

public record PetId(
        @NotNull Long id
) {
}
