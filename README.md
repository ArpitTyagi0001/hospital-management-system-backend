# Hospital Management System

A REST API built with Spring Boot for managing hospital operations — patients, doctors, appointments, insurance, and departments — with secure JWT and OAuth2 authentication.

## Tech Stack

- Backend: Java, Spring Boot
- Security: Spring Security, JWT, OAuth2 (Google/GitHub)
- Database: PostgreSQL
- ORM: JPA / Hibernate
- Mapping: ModelMapper
- Tools: Postman, pgAdmin, Maven, Git

## Features

- JWT authentication — register, login, token-based access
- OAuth2 social login with Google and GitHub
- Role-based access control (ADMIN and USER roles)
- Full CRUD for Patient, Doctor, Appointment, Insurance, and Department
- Entity relationships — OneToOne, ManyToOne, ManyToMany
- DTO pattern using ModelMapper
- BCrypt password encryption
- Stateless session management
- PostgreSQL with data.sql seeding

## Entity Relationships

- Patient to Insurance — OneToOne
- Patient to Appointment — OneToMany
- Doctor to Appointment — OneToMany
- Doctor to Department — ManyToMany

## API Endpoints

Auth
- POST /register — register a new user
- POST /login — login and get JWT

Patient
- GET /AllPatient — get all patients
- GET /PatientById/{id} — get patient by ID
- POST /addPatient — add new patient
- PUT /updatePatient/{id} — update patient
- DELETE /deletePatient/{id} — delete patient

Doctor
- GET /doctors — get all doctors
- GET /DoctorById/{id} — get doctor by ID
- POST /addDoctor — add new doctor

Appointment
- GET /AllAppointment — get all appointments
- GET /AppointmentById/{id} — get appointment by ID
- POST /AddAppointment — book appointment

Insurance
- GET /AllInsurance — get all insurance records
- GET /InsuranceById/{id} — get insurance by ID
- POST /addInsurance — add insurance

Department
- GET /AllDepartment — get all departments

## Setup and Run

Prerequisites: Java 17+, PostgreSQL, Maven

1. Clone the repository

git clone https://github.com/ArpitTyagi0001/HospitalManagementSystem.git
cd HospitalManagementSystem

2. Configure application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/hospitaldb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=create
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true

3. Run the application

mvn spring-boot:run

## Usage Example

Register

POST http://localhost:8080/register
Content-Type: application/json

{
  "username": "arpit",
  "password": "1234"
}

Login

POST http://localhost:8080/login
Content-Type: application/json

{
  "username": "arpit",
  "password": "1234"
}

Authenticated request

GET http://localhost:8080/AllPatient
Authorization: Bearer <your_token>

## Auth Flow

Register saves the user with BCrypt-hashed password. Login generates a JWT. The token is sent in the request header on future calls. JwtFilter validates the token before granting access.

## Author

Arpit Tyagi
GitHub: https://github.com/ArpitTyagi0001
LinkedIn: https://www.linkedin.com/in/arpit-tyagi0001/
Email: arpittyagi389@gmail.com
