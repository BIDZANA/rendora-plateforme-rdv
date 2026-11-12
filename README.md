# RENDORA - Refonte hexagonale (premier jalon)

Backend Java 21 / Spring Boot 3.5.3, PostgreSQL, Flyway, ports et adaptateurs.

## Démarrage
1. Installer Java 21, Maven et Docker.
2. `docker compose up -d`
3. `cd rendora-backend && mvn test && mvn spring-boot:run`

L’API `POST /api/v1/appointments` est **protégée** par Spring Security HTTP Basic provisoire. Identifiants de développement fournis par Spring Boot au démarrage (utilisateur `user`, mot de passe généré dans les logs). Aucun JWT n'est encore implémenté.

Exemple JSON :
```json
{ "professionalId":"11111111-1111-1111-1111-111111111111", "clientId":"22222222-2222-2222-2222-222222222222", "startsAt":"2027-01-10T10:00:00Z", "endsAt":"2027-01-10T10:30:00Z" }
```

## Périmètre et limites
- Premier cas d'utilisation uniquement : réservation et contrôle des chevauchements.
- La contrainte PostgreSQL empêche les doubles réservations concurrentes, mais l'erreur SQL doit encore être traduite en réponse HTTP 409.
- Les identifiants client/professionnel ne sont pas encore vérifiés ; aucune gestion des comptes, prestations, disponibilités récurrentes, fuseaux horaires métier, annulations, notifications ou frontend.
- Pas de CI/CD, pas de tests d'intégration ni de sécurité de production.
- Les tests Maven ne sont pas encore exécutés dans cet environnement.
