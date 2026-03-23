🏥 Hospital Management System

A production-grade REST API built with Spring Boot, featuring full CRUD operations, JPA entity relationships, and secure JWT + OAuth2 authentication.

🚀 Tech Stack

Layer	Technology
Backend	Java, Spring Boot
Security	Spring Security, JWT, OAuth2 (Google/GitHub)
Database	PostgreSQL
ORM	JPA / Hibernate
Mapping	ModelMapper
Tools	Postman, pgAdmin, Maven, Git
✨ Features

✅ JWT Authentication — Register, Login, Token-based access
✅ OAuth2 Social Login — Google & GitHub
✅ Role-Based Access Control — ADMIN & USER roles
✅ Full CRUD — Patient, Doctor, Appointment, Insurance, Department
✅ Entity Relationships — OneToOne, ManyToOne, ManyToMany
✅ DTO Pattern with ModelMapper
✅ BCrypt Password Encryption
✅ Stateless Session (STATELESS)
✅ PostgreSQL with data.sql seeding
📁 Project Structure


 🏥 Hospital Management System

A production-grade **REST API** built with **Spring Boot**, featuring full CRUD operations, JPA entity relationships, and secure **JWT + OAuth2** authentication.


🚀 Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java, Spring Boot |
| Security | Spring Security, JWT, OAuth2 (Google/GitHub) |
| Database | PostgreSQL |
| ORM | JPA / Hibernate |
| Mapping | ModelMapper |
| Tools | Postman, pgAdmin, Maven, Git |


✨ Features

✅ JWT Authentication — Register, Login, Token-based access
✅ OAuth2 Social Login — Google & GitHub
✅ Role-Based Access Control — ADMIN & USER roles
✅ Full CRUD — Patient, Doctor, Appointment, Insurance, Department
✅ Entity Relationships — OneToOne, ManyToOne, ManyToMany
✅ DTO Pattern with ModelMapper
✅ BCrypt Password Encryption
✅ Stateless Session (STATELESS)
✅ PostgreSQL with data.sql seeding


📁 Project Structure

src/main/java/com/example/HospitalMangement/
├── config/
│   ├── AppConfig.java          → ModelMapper Bean
│   └── SecurityConfig.java     → JWT + Security config
├── controller/
│   ├── PatientController.java
│   ├── DoctorController.java
│   ├── AppointmentController.java
│   ├── InsuranceController.java
│   ├── DepartmentController.java
│   └── UsersController.java
├── service/
│   ├── PatientService.java
│   ├── DoctorService.java
│   ├── AppointmentService.java
│   ├── InsuranceService.java
│   ├── DepartmentService.java
│   ├── UserService.java
│   ├── JwtService.java
│   └── MyUserDetailsService.java
├── entity/
│   ├── Patient.java
│   ├── Doctor.java
│   ├── Appointment.java
│   ├── Insurance.java
│   ├── Department.java
│   └── Users.java
├── dto/
│   ├── PatientDto.java
│   ├── DoctorDto.java
│   ├── AppointmentDto.java
│   ├── InsuranceDto.java
│   └── DepartmentDto.java
├── repository/
│   ├── PatientRepository.java
│   ├── DoctorRepository.java
│   ├── AppointmentRepository.java
│   ├── InsuranceRepository.java
│   ├── DepartmentRepository.java
│   └── UsersRepository.java
└── filter/
└── JwtFilter.java
    └── JwtFilter.java


🔗 Entity Relationships


Patient  ──(OneToOne)──►  Insurance
Patient  ──(OneToMany)──► Appointment
Doctor   ──(OneToMany)──► Appointment
Doctor   ──(ManyToMany)── Department

📌 API Endpoints

🔐 Auth

Method	URL	Description	Auth
POST	/register	Register new user	❌
POST	/login	Login → returns JWT token	❌

👤 Patient

Method	URL	Description
GET	/AllPatient	Get all patients
GET	/PatientById/{id}	Get patient by ID
POST	/addPatient	Add new patient
PUT	/updatePatient/{id}	Update patient
DELETE	/deletePatient/{id}	Delete patient

👨‍⚕️ Doctor

