package com.example.HospitalMangement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {
    private Long id;
    private String companyName;
    private String policyNumber;
    private LocalDate validTill;
    private Long patientId;
    private String patientName;
}
