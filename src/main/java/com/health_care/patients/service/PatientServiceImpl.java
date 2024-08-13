package com.health_care.patients.service;

import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.exception.PatientNotFoundException;
import com.health_care.patients.mapper.PatientMapper;
import com.health_care.patients.model.Patient;
import com.health_care.patients.model.PreExistingIllness;
import com.health_care.patients.repository.PatientRepository;
import com.health_care.patients.repository.PreExistingIllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

        return patient;
    }

    @Override
    public Optional<Patient> getPatient(String phoneno) {
        return patientRepository.findByPhoneno(phoneno);

    }

    PreExistingIllness findOrCreateIllness(String illness){
        Optional<PreExistingIllness> optionalIllness = preExistingIllnessRepo.findByIllness(illness);
        if(optionalIllness.isPresent()){
            return optionalIllness.get();
        }
        else {
            return new PreExistingIllness(illness);
        }
    }

    Patient updatePatient(Patient patient , PatientDto dto){
        patient.setName(dto.fullname());
        patient.setEmail(dto.email());
        patient.setPhoneno(dto.phoneno());
        patient.setDob(dto.dob());
        patient.setAddress(dto.address());
        patient.setIllness(dto.illness());

        patient.getPreExistingIllnesses().clear();


        for (String illnessName : dto.preExistingIllnesses()) {
            PreExistingIllness illness = findOrCreateIllness(illnessName);
            patient.getPreExistingIllnesses().add(illness);
        }

        return patient;
    }


    @Override
    public Patient updatePatientByPhoneNo(PatientDto dto) {
        Optional<Patient> patient1 = patientRepository.findByPhoneno(dto.phoneno());
        if(patient1.isPresent()){
            Patient patient = patient1.get();
            return patientRepository.save(updatePatient(patient,dto));
        }
//        throw new RuntimeException("Employee not found with phone number: " + dto.phoneno());
          throw new PatientNotFoundException("Patient not found" );
    }

    @Override
    public void deleteById(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<String> findPatientIllness(long id) {
        Optional<Patient> patient1 = patientRepository.findById(id);
        if(patient1.isPresent()){
            Patient patient = patient1.get();
            List<String> illness = patient.getPreExistingIllnesses().stream()
                    .map(PreExistingIllness::getIllness)
                    .collect(Collectors.toList());
            return illness;

        }
        throw new RuntimeException("Patient not found with id: " + id);

    }

    @Override
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            Patient patient1 = patient.get();
            return patient1;
        }
        throw new RuntimeException("Patient not found with id: " + id);
    }

}
