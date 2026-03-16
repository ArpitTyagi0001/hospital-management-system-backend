package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.dto.PatientDto;
import com.example.HospitalMangement.entity.Patient;
import com.example.HospitalMangement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public List<PatientDto> getPatient(){
        return patientService.getP();
    }
}
