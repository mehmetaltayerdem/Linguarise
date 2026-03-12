# LinguaRise 🚀

**English Learning & Exam Preparation Platform**

A fullstack application for learning English and preparing for YDS, YÖKDİL, and IELTS exams. Built with Hexagonal Architecture for clean domain isolation and future microservice migration.

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 17, Spring Boot 3.2, Spring Security |
| Architecture | Hexagonal (Ports & Adapters) |
| Identity | Keycloak 24 (OAuth2 + JWT + RBAC) |
| Database | PostgreSQL 16 + Flyway |
| Document DB | MongoDB 7 |
| Cache | Redis 7 |
| DTO Mapping | MapStruct |
| API Docs | SpringDoc OpenAPI 3 (Swagger) |
| Frontend | React + TypeScript + Tailwind CSS |
| Testing | JUnit 5 + Mockito + Testcontainers |
| DevOps | Docker + Docker Compose |

## Prerequisites

- Java 17+
- Maven 3.9+
- Docker & Docker Compose
- Node.js 20+ (for frontend)

## Quick Start

### 1. Clone & Setup

```bash
git clone https://github.com/YOUR_USERNAME/linguarise.git
cd linguarise
cp .env.example .env    # Edit passwords if needed
```

### 2. Start Infrastructure

```bash
docker compose up -d postgresql mongodb redis keycloak-db keycloak
```

### 3. Configure Keycloak

1. Open http://localhost:8180
2. Login with admin / admin_dev_2026
3. Create realm: `linguarise`
4. Create client: `linguarise-frontend` (public, PKCE)
5. Create client: `linguarise-api` (confidential)
6. Create roles: `ROLE_USER`, `ROLE_ADMIN`

### 4. Run API

```bash
cd linguarise-api
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### 5. Verify

- Health: http://localhost:8080/actuator/health
- Swagger: http://localhost:8080/swagger-ui.html

## Project Structure

```
linguarise/
├── docker-compose.yml
├── linguarise-api/          # Spring Boot API (Hexagonal Architecture)
│   └── src/main/java/com/linguarise/
│       ├── user/            # User management module
│       ├── assessment/      # Placement test module
│       ├── content/         # Lessons, readings, topics
│       ├── quiz/            # Quiz system
│       ├── vocabulary/      # Word notebook + SM-2 spaced repetition
│       └── shared/          # Security, events, exceptions, config
├── linguarise-frontend/     # React + TypeScript (coming soon)
└── docs/                    # Architecture documents & diagrams
```

## Architecture

Hexagonal Architecture with clear separation:
- **Domain**: Pure Java, zero framework dependencies
- **Application**: Use cases, DTOs, mappers
- **Infrastructure**: Controllers, JPA/Mongo repos, external API clients

## License

Private project — All rights reserved.
