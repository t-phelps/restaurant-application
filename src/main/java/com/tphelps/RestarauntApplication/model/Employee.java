package com.tphelps.RestarauntApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // includes getters, setters, equals, hashcode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private String jobTitle;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
}
