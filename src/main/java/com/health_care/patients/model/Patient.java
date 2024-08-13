package com.health_care.patients.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "100_sequence")
    @SequenceGenerator(name = "100_sequence",initialValue = 100,allocationSize = 1)
    private long id;
    private String name;
    private String phoneno;
    private String email;
    private String address;
    private LocalDate dob;
    private String illness;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PreExistingIllness> preExistingIllnesses = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDate createdAt;

    @LastModifiedBy
    private LocalDate updatedAt;


}
