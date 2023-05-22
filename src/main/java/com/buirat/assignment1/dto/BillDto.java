package com.buirat.assignment1.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    private Integer id;
    private String service;
    private String paymentMethod;
    private String insuranceDetails;
}