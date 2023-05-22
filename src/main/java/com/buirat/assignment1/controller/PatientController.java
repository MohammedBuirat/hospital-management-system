package com.buirat.assignment1.controller;
import com.buirat.assignment1.dto.PatientDto;
import com.buirat.assignment1.entity.Patient;
import com.buirat.assignment1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            PatientDto patientDto = patientToDto(patient);
            return ResponseEntity.ok(patientDto);
        } else {
            return ResponseEntity.notFound().build();
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
    @PostMapping("/add")
    public PatientDto addPatient(@RequestBody Map<String, String> body) {
        if (body.isEmpty()||!body.containsKey("id")) {
            return null;
        }
        Patient patient = new Patient();
        patient.setId(Integer.valueOf(body.get("id")));
        if(body.containsKey("gender")){
            patient.setGender(body.get("gender"));
        }
        if(body.containsKey("name")){
            patient.setName(body.get("name"));
        }
        if(body.containsKey("room")){
            patient.setRoom(body.get("room"));
        }
        patientRepository.save(patient);
        return patientToDto(patient);
    }
}