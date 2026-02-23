package com.project.springGestionDesStagiaires.controller;

import com.project.springGestionDesStagiaires.entity.dto.StagiaireDto;
import com.project.springGestionDesStagiaires.service.StagiaireService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stagiaires")
@RequiredArgsConstructor
public class StagiaireController {
    private final StagiaireService stagiaireService;


    @PostMapping  //Create
    public ResponseEntity<StagiaireDto> createStagiaire(@Valid @RequestBody StagiaireDto stagiaireDto){
        StagiaireDto createdDto = stagiaireService.create(stagiaireDto);
    return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
    }

    @GetMapping  //Read all
    public ResponseEntity<List<StagiaireDto>> getListStagiaire(){
        List<StagiaireDto> stagiaires = stagiaireService.findAll();
        return ResponseEntity.ok(stagiaires);
    }

    @GetMapping("/{id}")  //Read by id
    public ResponseEntity<StagiaireDto> getStagiaire(@PathVariable Long id){
        StagiaireDto dto =  stagiaireService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")  //Update by id
    public ResponseEntity<StagiaireDto> updateStagiaire(@PathVariable Long id, @Valid @RequestBody StagiaireDto stagiaireDto) {
        StagiaireDto updatedDto = stagiaireService.update(id,stagiaireDto);
    return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")  //Delete
    public ResponseEntity<Void> deleteStagiaire(@PathVariable Long id){
        stagiaireService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
