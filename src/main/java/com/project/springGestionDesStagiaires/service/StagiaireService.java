package com.project.springGestionDesStagiaires.service;

import com.project.springGestionDesStagiaires.entity.dto.StagiaireDto;
import jakarta.transaction.Transactional;


import java.util.List;


public interface StagiaireService {
    // 1. Return the raw List, not ResponseEntity
    List<StagiaireDto> findAll();

    // 2. Return the DTO (or Entity), allow it to throw an exception if not found
    StagiaireDto findById(Long id);

    // 3. Return the created object so the Controller can send it back
    StagiaireDto create(StagiaireDto stagiaireDto);

    // 4. Return the updated object
    StagiaireDto update(Long id, StagiaireDto stagiaireDto);

    // 5. Return void. If the ID doesn't exist, throw an exception.
    void delete(Long id);

//    StagiaireDto mapToStagiaireDto(Stagiaire stagiaire);
}
