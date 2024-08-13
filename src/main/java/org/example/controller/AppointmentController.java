package org.example.controller;


import org.example.domain.Appointment;
import org.example.dto.AppointmentDto;
import org.example.dto.PatientDto;
import org.example.service.AppoinmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppoinmentServiceImpl appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDto dto){

        PatientDto patient = appointmentService.getPatientById(dto.patientId());

    }

}
