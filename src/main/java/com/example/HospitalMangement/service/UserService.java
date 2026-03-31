package com.example.HospitalMangement.service;

import com.example.HospitalMangement.entity.Users;
import com.example.HospitalMangement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public Users getRegister(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));

        return usersRepository.save(users);
    }

    public String login(Users users) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername() , users.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(users.getUsername());
        }
        return "Fail";
    }
}
