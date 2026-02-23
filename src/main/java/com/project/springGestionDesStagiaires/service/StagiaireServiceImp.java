package com.project.springGestionDesStagiaires.service;

import com.project.springGestionDesStagiaires.dao.StagiaireDao;
import com.project.springGestionDesStagiaires.entity.Stagiaire;
import com.project.springGestionDesStagiaires.entity.dto.StagiaireDto;
import com.project.springGestionDesStagiaires.entity.mapper.StageMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StagiaireServiceImp implements StagiaireService {
    public final StageMapper stageMapper;
    public final StagiaireDao stagiaireDao;



    @Override
    public List<StagiaireDto> findAll() {
        List<Stagiaire> list = stagiaireDao.findAll();
        return list.stream().map(stageMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public StagiaireDto findById(Long id) {
        Stagiaire entity = stagiaireDao.findById(id).orElseThrow(()-> new RuntimeException("stagiaire number "+id+" not found!!"));
        return stageMapper.mapToDto(entity);
    }

    @Override
    public StagiaireDto create(StagiaireDto stagiaireDto) {
        if (stagiaireDao.existsByNomAndPrenom(stagiaireDto.getNom(),stagiaireDto.getPrenom())){
            throw new  RuntimeException("stagiaire " +stagiaireDto.getNom() + " " +stagiaireDto.getPrenom() + " already exists!!");
        }
        Stagiaire entity = stageMapper.mapToEntity(stagiaireDto);
        Stagiaire savedEntity = stagiaireDao.save(entity);
        return stageMapper.mapToDto(savedEntity);
    }

    @Override
    @Transactional
    public StagiaireDto update(Long id, StagiaireDto stagiaireDto) {
        Stagiaire entity = stagiaireDao.findById(id).orElseThrow(()-> new RuntimeException("stagiaire number "+id+" not found!!"));
        stageMapper.updateStagiaireFromDto(stagiaireDto, entity);
        System.out.println(stagiaireDto);
        return stageMapper.mapToDto(stagiaireDao.saveAndFlush(entity));
    }

    @Override
    public void delete(Long id) {
        Stagiaire entity = stagiaireDao.findById(id).orElseThrow(()-> new RuntimeException("stagiaire number "+id+" not found!!"));
        stagiaireDao.delete(entity);
    }



}
