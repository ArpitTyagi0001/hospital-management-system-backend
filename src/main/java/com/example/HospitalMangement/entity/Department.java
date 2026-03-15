package com.example.HospitalMangement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length=20)
    private String DeptName;

    @ManyToMany
    @JoinTable(name = "doctor_id" )
    private List<Doctor> doctor = new ArrayList<>();
}
