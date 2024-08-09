package com.health_care.patients.Controller;


import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.model.Patient;
import com.health_care.patients.service.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientServiceImpl patientServiceImpl;


    // Create Patient
    @PostMapping
    public ResponseEntity<String> createPatient(@Valid @RequestBody PatientDto dto){
        patientServiceImpl.createPatient(dto);
        return ResponseEntity.ok("User Created");
    }


    //Get patient by name
    @GetMapping("/{phoneno}")
    public ResponseEntity<Optional<Patient>> getPatient(@PathVariable String phoneno){
        Optional<Patient> patient = patientServiceImpl.getPatient(phoneno);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        patientServiceImpl.deleteById(id);
        return ResponseEntity.ok("Deleted User");
    }

    @PutMapping
    public  ResponseEntity<Patient> updatePatient(@RequestBody PatientDto dto){
        Patient patient =  patientServiceImpl.updatePatientByPhoneNo(dto);
        return ResponseEntity.ok(patient);
    }


}
