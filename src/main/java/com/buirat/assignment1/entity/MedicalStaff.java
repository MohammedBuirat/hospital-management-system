package com.buirat.assignment1.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "medical_staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalStaff implements Serializable {
    @Id
    private Integer id;
    private String name;
    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String gender;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "contact_number", length = 20)
    private String contactNumber;
    private String speciality;
    private String department;
}