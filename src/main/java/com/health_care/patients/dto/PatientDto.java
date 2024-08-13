package com.health_care.patients.dto;

import com.health_care.patients.model.PreExistingIllness;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record PatientDto(
    long id,

    @NotEmpty(message = "Name is required")
    String fullname,

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9]+.[a-zA-Z]{2,}$" , message = "Email number is invalid")
    String email,

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$",message = "Phone number is invalid")
    String phoneno,

    @NotEmpty(message = "Address is required")
    String address,

    @NotNull(message = "DOB is required")
    @Past(message = "Date Of birth must be past")

    LocalDate dob,

    @NotNull(message = "illness should not be empty")
    String illness,

    List<String> preExistingIllnesses


){}