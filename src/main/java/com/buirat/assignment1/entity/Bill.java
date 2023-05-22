package com.buirat.assignment1.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Entity
@Table(name = "bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill implements Serializable {
    @Id
    private Integer id;
    @Column(name = "charge_amount")
    private BigDecimal chargeAmount;
    private String service;
    private BigDecimal discount;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "insurance_details", length = 100)
    private String insuranceDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
}