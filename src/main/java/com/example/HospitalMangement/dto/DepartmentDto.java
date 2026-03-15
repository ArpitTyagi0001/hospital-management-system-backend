package com.example.HospitalMangement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long Id;
    private String deptName;
    private List<Long> doctorIds;
    private List<String> doctorNames;
}
