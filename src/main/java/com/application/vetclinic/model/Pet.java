package com.application.vetclinic.model;

import com.application.vetclinic.dto.PetData;
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

    public void updateData(PetData petData){
        this.id = petData.id();
        this.name = petData.name();
        this.species = petData.species();
        this.breed = petData.breed();
        this.color = petData.color();
    }
}
