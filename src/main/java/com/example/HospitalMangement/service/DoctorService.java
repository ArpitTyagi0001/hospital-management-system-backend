package com.example.HospitalMangement.service;

import com.example.HospitalMangement.dto.DoctorDto;
import com.example.HospitalMangement.entity.Doctor;
import com.example.HospitalMangement.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<DoctorDto> getDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();

        List<DoctorDto> doctorDtos = doctors.stream()
                .map(doctor -> modelMapper.map(doctor , DoctorDto.class))
                .collect(Collectors.toList());

        return doctorDtos;
    }

    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("doctor not found BY Id :" + id)
        );

        return modelMapper.map(doctor , DoctorDto.class);
    }

    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto , Doctor.class);

        Doctor SaveDoctor = doctorRepository.save(doctor);

        return modelMapper.map(SaveDoctor  , DoctorDto.class);
    }
}
