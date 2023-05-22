package com.buirat.assignment1.repository;
import com.buirat.assignment1.entity.MedicalStaff;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicalStaffRepository extends JpaRepository<MedicalStaff, Integer> {
}