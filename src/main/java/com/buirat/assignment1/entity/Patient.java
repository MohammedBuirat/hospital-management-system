package com.buirat.assignment1.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {
    @Id
    private Integer id;
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String gender;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "contact_number", length = 20)
    private String contactNumber;
    private String diagnosis;
    private String room;
    @Column(name = "admission")
    private LocalDate admission;
    @Column(name = "medical_history", length = 200)
    private String medicalHistory;
    @Column(name = "discharge")
    private LocalDateTime discharge;
}