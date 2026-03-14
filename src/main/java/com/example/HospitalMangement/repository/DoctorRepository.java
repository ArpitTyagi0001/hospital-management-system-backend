package com.example.HospitalMangement.repository;

import com.example.HospitalMangement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}