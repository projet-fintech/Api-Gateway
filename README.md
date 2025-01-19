# Api-Gateway


![image](https://github.com/user-attachments/assets/da66ce05-714c-4929-bab8-662a17d831fc)



## Description
Le microservice API Gateway agit comme un point d'entrée unique pour toutes les requêtes du système. Il redirige les requêtes vers les microservices appropriés tout en vérifiant les tokens des utilisateurs et leurs rôles pour garantir les droits d'accès.

## Fonctionnalités
- Redirection des requêtes vers les microservices.
- Vérification des tokens JWT des utilisateurs.
- Gestion des droits d'accès en fonction des rôles.

## Dépendances
- Spring Cloud Gateway
- Spring Security
- Eureka Client

## Configuration
- Assurez-vous que le service Eureka est en cours d'exécution.
- Définissez les endpoints des microservices dans le fichier `application.yml`.
