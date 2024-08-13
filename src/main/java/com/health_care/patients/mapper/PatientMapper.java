package com.health_care.patients.mapper;

import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.model.Patient;
import com.health_care.patients.model.PreExistingIllness;
import com.health_care.patients.repository.PreExistingIllnessRepo;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;




@Component
public class PatientMapper {

    @Autowired
    PreExistingIllnessRepo preExistingIllnessRepo;

    public Patient toEntity(PatientDto dto){
        Patient patient = new Patient();
        patient.setName(dto.fullname());
        patient.setEmail(dto.email());
        patient.setPhoneno(dto.phoneno());
        patient.setDob(dto.dob());
        patient.setAddress(dto.address());
        patient.setIllness(dto.illness());

        //Mapping list of illness to the preExistingIllness
        patient.setPreExistingIllnesses(
                dto.preExistingIllnesses().stream()
                        .map(illness -> toIllnessEntity(illness))
                        .collect(Collectors.toList())
        );

        return patient;

    }


    public PreExistingIllness toIllnessEntity(String illness) {

//        Optional<PreExistingIllness> existingIllness = preExistingIllnessRepo.findByIllness(illness);
//        System.out.println(existingIllness);
//        if(existingIllness.isPresent()){
//            return existingIllness.get();
//        }

        PreExistingIllness newIllness = new PreExistingIllness();
        newIllness.setIllness(illness);
        return newIllness;

    }

}