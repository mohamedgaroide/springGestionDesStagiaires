package com.project.springGestionDesStagiaires.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "list_des_stagiaires")
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Stagiaire extends BaseEntity{

}

