# Hospital Management System

A backend service for managing patients, doctors, departments, insurance records, and appointments, built on Spring Boot with stateless JWT authentication. The codebase follows a layered architecture — controller, service, repository, entity — with DTOs used at the API boundary to keep the persistence model decoupled from what clients see.

**Stack:** Java 17 · Spring Boot 3 · Spring Security · Spring Data JPA · PostgreSQL · ModelMapper · Maven

---

## Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Project structure](#project-structure)
- [Domain model](#domain-model)
- [API reference](#api-reference)
- [Getting started](#getting-started)
- [Design decisions](#design-decisions)
- [Known limitations](#known-limitations)
- [Roadmap](#roadmap)
- [Author](#author)
- [License](#license)

---

## Overview

The system models a hospital's core operational data — **patients**, **doctors**, **departments**, **insurance**, and **appointments** — behind a JWT-protected API. A user registers and logs in through dedicated endpoints; the login endpoint returns a signed token that must accompany all subsequent requests. Every request passes through a custom `OncePerRequestFilter` that validates the token and populates the Spring Security context before the request reaches a controller.

Entities are never returned directly from controllers. Each domain object has a corresponding DTO, and ModelMapper handles the conversion in the service layer, which keeps the API contract stable even if the underlying schema changes.

## Architecture

```
Client
  │
  ▼
JwtFilter            validates the Bearer token, sets the SecurityContext
  │
  ▼
Controller           request/response mapping, no business logic
  │
  ▼
Service               business logic, entity ⇄ DTO conversion
  │
  ▼
Repository            Spring Data JPA
  │
  ▼
PostgreSQL
```

## Project structure

```
src/main/java/com/example/HospitalMangement/
├── config/
│   ├── AppConfig.java
│   ├── JwtFilter.java
│   └── SecurityConfig.java
├── controller/
│   ├── DepartmentController.java
│   ├── DoctorController.java
│   ├── InsuranceController.java
│   └── PatientController.java
├── service/
│   ├── AppointmentService.java
│   ├── DepartmentService.java
│   ├── DoctorService.java
│   ├── InsuranceService.java
│   ├── PatientService.java
│   ├── UserService.java
│   └── JWTService.java
├── repository/
│   ├── AppointmentRepository.java
│   ├── DoctorRepository.java
│   ├── PatientRepository.java
│   ├── InsuranceRepository.java
│   └── UsersRepository.java
├── entity/
│   ├── Department.java
│   ├── Doctor.java
│   ├── Insurance.java
│   ├── Patient.java
│   ├── Users.java
│   ├── UsersPatient.java
│   └── type/BloodGroupType.java
├── dto/
│   ├── AppointmentDto.java
│   ├── DepartmentDto.java
│   ├── DoctorDto.java
│   ├── InsuranceDto.java
│   └── PatientDto.java
└── HospitalMangementApplication.java
```

## Domain model

```
Department  ──ManyToMany──  Doctor
Doctor      ──OneToMany───  Appointment
Patient     ──OneToMany───  Appointment
Patient     ──OneToOne────  Insurance
```

- A **Patient** can have many appointments and exactly one insurance record.
- A **Doctor** can belong to multiple departments and have many appointments.
- Deleting a **Patient** cascades to their appointments and insurance record (`cascade = ALL`, `orphanRemoval = true`).

## API reference

### Authentication

| Method | Endpoint    | Description                    | Auth |
|--------|-------------|----------------------------------|------|
| POST   | `/register` | Register a new user              | No   |
| POST   | `/login`    | Authenticate, returns a JWT      | No   |

### Patients

| Method | Endpoint                  | Description           | Auth |
|--------|-----------------------------|-------------------------|------|
| GET    | `/AllPatient`               | List all patients       | Yes  |
| GET    | `/PatientById/{id}`         | Get a patient by ID     | Yes  |
| POST   | `/addPatient`               | Create a patient        | Yes  |
| PUT    | `/updatePatient/{id}`       | Update a patient        | Yes  |
| DELETE | `/deletePatient/{id}`       | Delete a patient        | Yes  |

### Doctors

| Method | Endpoint              | Description           | Auth |
|--------|-------------------------|-------------------------|------|
| GET    | `/doctors`              | List all doctors        | Yes  |
| GET    | `/DoctorById/{id}`      | Get a doctor by ID      | Yes  |
| POST   | `/addDoctor`            | Create a doctor         | Yes  |

### Departments

| Method | Endpoint         | Description             | Auth |
|--------|--------------------|----------------------------|------|
| GET    | `/AllDepartment`   | List all departments       | Yes  |

### Insurance

| Method | Endpoint                | Description                | Auth |
|--------|---------------------------|------------------------------|------|
| GET    | `/AllInsurance`           | List all insurance records   | Yes  |
| GET    | `/InsuranceById/{id}`     | Get an insurance record by ID| Yes  |
| POST   | `/AddInsurance`           | Create an insurance record   | Yes  |

Every protected route expects `Authorization: Bearer <token>`, where the token is obtained from `/login`.

**Example — register, log in, and call a protected endpoint:**

```bash
curl -X POST http://localhost:8080/register \
  -H "Content-Type: application/json" \
  -d '{"username": "arpit", "password": "securePass123"}'

curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/json" \
  -d '{"username": "arpit", "password": "securePass123"}'
# → returns a JWT string

curl -X GET http://localhost:8080/AllPatient \
  -H "Authorization: Bearer <token>"
```

## Getting started

### Prerequisites

- Java 17+
- Maven 3.8+
- PostgreSQL 13+ (or MySQL, with minor configuration changes)

### Configuration

Set the following in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

### Run

```bash
git clone https://github.com/ArpitTyagi0001/hospital-management-system-backend.git
cd hospital-management-system-backend
mvn clean install
mvn spring-boot:run
```

The API starts on `http://localhost:8080`.

## Design decisions

- **DTOs at the boundary.** Controllers never expose JPA entities directly, avoiding accidental serialization of lazy-loaded associations (e.g. a `Doctor`'s `Department` list) and keeping the API contract independent of schema changes.
- **Stateless authentication.** JWT was chosen over session-based auth so the API can scale horizontally without sticky sessions or a shared session store.
- **`AmbiguityIgnored` on ModelMapper.** Enabled specifically so `AppointmentDto` (which references `patientId`/`doctorId` rather than nested objects) maps cleanly without ModelMapper flagging ambiguous matches.
- **Cascading ownership.** `Patient` owns the cascade for both `Appointment` and `Insurance`, reflecting that neither should exist independently of a patient record.
- **BCrypt strength 12.** A higher-than-default work factor was chosen for password hashing, trading a small amount of login latency for stronger resistance to offline brute-force attempts.

## Known limitations

- The JWT signing key is generated at application startup rather than loaded from configuration. Tokens don't survive an application restart and won't work across multiple instances behind a load balancer — the key should be externalized before this goes to production.
- `SecurityConfig` enables both `httpBasic()` and the JWT filter chain. In a purely stateless, token-based API, HTTP Basic auth is generally redundant and worth removing to keep a single, consistent auth mechanism.
- `AppointmentService` exists but has no corresponding `AppointmentController` yet — appointment creation and retrieval aren't currently reachable via the API.
- There is no global exception handler; not-found and validation errors currently propagate as default Spring error responses rather than a consistent API error format.
- No role or permission model yet (e.g. distinguishing hospital staff from patients) — any authenticated user can access every endpoint.
- No automated test coverage.

## Roadmap

- [ ] Add `AppointmentController` to expose appointment booking and retrieval
- [ ] Externalize the JWT secret via configuration/environment variables
- [ ] Remove redundant `httpBasic()` config in favor of JWT-only authentication
- [ ] Role-based access control (admin / doctor / patient)
- [ ] Centralized exception handling with a consistent error response shape
- [ ] Pagination and filtering on list endpoints
- [ ] OpenAPI/Swagger documentation
- [ ] Unit and integration tests (JUnit, Mockito)
- [ ] Docker Compose setup for local development

## Author

**Arpit Tyagi** — Java Full Stack Developer

- GitHub — [ArpitTyagi0001](https://github.com/ArpitTyagi0001)
- LinkedIn — [arpit-tyagi0001](https://www.linkedin.com/in/arpit-tyagi0001/)
- Email — [arpittyagi389@gmail.com](mailto:arpittyagi389@gmail.com)
- LeetCode — [ArpitTyagi123](https://leetcode.com/u/ArpitTyagi123/)

## License

Licensed under the MIT License.
