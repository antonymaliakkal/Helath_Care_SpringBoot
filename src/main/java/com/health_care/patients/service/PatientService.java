package com.health_care.patients.service;

import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public Patient createPatient(PatientDto dto);

    public Optional<Patient> getPatient(String phoneno);

    public Patient updatePatientByPhoneNo(PatientDto dto);

    public void deleteById(long id);

    public List<String> findPatientIllness(long id);

    public Patient getPatientById(Long id);
}
