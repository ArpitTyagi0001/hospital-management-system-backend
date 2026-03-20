package com.example.HospitalMangement.controller;

import com.example.HospitalMangement.dto.InsuranceDto;
import com.example.HospitalMangement.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping("/AllInsurance")
    public List<InsuranceDto> getAllInsurance(){
      return  insuranceService.getAllInsurance();
    }

    @GetMapping("/InsuranceById/{id}")
    public InsuranceDto getInsuranceById(@PathVariable Long id){
        return insuranceService.getInsuranceById(id);
    }

    @PostMapping("/AddInsurance")
    public InsuranceDto addInsurance(@RequestBody InsuranceDto insuranceDto){
        return insuranceService.addInsurance(insuranceDto);
    }
}
