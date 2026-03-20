package com.example.HospitalMangement.service;

import com.example.HospitalMangement.dto.InsuranceDto;
import com.example.HospitalMangement.entity.Insurance;
import com.example.HospitalMangement.entity.Patient;
import com.example.HospitalMangement.repository.InsuranceRepository;
import com.example.HospitalMangement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatientRepository patientRepository;

    public List<InsuranceDto> getAllInsurance() {
        List<Insurance> insurances = insuranceRepository.findAll();

        List<InsuranceDto> insuranceDtos = insurances.stream()
                .map(insurance -> modelMapper.map(insurance , InsuranceDto.class))
                .collect(Collectors.toList());

        return insuranceDtos;
    }

    public InsuranceDto getInsuranceById(Long id) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Insurance Not Found by id :"+id)
        );

        return modelMapper.map(insurance , InsuranceDto.class);
    }

    public InsuranceDto addInsurance(InsuranceDto insuranceDto) {
        Insurance insurance = new Insurance();
        insurance.setCompanyName(insuranceDto.getCompanyName());
        insurance.setPolicyNumber(insuranceDto.getPolicyNumber());
        insurance.setValidTill(insuranceDto.getValidTill());


        Patient patient = patientRepository.findById(insuranceDto.getPatientId())
                .orElseThrow(() -> new EntityNotFoundException("Patient Not Found"));

        insurance.setPatient(patient);

        Insurance insuranceSave = insuranceRepository.save(insurance);

        return modelMapper.map(insuranceSave , InsuranceDto.class);
    }
}
