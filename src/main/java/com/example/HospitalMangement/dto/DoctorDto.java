package com.example.HospitalMangement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private String name;
    private String pno;
    private String email;
    private String specialization;
    private String gender;
    private String qualification;
}
