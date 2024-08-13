package org.example.repository;

import org.example.domain.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<Appointment,String> {
}
