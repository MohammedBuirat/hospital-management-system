package com.buirat.assignment1.repository;
import com.buirat.assignment1.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}