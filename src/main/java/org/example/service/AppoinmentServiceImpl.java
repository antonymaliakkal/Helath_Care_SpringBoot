package org.example.service;

import org.example.dto.PatientDto;
import org.example.feign_clients.PatientClient;
import org.springframework.beans.factory.annotation.Autowired;

public class AppoinmentServiceImpl implements AppointmentService {

    @Autowired
    PatientClient patientClient;

    @Override
    public PatientDto getPatientById(String id) {
        PatientDto patientDto = patientClient.getPatientById(Long.parseLong(id));

        System.out.println(patientDto.name());

        return patientDto;
    }
}
