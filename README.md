# 🚀 SpringGestionDesStagiaires

> RESTful Backend API built with Spring Boot for managing interns in small companies.

---

## 📌 Overview

SpringGestionDesStagiaires is a backend REST API developed using Spring Boot.  
It allows small companies to manage interns digitally instead of using Excel files, reducing the risk of data loss and ensuring proper data validation.

This project was built as part of my preparation for backend internship and junior Java/Spring developer roles.

---

# 🇫🇷 Version Française

## 🎯 Objectif

Ce projet a été réalisé afin de :

- Apprendre et maîtriser Spring Boot
- Comprendre et appliquer une architecture en couches (Layered Architecture)
- Implémenter une API REST complète
- Utiliser DTO + MapStruct
- Mettre en place des règles métier
- Appliquer la validation des données
- Me préparer à un stage ou poste junior backend

---

## 🛠️ Technologies Utilisées

- **Java 21**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Lombok**
- **MapStruct**
- **Jakarta Bean Validation**

---

## 🏗️ Architecture

Le projet suit une architecture en couches :

Controller → Service → Repository → Entity  
DTO + Mapper (MapStruct)

### 🔐 Choix de Conception

- Utilisation des DTO pour éviter d’exposer directement les entités de la base de données
- Implémentation des règles métier dans la couche Service
- Séparation entre l’index affiché côté client (1,2,3...) et l’ID réel de la base de données afin d’éviter l’exposition des identifiants internes
- Vérification des doublons (nom + prénom)
- Gestion des erreurs avec `orElseThrow()`

---

## 🚀 Fonctionnalités

- Créer un stagiaire
- Récupérer tous les stagiaires
- Récupérer un stagiaire par ID
- Modifier un stagiaire
- Supprimer un stagiaire
- Validation des champs avec `@NotBlank`
- Prévention des doublons (nom + prénom)

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /stagiaires | Récupérer tous les stagiaires |
| GET | /stagiaires/{id} | Récupérer un stagiaire par ID |
| POST | /stagiaires | Créer un stagiaire |
| PUT | /stagiaires/{id} | Modifier un stagiaire |
| DELETE | /stagiaires/{id} | Supprimer un stagiaire |

---

## 🧪 Exemple de Requête

### ➕ Création d’un stagiaire

```json
POST /stagiaires
{
  "nom": "Dupont",
  "prenom": "Jean"
}
```

### ✅ Réponse

```json
{
  "id": 1,
  "nom": "Dupont",
  "prenom": "Jean"
}
```

---

## 🗄️ Configuration Base de Données

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/newmydb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8081
```

⚠️ Adapter le username/password selon votre configuration locale.

---

## ▶️ Lancer le Projet

```bash
mvn spring-boot:run
```

Serveur disponible sur :  
http://localhost:8081

---

## 🔮 Améliorations Futures

- Implémentation d’un Global Exception Handler (`@ControllerAdvice`)
- Ajout de pagination
- Ajout de recherche et filtrage
- Documentation Swagger / OpenAPI
- Sécurité avec Spring Security
- Tests unitaires plus avancés

---

# 🇬🇧 English Version

## 🎯 Purpose

This project was built to:

- Master Spring Boot
- Apply layered architecture principles
- Implement a complete REST API
- Use DTO & MapStruct
- Apply business validation rules
- Prepare for backend internship / junior roles

---

## 🏗️ Architecture

Layered architecture:

Controller → Service → Repository → Entity  
DTO + Mapper (MapStruct)

### 🔐 Design Decisions

- DTO usage to prevent exposing internal database entities
- Business validation implemented in the Service layer
- Separation between frontend display index (1,2,3...) and database primary key to prevent internal ID exposure
- Duplicate prevention (nom + prenom)
- Exception handling using `orElseThrow()`

---

## 🚀 Features

- Full REST CRUD operations
- Field validation using `@NotBlank`
- Business rule validation
- MySQL integration via JPA
- Clean service-layer implementation

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /stagiaires | Get all interns |
| GET | /stagiaires/{id} | Get intern by ID |
| POST | /stagiaires | Create intern |
| PUT | /stagiaires/{id} | Update intern |
| DELETE | /stagiaires/{id} | Delete intern |

---

## 🎯 Career Objective

This project demonstrates my ability to design and implement a structured backend REST API using modern Java/Spring technologies as part of my preparation for backend internship and junior developer positions.
