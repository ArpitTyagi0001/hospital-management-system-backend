package com.example.HospitalMangement.repository;

import com.example.HospitalMangement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}