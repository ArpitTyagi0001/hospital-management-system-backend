package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.dto.PatientDto;
import com.example.HospitalMangement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/AllPatient")
    public List<PatientDto> getAllPatient(){
        return patientService.getAllPatient();
    }

   @GetMapping("/PatientById/{id}")
    public PatientDto getPatientBYId(@PathVariable  Long id){
        return patientService.getPatientById(id);
   }

   @PostMapping("/addPatient")
    public PatientDto addPatient(@RequestBody PatientDto patientDto){
        return patientService.addPatient(patientDto);
   }

   @PutMapping("/updatePatient/{id}")
    public PatientDto updatepatient(@PathVariable Long id , @RequestBody PatientDto patientDto){
        return patientService.updatePatient(id , patientDto);
   }

   @DeleteMapping("/deletePatient/{id}")
    public String deletepatient(@PathVariable Long id){
        return patientService.deletePatient(id);
   }
}
