package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.dto.AppointmentDto;
import com.example.HospitalMangement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/AllAppointment")
    public List<AppointmentDto> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/AppointmentById/{id}")
    public AppointmentDto getAppoitmentById(@PathVariable Long id){
       return  appointmentService.getAppoitmentById(id);
    }

    @PostMapping("/AddAppointment")
    public AppointmentDto addAppointment(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.addAppointment(appointmentDto);
    }
}
