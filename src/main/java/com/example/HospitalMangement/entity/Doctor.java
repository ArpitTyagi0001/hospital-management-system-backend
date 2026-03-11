package com.example.HospitalMangement.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 40)
    private String name;

    @Column(unique = true , nullable = false , length = 15)
    private String pno;

    @Column(unique = true , nullable = false , length = 40)
    private String email;

    @Column(nullable = false , length=40)
    private String specialization;

    @Column(nullable = false , length=10)
    private String gender;

    @Column(nullable = false , length = 20)
    private String qualification;
}
