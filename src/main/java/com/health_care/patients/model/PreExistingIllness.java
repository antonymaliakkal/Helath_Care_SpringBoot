package com.health_care.patients.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Pre-Existing")
public class PreExistingIllness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long illness_id;

    String illness;

    public PreExistingIllness(PreExistingIllness preExistingIllness) {
        this.illness = preExistingIllness.getIllness();
    }

    public PreExistingIllness(String illness){
        this.illness = illness;
    }
}
