package com.healthconnection.application.configuration.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.secondaryports.repository.concrete.healthprofessional.HealthProfessionalRepository;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PatientRepository patientRepository;
    private final HealthProfessionalRepository healthProfessionalRepository;

    public CustomUserDetailsService(PatientRepository patientRepository, HealthProfessionalRepository healthProfessionalRepository) {
        this.patientRepository = patientRepository;
        this.healthProfessionalRepository = healthProfessionalRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        PatientEntity patientEntity = patientRepository.findByEmail(username)
                .orElse(null);
        
        
        if (patientEntity == null) {
            HealthProfessionalEntity healthProfessionalEntity = healthProfessionalRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("HEALTH_ROLE");

            return new org.springframework.security.core.userdetails.User(
                    healthProfessionalEntity.getEmail(),
                    healthProfessionalEntity.getPassword(),
                    healthProfessionalEntity.isAccountStatement(),
                    true,true,true,
                    List.of(authority)
            );
        } else {
           
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER_ROLE");

            return new org.springframework.security.core.userdetails.User(
                    patientEntity.getEmail(),
                    patientEntity.getPassword(),
                    patientEntity.isAccountStatement(),
                    true, true, true, List.of(authority)
            );
        }
    }
}

