package com.health_care.patients.service;

import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.model.Patient;

import java.util.Optional;

public interface PatientService {

    public Patient createPatient(PatientDto dto);
    public Optional<Patient> getPatient(String phoneno);
    public Patient updatePatientByPhoneNo(PatientDto dto);
    public void deleteById(long id);
}
