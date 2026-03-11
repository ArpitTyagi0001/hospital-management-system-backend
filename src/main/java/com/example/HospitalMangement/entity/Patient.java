package com.example.HospitalMangement.entity;

import com.example.HospitalMangement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(
        name = "patient"
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false , length=10)
    private String gender;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(unique = true ,  nullable = false)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

}
