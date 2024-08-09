package com.health_care.patients.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PatientDto(
    long id,

    @NotEmpty(message = "Name is required")
    String fullname,

    @NotEmpty(message = "Email is required")
    @Email(message = "Email is required")
    String email,

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",message = "Phone number is invalid")
    String phoneno,

    @NotEmpty(message = "Address is required")
    String address,

    @NotNull(message = "DOB is required")
    @Past(message = "Date Of birth must be past")
    LocalDate dob
){

}