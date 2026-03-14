package com.example.HospitalMangement.repository;

import com.example.HospitalMangement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}