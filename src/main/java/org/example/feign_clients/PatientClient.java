package org.example.feign_clients;


import org.example.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="patient-service" , url = "http://localhost:8100/patients")
public interface PatientClient {

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable long id);

}
