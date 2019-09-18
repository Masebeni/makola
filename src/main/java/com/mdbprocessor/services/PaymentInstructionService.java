package com.mdbprocessor.services;

import com.mdbprocessor.persistence.PaymentInstruction;
import com.mdbprocessor.repository.PaymentInstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentInstructionService {

    @Autowired
    private PaymentInstructionRepository paymentInstructionRepository;

    public List<PaymentInstruction> getAllPaymentInstructions() {
        List<PaymentInstruction> paymentInstructions = new ArrayList<PaymentInstruction>();
        paymentInstructionRepository.findAll()
                .forEach(paymentInstruction -> paymentInstructions.add(paymentInstruction));
        return paymentInstructions;
    }

    public PaymentInstruction getPaymentInstructionById(int id) {
        return paymentInstructionRepository.findById(id).get();
    }

    public void saveOrUpdate(PaymentInstruction paymentInstruction) {
        paymentInstructionRepository.save(paymentInstruction);
    }

    public void delete(int id) {
        paymentInstructionRepository.deleteById(id);
    }
}
