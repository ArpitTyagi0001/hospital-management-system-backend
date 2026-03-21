package com.example.HospitalMangement.service;

import com.example.HospitalMangement.dto.PatientDto;
import com.example.HospitalMangement.entity.Patient;
import com.example.HospitalMangement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public List<PatientDto> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientDto> patientDtos = patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());

        return patientDtos;
    }

    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                ()-> new RuntimeException( "patient Not Found By id : " + id)
        );

        return modelMapper.map(patient , PatientDto.class);
        // other we make a new PatientDto object and get data each
    }

    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto , Patient.class);

        Patient savedPatient = patientRepository.save(patient);

        return  modelMapper.map(savedPatient , PatientDto.class);
    }

    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        Patient patient = patientRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("patient Not Found By id :" + id));

        modelMapper.map(patientDto , patient);


        Patient patient1 = patientRepository.save(patient);

        return modelMapper.map(patient1 , PatientDto.class);
    }


    public String deletePatient(Long id) {
        patientRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("patient not found :" + id));

        patientRepository.deleteById(id);

        return "Successfully delete";
    }
}
