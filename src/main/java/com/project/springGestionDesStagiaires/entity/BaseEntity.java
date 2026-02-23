package com.project.springGestionDesStagiaires.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

//    @Column(name = "carte_identité")
//    private String cin;
//
//    private String contact;
//
//    private double salaire;
//
//    private LocalDate dateEntree;
//
//    private LocalDate dateSortie;
//
//    @Column(name = "durée_en_mois")
//    private int duree;
//
//    private String departement;
//
//    private String ref ;

}
