package com.project.springGestionDesStagiaires.entity.mapper;

import com.project.springGestionDesStagiaires.entity.Stagiaire;
import com.project.springGestionDesStagiaires.entity.dto.StagiaireDto;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface StageMapper {
    Stagiaire mapToEntity(StagiaireDto stagiaireDto);

    StagiaireDto mapToDto(Stagiaire stagiaire);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(target = "id", ignore = true)
    void updateStagiaireFromDto(StagiaireDto stagiaireDto,@MappingTarget Stagiaire entity);
}
