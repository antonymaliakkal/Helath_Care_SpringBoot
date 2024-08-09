package com.health_care.patients.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name= "PATIENT" , uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phoneno")
      },
      indexes = {
        @Index(columnList = "email"),
        @Index(columnList = "phoneno")
      } )



public class Patient
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phoneno;
    private String email;
    private String address;
    private LocalDate dob;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDate createdAt;

    @LastModifiedBy
    private LocalDate updatedAt;
}
