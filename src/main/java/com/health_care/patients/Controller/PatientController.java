package com.health_care.patients.Controller;


import com.health_care.patients.dto.PatientDto;
import com.health_care.patients.model.Patient;
import com.health_care.patients.service.PatientServiceImpl;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientServiceImpl patientServiceImpl;


    // Create Patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientDto dto){
        Patient patient = patientServiceImpl.createPatient(dto);
        return ResponseEntity.ok(patient);
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

    @GetMapping("/ill/{id}")
    public ResponseEntity<List<String>> getPatientIllness(@PathVariable Long id){
        List<String> illness = patientServiceImpl.findPatientIllness(id);
        return ResponseEntity.ok(illness);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
        return ResponseEntity.ok(patientServiceImpl.getPatientById(id));
    }


}
