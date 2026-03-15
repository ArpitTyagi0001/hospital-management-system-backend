package com.example.HospitalMangement.dto;

import com.example.HospitalMangement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
    private String name;
    private String gender;
    private Date dob;
    private String email;
    private BloodGroupType bloodGroup;
}
