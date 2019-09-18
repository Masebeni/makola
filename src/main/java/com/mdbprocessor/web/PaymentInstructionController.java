package com.mdbprocessor.web;

import com.mdbprocessor.persistence.PaymentInstruction;
import com.mdbprocessor.services.PaymentInstructionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class PaymentInstructionController {

    @Autowired
    PaymentInstructionService paymentInstructionService;

    @GetMapping("/files")
    private List<PaymentInstruction> getAllPaymentInstructions() {
        return paymentInstructionService.getAllPaymentInstructions();
    }

    @GetMapping("/files/{id}")
    private PaymentInstruction getPaymentInstruction(@PathVariable("id") int id) {
        return paymentInstructionService.getPaymentInstructionById(id);
    }

    @DeleteMapping("/files/{id}")
    private void deletePaymentInstruction(@PathVariable("id") int id) {
        paymentInstructionService.deletePaymentInstructionById(id);
    }

    @PostMapping("/files")
    private int savePaymentInstruction(@RequestBody PaymentInstruction paymentInstruction) {
        paymentInstructionService.saveOrUpdatePaymentInstruction(paymentInstruction);
        return paymentInstruction.getId();
    }
}