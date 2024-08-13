package org.example.controller;


import org.example.domain.Appointment;
import org.example.dto.AppointmentDto;
import org.example.dto.PatientDto;
import org.example.service.AppoinmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppoinmentServiceImpl appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> createAppointment(@PathVariable String id){

        PatientDto patient = appointmentService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

}
