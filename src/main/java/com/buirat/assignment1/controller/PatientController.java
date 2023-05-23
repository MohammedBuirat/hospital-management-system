package com.buirat.assignment1.controller;
import com.buirat.assignment1.dto.PatientDto;
import com.buirat.assignment1.entity.Patient;
import com.buirat.assignment1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    public PatientDto patientToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setGender(patient.getGender());
        patientDto.setRoom(patient.getRoom());
        return patientDto;
    }
    @GetMapping("/get-all-patients")
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtos = new ArrayList<>();
        for (Patient patient : patients) {
            PatientDto patientDto = patientToDto(patient);
            patientDtos.add(patientDto);
        }
        return patientDtos;
    }
    @GetMapping("/get-patient/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable("id") Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            PatientDto patientDto = patientToDto(patient);
            return ResponseEntity.ok(patientDto);
        } else {
            return ResponseEntity.badRequest().body("No Patient is with the given id");
        }
    }
    @DeleteMapping("/remove-patient/{id}")
    public boolean deletePatient(@PathVariable("id") Integer id) {
        if (!patientRepository.findById(id).equals(Optional.empty())) {
            patientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    @PutMapping("/update-patient/{id}")
    public PatientDto updatePatient(@PathVariable("id") Integer id,
                                    @RequestBody Map<String, String> body) {
        Patient current = patientRepository.findById(id).get();
        if(body.containsKey("gender")){
            current.setGender(body.get("gender"));
        }
        if(body.containsKey("name")){
            current.setName(body.get("name"));
        }
        if(body.containsKey("room")){
            current.setRoom(body.get("room"));
        }
        patientRepository.save(current);
        return patientToDto(current);
    }
    @PostMapping("/add-patient")
    public PatientDto addPatient(@RequestBody Map<String, String> body) {
        if (body.isEmpty()||!body.containsKey("id")) {
            return null;
        }
        Patient patient = new Patient();
        patient.setId(Integer.valueOf(body.get("id")));
        if (body.containsKey("name")) {
            patient.setName(body.get("name"));
        }

        if (body.containsKey("dateOfBirth")) {
            String dateOfBirthStr = body.get("dateOfBirth");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
            patient.setDateOfBirth(dateOfBirth);
        }

        if (body.containsKey("gender")) {
            patient.setGender(body.get("gender"));
        }

        if (body.containsKey("address")) {
            patient.setAddress(body.get("address"));
        }

        if (body.containsKey("contactNumber")) {
            patient.setContactNumber(body.get("contactNumber"));
        }

        if (body.containsKey("diagnosis")) {
            patient.setDiagnosis(body.get("diagnosis"));
        }

        if (body.containsKey("room")) {
            patient.setRoom(body.get("room"));
        }

        if (body.containsKey("admission")) {
            String admissionStr = body.get("admission");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate admission = LocalDate.parse(admissionStr, formatter);
            patient.setAdmission(admission);
        }

        if (body.containsKey("medicalHistory")) {
            patient.setMedicalHistory(body.get("medicalHistory"));
        }

        if (body.containsKey("discharge")) {
            String dischargeStr = body.get("discharge");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime discharge = LocalDateTime.parse(dischargeStr, formatter);
            patient.setDischarge(discharge);
        }
        patientRepository.save(patient);
        return patientToDto(patient);
    }
}