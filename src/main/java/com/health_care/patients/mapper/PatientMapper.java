package com.health_care.patients.mapper;

import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.model.Patient;
import com.health_care.patients.model.PreExistingIllness;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PatientMapper {

    public Patient toEntity(PatientDto dto){
        Patient patient = new Patient();
        patient.setName(dto.fullname());
        patient.setEmail(dto.email());
        patient.setPhoneno(dto.phoneno());
        patient.setDob(dto.dob());
        patient.setAddress(dto.address());

        System.out.println(dto.s());

//        patient.setPreExistingIllnesses(dto.preExistingIllnesses().stream()
//                .map((PreExistingIllness illness) -> toIllnessEntity(String.valueOf(illness))).
//                collect(Collectors.toList()));

        patient.setPreExistingIllnesses(
                dto.preExistingIllnesses().stream()
                        .map(PreExistingIllness::new)  // Converts each string in the list to a PreExistingIllness entity
                        .collect(Collectors.toList())
        );


        return patient;

    }


    public PreExistingIllness toIllnessEntity(String illness) {
        PreExistingIllness preExistingIllness = new PreExistingIllness();
        preExistingIllness.setIllness(illness);
        System.out.println("preExistingIllness = " + illness);
        return preExistingIllness;
    }

}