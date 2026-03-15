package com.example.HospitalMangement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;
    private LocalDateTime appointment_time;
    private String reason;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
}
