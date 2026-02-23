package com.project.springGestionDesStagiaires.dao;

import com.project.springGestionDesStagiaires.entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StagiaireDao extends JpaRepository<Stagiaire,Long> {
    boolean existsByNomAndPrenom(String nom, String prenom);
}
