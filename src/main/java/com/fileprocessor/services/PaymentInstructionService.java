package com.fileprocessor.services;

import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentInstructionService {

    @Autowired
    private PaymentInstructionRepository paymentInstructionRepository;

    public void saveOrUpdatePaymentInstruction(PaymentInstruction paymentInstruction) {
        paymentInstructionRepository.save(paymentInstruction);
    }

    public PaymentInstruction getPaymentInstructionById(int id) {
        return paymentInstructionRepository.findById(id).get();
    }

    public List<PaymentInstruction> getAllPaymentInstructions() {
        List<PaymentInstruction> paymentInstructions = new ArrayList<PaymentInstruction>();
        paymentInstructionRepository.findAll()
                .forEach(paymentInstruction -> paymentInstructions.add(paymentInstruction));
        return paymentInstructions;
    }

    public void deletePaymentInstructionById(int id) {
        paymentInstructionRepository.deleteById(id);
    }
}
