package com.project.springGestionDesStagiaires.entity.dto;

import lombok.Data;
import jakarta.validation.constraints.*; // or javax.validation.constraints
import java.time.LocalDate;
import java.util.UUID;

@Data
public class AddStagiaireDto {

    // --- Personal Info (From BaseEntity) ---
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

//    @NotBlank(message = "Le CIN est obligatoire")
//    private String cin;
//
//    private String contact;
//
//    // --- Contract Info (From BaseEntity) ---
//    @PositiveOrZero(message = "Le salaire ne peut pas être négatif")
//    private double salaire;
//
//    @NotNull(message = "La date d'entrée est obligatoire")
//    private LocalDate dateEntree;
//
//    @Min(value = 1, message = "La durée doit être d'au moins 1 mois")
//    private int duree;
//
//    @NotBlank(message = "Le département est obligatoire")
//    private String departement;
//
//    private String ref = UUID.randomUUID().toString();
//
//    // --- stage Info (From Stagiaire) ---
//    private String encadrant;
//
//    @NotBlank(message = "Le type de stage est obligatoire")
//    private String typeStage;


}