package com.buirat.assignment1.controller;

import com.buirat.assignment1.dto.MedicalStaffDto;
import com.buirat.assignment1.entity.MedicalStaff;
import com.buirat.assignment1.repository.MedicalStaffRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MedicalStaffController {
    @Autowired
    private MedicalStaffRepository medicalStaffRepository;

    private MedicalStaffDto convertToDto(MedicalStaff medicalStaff) {
        return new MedicalStaffDto(
                medicalStaff.getId(),
                medicalStaff.getName(),
                medicalStaff.getGender(),
                medicalStaff.getSpeciality(),
                medicalStaff.getDepartment()
        );
    }

    @GetMapping("/get-all-medical-staff")
    public List<MedicalStaffDto> getAllMedicalStaff() {
        List<MedicalStaff> medicalStaffList = medicalStaffRepository.findAll();
        List<MedicalStaffDto> medicalStaffDtos = new ArrayList<>();
        for (MedicalStaff medicalStaff : medicalStaffList) {
            MedicalStaffDto medicalStaffDto = convertToDto(medicalStaff);
            medicalStaffDtos.add(medicalStaffDto);
        }
        return medicalStaffDtos;
    }

    @GetMapping("/get-medical-staff/{id}")
    public ResponseEntity<MedicalStaffDto> getMedicalStaffById(@PathVariable("id") Integer id) {
        Optional<MedicalStaff> medicalStaffOptional = medicalStaffRepository.findById(id);
        return medicalStaffOptional.map(medicalStaff -> ResponseEntity.ok(convertToDto(medicalStaff)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove-medical-staff/{id}")
    public boolean deleteMedicalStaff(@PathVariable("id") Integer id) {
        if (!medicalStaffRepository.findById(id).equals(Optional.empty())) {
            medicalStaffRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/update-medical-staff/{id}")
    public ResponseEntity<MedicalStaffDto> updateMedicalStaff(@PathVariable("id") Integer id,
                                                              @RequestBody Map<String, String> body) {
        Optional<MedicalStaff> medicalStaffOptional = medicalStaffRepository.findById(id);
        if (medicalStaffOptional.isPresent()) {
            MedicalStaff medicalStaff = medicalStaffOptional.get();
            if (body.containsKey("name")) {
                medicalStaff.setName(body.get("name"));
            }
            if (body.containsKey("gender")) {
                medicalStaff.setGender(body.get("gender"));
            }
            if (body.containsKey("speciality")) {
                medicalStaff.setSpeciality(body.get("speciality"));
            }
            if (body.containsKey("department")) {
                medicalStaff.setDepartment(body.get("department"));
            }
            medicalStaffRepository.save(medicalStaff);
            return ResponseEntity.ok(convertToDto(medicalStaff));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-medical-staff")
    public ResponseEntity<MedicalStaffDto> addMedicalStaff(
                                                              @RequestBody Map<String, String> body) {

        if (body.containsKey("id")) {
            MedicalStaff medicalStaff = new MedicalStaff();
            medicalStaff.setId(Integer.valueOf(body.get("id")));

            if (body.containsKey("name")) {
                medicalStaff.setName(body.get("name"));
            }

            if (body.containsKey("dateOfBirth")) {
                String dateOfBirthStr = body.get("dateOfBirth");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
                medicalStaff.setDateOfBirth(dateOfBirth);
            }

            if (body.containsKey("gender")) {
                medicalStaff.setGender(body.get("gender"));
            }

            if (body.containsKey("address")) {
                medicalStaff.setAddress(body.get("address"));
            }

            if (body.containsKey("contactNumber")) {
                medicalStaff.setContactNumber(body.get("contactNumber"));
            }

            if (body.containsKey("speciality")) {
                medicalStaff.setSpeciality(body.get("speciality"));
            }

            if (body.containsKey("department")) {
                medicalStaff.setDepartment(body.get("department"));
            }
            medicalStaffRepository.save(medicalStaff);
            return ResponseEntity.ok(convertToDto(medicalStaff));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}