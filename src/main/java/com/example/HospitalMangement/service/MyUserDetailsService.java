package com.example.HospitalMangement.service;

import com.example.HospitalMangement.entity.Users;
import com.example.HospitalMangement.entity.UsersPatient;
import com.example.HospitalMangement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);

        if(users == null) {
            System.out.println("User not Found By username :" + username);
            throw new UsernameNotFoundException("User Not Found username");
        }
        return new UsersPatient(users);
    }
}
