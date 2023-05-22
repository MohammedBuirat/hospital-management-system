package com.buirat.assignment1.dto;
import com.buirat.assignment1.entity.MedicalStaff;
import com.buirat.assignment1.entity.Patient;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Integer appointmentId;
    private Patient patient;
    private MedicalStaff doctor;
}