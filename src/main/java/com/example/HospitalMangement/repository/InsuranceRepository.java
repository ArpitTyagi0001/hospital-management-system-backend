package com.example.HospitalMangement.repository;

import com.example.HospitalMangement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}