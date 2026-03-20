package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.dto.DoctorDto;
import com.example.HospitalMangement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<DoctorDto> getDoctor(){
        return doctorService.getDoctors();
    }

    @GetMapping("/DoctorById/{id}")
    public DoctorDto getDoctorById(@PathVariable  Long id){
        return doctorService.getDoctorById(id);
    }

    @PostMapping("/addDoctor")
    public DoctorDto addDoctor(@RequestBody DoctorDto doctorDto){
        return doctorService.addDoctor(doctorDto);
    }
}
