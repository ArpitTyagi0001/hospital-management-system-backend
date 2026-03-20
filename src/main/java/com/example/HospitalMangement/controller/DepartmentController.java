package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.dto.DepartmentDto;
import com.example.HospitalMangement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private  DepartmentService departmentService;

    @GetMapping("/AllDepartment")
    public List<DepartmentDto> getAllDepartment(){
        return departmentService.AllDepartment();
    }
}
