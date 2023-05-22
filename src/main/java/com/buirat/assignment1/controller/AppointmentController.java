package com.buirat.assignment1.controller;
import com.buirat.assignment1.dto.AppointmentDto;
import com.buirat.assignment1.entity.Appointment;
import com.buirat.assignment1.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    private AppointmentDto convertToDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getPatient(),
                appointment.getDoctor()
        );
    }
    @GetMapping("/get-all-appointments")
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            AppointmentDto appointmentDto = convertToDto(appointment);
            appointmentDtos.add(appointmentDto);
        }
        return appointmentDtos;
    }
    @GetMapping("/get-appointment/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable("id") Integer id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        return appointmentOptional.map(appointment -> ResponseEntity.ok(convertToDto(appointment)))
                .orElse(ResponseEntity.notFound().build());
    }

}
