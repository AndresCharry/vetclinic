package com.application.vetclinic.model;

import com.application.vetclinic.dto.PetId;
import com.application.vetclinic.dto.PetRegistrationData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String color;


    public Pet(PetRegistrationData petRegistrationData) {
        this.name = petRegistrationData.name();
        this.species = petRegistrationData.species();
        this.breed = petRegistrationData.breed();
        this.color = petRegistrationData.color();
    }

    public Pet(PetId petId) {
        this.id = petId.id();
    }
}
