package com.health_care.patients.repository;

import com.health_care.patients.model.PreExistingIllness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreExistingIllnessRepo extends JpaRepository<PreExistingIllness,Long> {

    public Optional<PreExistingIllness> findByIllness(String s);

}
