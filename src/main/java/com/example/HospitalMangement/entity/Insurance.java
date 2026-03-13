package com.example.HospitalMangement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 40)
    private String companyName;

    @Column(nullable = false , unique = true , length=20)
    private String policyNumber;

    @Column(nullable = false)
    private LocalDate validTill;

    @OneToOne
    @JoinColumn(name = "Patient_id" , nullable = false)
    private Patient patient;
}
