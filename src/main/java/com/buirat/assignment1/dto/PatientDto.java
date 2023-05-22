package com.buirat.assignment1.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Integer id;
    private String name;
    private String gender;
    private String room;
}