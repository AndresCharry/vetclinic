package com.application.vetclinic.model;

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
}
