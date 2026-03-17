package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.dto.DoctorDto;
import com.example.HospitalMangement.entity.Doctor;
import com.example.HospitalMangement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorContoller {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<DoctorDto> getDoctor(){
        return doctorService.getDoctors();
    }
}
