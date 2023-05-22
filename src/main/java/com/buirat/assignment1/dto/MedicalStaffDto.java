package com.buirat.assignment1.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalStaffDto{
    private Integer id;
    private String name;
    private String gender;
    private String speciality;
    private String department;
}