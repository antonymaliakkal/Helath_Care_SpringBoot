package org.example.service;

import org.example.dto.PatientDto;

public interface AppointmentService {

    PatientDto getPatientById(String id);

}
