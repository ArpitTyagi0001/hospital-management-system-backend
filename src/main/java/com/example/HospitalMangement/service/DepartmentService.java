package com.example.HospitalMangement.service;

import com.example.HospitalMangement.dto.DepartmentDto;
import com.example.HospitalMangement.entity.Department;
import com.example.HospitalMangement.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<DepartmentDto> AllDepartment() {
        List<Department> department = departmentRepository.findAll();

        List<DepartmentDto> departmentDtos = department.stream()
                .map(department1 -> modelMapper.map(department1 , DepartmentDto.class))
                .collect(Collectors.toList());

        return departmentDtos;
    }
}
