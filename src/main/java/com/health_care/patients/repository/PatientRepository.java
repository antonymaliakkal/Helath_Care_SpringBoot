package com.health_care.patients.repository;

import com.health_care.patients.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long>{

    public Optional<Patient> findByPhoneno(String Phoneno);

//    Optional<Patient> findByName(String name);
}
