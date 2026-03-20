package com.example.HospitalMangement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate appointmentTime;

    @Column(nullable = false , length = 40)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id" , nullable = false)//not null appointment table patient id
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id" , nullable = false)
    private Doctor doctor;
}
