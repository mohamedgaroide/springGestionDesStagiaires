package com.project.springGestionDesStagiaires.entity.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StagiaireDto {
    private Long id;

    @NotBlank(message = "Prenom cannot be empty")
    private String nom;

    @NotBlank(message = "Prenom cannot be empty")
    private String prenom;

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
//    private int duree;
//
//    private String departement;
//
//    private String ref ;
//
//    private String encadrant;
//
//    private String typeStage;
//
//    private String note;
}
