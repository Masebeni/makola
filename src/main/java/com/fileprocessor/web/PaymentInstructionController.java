package com.fileprocessor.web;

import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.services.PaymentInstructionService;
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
    private PaymentInstruction getPaymentInstruction(@PathVariable("id") int id) throws Exception{
        return paymentInstructionService.getPaymentInstructionById(id);
    }

    @DeleteMapping("/files/{id}")
    private void deletePaymentInstruction(@PathVariable("id") int id) {
        paymentInstructionService.deletePaymentInstructionById(id);
    }

    @PostMapping("/files")
    private int savePaymentInstruction(@RequestBody PaymentInstruction paymentInstruction) {
        paymentInstructionService.save(paymentInstruction);
        return paymentInstruction.getId();
    }

    @PostMapping("/files/xml")
    private void processPaymentInstruction(@RequestBody String xml) {
        paymentInstructionService.processPaymentInstruction(xml);
    }
}