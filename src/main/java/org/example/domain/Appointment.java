package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    private String id;

    @Field("appointment_date")
    private String appointmentDate;

    @Field("appointment_time")
    private String appointmentTime;

    @Field("patient_id")
    private  long patientId;

    @Field("patient_number")
    private String patientNumber;

    @Field("patient_name")
    private String patientName;

    @Field("doctor_id")
    private String doctorId;

    @Field("doctor_name")
    private String doctorName;

    private String status;

}
