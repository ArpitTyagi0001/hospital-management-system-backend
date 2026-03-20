package com.example.HospitalMangement.service;

import com.example.HospitalMangement.dto.AppointmentDto;
import com.example.HospitalMangement.entity.Appointment;
import com.example.HospitalMangement.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AppointmentDto> getAllAppointment() {
        List<Appointment> appointments = appointmentRepository.findAll();

        List<AppointmentDto> appointmentDtos = appointments.stream()
                .map(appointment -> modelMapper.map(appointment , AppointmentDto.class))
                .collect(Collectors.toList());

        return appointmentDtos;
    }

    public AppointmentDto getAppoitmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Appointment Not Found By id :" + id)
        );

        return modelMapper.map(appointment , AppointmentDto.class);
    }

    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = modelMapper.map(appointmentDto , Appointment.class);

        Appointment appointmentSave = appointmentRepository.save(appointment);

        return modelMapper.map(appointmentSave , AppointmentDto.class);
    }
}
