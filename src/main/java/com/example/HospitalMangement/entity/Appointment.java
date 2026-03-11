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
    private LocalDate meeting;
}
