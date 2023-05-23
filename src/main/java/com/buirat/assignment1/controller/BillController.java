package com.buirat.assignment1.controller;
import com.buirat.assignment1.dto.BillDto;
import com.buirat.assignment1.entity.Bill;
import com.buirat.assignment1.entity.Patient;
import com.buirat.assignment1.repository.BillRepository;
import com.buirat.assignment1.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
public class BillController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private PatientRepository patientRepository;
    private BillDto convertToDto(Bill bill) {
        return new BillDto(
                bill.getId(),
                bill.getService(),
                bill.getPaymentMethod(),
                bill.getInsuranceDetails()
        );
    }
    @GetMapping("/get-all-bills")
    public List<BillDto> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        List<BillDto> billDtos = new ArrayList<>();
        for (Bill bill : bills) {
            BillDto billDto = convertToDto(bill);
            billDtos.add(billDto);
        }
        return billDtos;
    }
    @GetMapping("/get-bill/{id}")
    public ResponseEntity<BillDto> getBillById(@PathVariable("id") Integer id) {
        Optional<Bill> billOptional = billRepository.findById(id);
        return billOptional.map(bill -> ResponseEntity.ok(convertToDto(bill)))
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/remove-bill/{id}")
    public boolean deleteBill(@PathVariable("id") Integer id) {
        if (!billRepository.findById(id).equals(Optional.empty())) {
            billRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    @PutMapping("/update-bill/{id}")
    public ResponseEntity<BillDto> updateBill(@PathVariable("id") Integer id, @RequestBody Map<String, String> body) {
        Optional<Bill> billOptional = billRepository.findById(id);
        if (billOptional.isPresent()) {
            Bill bill = billOptional.get();
            if(body.containsKey("service")){
                bill.setService(body.get("service"));
            }
            if(body.containsKey("paymentMethod")){
                bill.setPaymentMethod(body.get("paymentMethod"));
            }
            if(body.containsKey("insuranceDetails")){
                bill.setInsuranceDetails(body.get("insuranceDetails"));
            }
            billRepository.save(bill);
            return ResponseEntity.ok(convertToDto(bill));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add-bill")
    public ResponseEntity<?> addBill(@RequestBody Map<String, String> body) {
        if (body.isEmpty() || !body.containsKey("id")) {
            return ResponseEntity.badRequest().body("No 'id' provided in the request body.");
        }
        Bill bill = new Bill();
        bill.setId(Integer.valueOf(body.get("id")));
        if (body.containsKey("chargeAmount")) {
            bill.setChargeAmount(new BigDecimal(body.get("chargeAmount")));
        }
        if (body.containsKey("service")) {
            bill.setService(body.get("service"));
        }
        if (body.containsKey("discount")) {
            bill.setDiscount(new BigDecimal(body.get("discount")));
        }
        if (body.containsKey("paymentMethod")) {
            bill.setPaymentMethod(body.get("paymentMethod"));
        }
        if (body.containsKey("insuranceDetails")) {
            bill.setInsuranceDetails(body.get("insuranceDetails"));
        }
        if (body.containsKey("patient")) {
            Integer patientId = Integer.valueOf(body.get("patient"));
            Optional<Patient> patientOptional = patientRepository.findById(patientId);
            if(patientOptional.isEmpty()){
                return ResponseEntity.badRequest().body("No patient object found for the provided ID.");

            }
            Patient patient=patientOptional.get();
            bill.setPatient(patient);
        }

        billRepository.save(bill);
        return ResponseEntity.ok(convertToDto(bill));
    }
}