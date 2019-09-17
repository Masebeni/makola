package com.mdbprocessor.services;

import com.mdbprocessor.persistence.PaymentInstruction;
import com.mdbprocessor.repository.PaymentInstructionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PaymentInstructionService {

    private PaymentInstructionRepository paymentInstructionRepository;

    @Autowired
    public PaymentInstructionService(final PaymentInstructionRepository paymentInstructionRepository) {
        this.paymentInstructionRepository = paymentInstructionRepository;
    }

    public PaymentInstruction findFileById(final long id) {
        System.out.println("------------ID:"+id);
        PaymentInstruction paymentInstruction = paymentInstructionRepository.findFileById(id);
        return paymentInstruction;
    }
}
