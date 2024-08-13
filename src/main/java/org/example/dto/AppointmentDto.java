package org.example.dto;

public record AppointmentDto(

        String id,

        String appointmentDate,

        String appointmentTime,

        String patientId,

        String patientName,

        String patientNumber,

        String doctorId,

        String doctorName,

        String status

){}
