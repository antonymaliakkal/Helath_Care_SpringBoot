package com.health_care.patients.service;

import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.mapper.PatientMapper;
import com.health_care.patients.model.Patient;
import com.health_care.patients.model.PreExistingIllness;
import com.health_care.patients.repository.PatientRepository;
import com.health_care.patients.repository.PreExistingIllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService{


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PreExistingIllnessRepo preExistingIllnessRepo;

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Patient createPatient(PatientDto dto) {

        //DTO to Patient Entity
        Patient patient = patientMapper.toEntity(dto);
        patientRepository.save(patient);



        //DTO to illness entity
//        preExistingIllnessRepo.save(patientMapper.toIllnessEntity(dto));



        return patient;
    }

    @Override
    public Optional<Patient> getPatient(String phoneno) {
        return patientRepository.findByPhoneno(phoneno);
    }

    @Override
    public Patient updatePatientByPhoneNo(PatientDto dto) {
        Optional<Patient> patient1 = patientRepository.findByPhoneno(dto.phoneno());
        if(patient1.isPresent()){
            Patient patient = patient1.get();
            patient.setName(dto.fullname());
            patient.setEmail(dto.email());
            patient.setPhoneno(dto.phoneno());
            patient.setDob(dto.dob());
            patient.setAddress(dto.address());
            return patientRepository.save(patient);
        }
        throw new RuntimeException("Employee not found with phone number: " + dto.phoneno());
    }

    @Override
    public void deleteById(long id) {
        patientRepository.deleteById(id);
    }
}
