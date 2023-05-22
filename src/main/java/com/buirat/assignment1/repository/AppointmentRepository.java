package com.buirat.assignment1.repository;
import com.buirat.assignment1.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
