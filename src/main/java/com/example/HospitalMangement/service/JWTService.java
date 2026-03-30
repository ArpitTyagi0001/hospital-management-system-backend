package com.example.HospitalMangement.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {

    public String generateToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkFycGl0IFR5YWdpIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.MMpt-iKB9rNgFT_YAJdfHWznkP7wodcJ6TfnHDG1eAw";
    }
}
