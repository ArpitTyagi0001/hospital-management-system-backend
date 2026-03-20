package com.example.HospitalMangement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private LocalDate appointmentTime;
    private String reason;
    private Long patientId;
    private Long doctorId;
}