Method	URL	Description
GET	/doctors	Get all doctors
GET	/DoctorById/{id}	Get doctor by ID
POST	/addDoctor	Add new doctor

📅 Appointment

Method	URL	Description
GET	/AllAppointment	Get all appointments
GET	/AppointmentById/{id}	Get appointment by ID
POST	/AddAppointment	Book appointment

🛡️ Insurance

Method	URL	Description
GET	/AllInsurance	Get all insurance
GET	/InsuranceById/{id}	Get insurance by ID
POST	/addInsurance	Add insurance
🏢 Department

Method	URL	Description
GET	/AllDepartment	Get all departments
⚙️ Setup & Run

Prerequisites

Java 17+
PostgreSQL
Maven
1. Clone the repository

git clone https://github.com/ArpitTyagi0001/HospitalManagementSystem.git
cd HospitalManagementSystem
2. Configure Database


📌 API Endpoints

 🔐 Auth
| Method | URL | Description | Auth |
|--------|-----|-------------|------|
| POST | `/register` | Register new user | ❌ |
| POST | `/login` | Login → returns JWT token | ❌ |

👤 Patient
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/AllPatient` | Get all patients |
| GET | `/PatientById/{id}` | Get patient by ID |
| POST | `/addPatient` | Add new patient |
| PUT | `/updatePatient/{id}` | Update patient |
| DELETE | `/deletePatient/{id}` | Delete patient |

‍⚕️ Doctor
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/doctors` | Get all doctors |
| GET | `/DoctorById/{id}` | Get doctor by ID |
| POST | `/addDoctor` | Add new doctor |

📅 Appointment
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/AllAppointment` | Get all appointments |
| GET | `/AppointmentById/{id}` | Get appointment by ID |
| POST | `/AddAppointment` | Book appointment |

🛡️ Insurance
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/AllInsurance` | Get all insurance |
| GET | `/InsuranceById/{id}` | Get insurance by ID |
| POST | `/addInsurance` | Add insurance |

🏢 Department
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/AllDepartment` | Get all departments |


⚙️ Setup & Run

Prerequisites
Java 17+
PostgreSQL
Maven

1. Clone the repository
bash
git clone https://github.com/ArpitTyagi0001/HospitalManagementSystem.git
cd HospitalManagementSystem


 2. Configure Database
properties

src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hospitaldb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=create
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true

3. Run the application

mvn spring-boot:run
4. Test APIs in Postman

Step 1 — Register:

POST http://localhost:8080/register
{
"username": "arpit",
"password": "1234"
}
Step 2 — Login → Get Token:

POST http://localhost:8080/login
{
"username": "arpit",
"password": "1234"
}
Step 3 — Use Token:

GET http://localhost:8080/AllPatient
Headers → Authorization: Bearer <your_token>
🔒 Security Flow

Register → Save user with BCrypt encrypted password
↓
Login → Verify credentials → Generate JWT Token
↓
Use Token → Send in Authorization header
↓
JwtFilter → Validate token on every request
↓
Access granted ✅

👨‍💻 Author

Arpit Tyagi

GitHub: @ArpitTyagi0001
LinkedIn: arpit-tyagi0001
Email: arpittyagi389@gmail.com



 3. Run the application
bash
mvn spring-boot:run


4. Test APIs in Postman

Step 1 — Register:
json
POST http://localhost:8080/register
{
    "username": "arpit",
    "password": "1234"
}


Step 2 — Login → Get Token:
json
POST http://localhost:8080/login
{
    "username": "arpit",
    "password": "1234"
}



GET http://localhost:8080/AllPatient
Headers → Authorization: Bearer <your_token>
 
🔒 Security Flow

Register → Save user with BCrypt encrypted password
    ↓
Login → Verify credentials → Generate JWT Token
    ↓
Use Token → Send in Authorization header
    ↓
JwtFilter → Validate token on every request
    ↓
Access granted ✅




👨‍💻 Author

Arpit Tyagi
 GitHub: [@ArpitTyagi0001](https://github.com/ArpitTyagi0001)
 LinkedIn: [arpit-tyagi0001](https://linkedin.com/in/arpit-tyagi0001)
Email: arpittyagi389@gmail.com
