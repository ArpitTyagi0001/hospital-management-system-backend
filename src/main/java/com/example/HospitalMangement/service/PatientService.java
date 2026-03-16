package com.example.HospitalMangement.service;

import com.example.HospitalMangement.dto.PatientDto;
import com.example.HospitalMangement.entity.Patient;
import com.example.HospitalMangement.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PatientDto> getP() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientDto> patientDtos = patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());

        return patientDtos;
    }
}
