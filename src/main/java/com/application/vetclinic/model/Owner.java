package com.application.vetclinic.model;

import com.application.vetclinic.dto.OwnerRegistrationData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Owner {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String dni;
    private String name;
    private String LastName;
    private String Phone;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(
            name = "fk_id_pet",
            referencedColumnName = "id"
    )
    private Pet pet;

    public Owner(OwnerRegistrationData ownerRegistrationData) {
        this.dni = ownerRegistrationData.dni();
        this.name = ownerRegistrationData.name();
        this.LastName = ownerRegistrationData.lastName();
        this.Phone = ownerRegistrationData.phone();
        this.pet = new Pet(ownerRegistrationData.petId());
    }
}
