package com.fileprocessor.services;

import com.fileprocessor.PaymentProcessor;
import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentInstructionService {

    @Autowired
    private PaymentInstructionRepository paymentInstructionRepository;

    @Autowired
    private UtilityService utilityService;

    public void save(final PaymentInstruction paymentInstruction) {
        paymentInstructionRepository.save(paymentInstruction);
    }

    public PaymentInstruction getPaymentInstructionById(final String id) throws Exception{
        Optional<PaymentInstruction> paymentInstruction = paymentInstructionRepository.findById(id);
        if (paymentInstruction.isPresent()) {
            return paymentInstructionRepository.findById(id).get();
        } else {
            System.out.println("No id present " + id);
            return null;
        }
    }

    public List<PaymentInstruction> getAllPaymentInstructions() {
        List<PaymentInstruction> paymentInstructions = new ArrayList<PaymentInstruction>();
        paymentInstructionRepository.findAll()
                .forEach(paymentInstruction -> paymentInstructions.add(paymentInstruction));
        return paymentInstructions;
    }

    public void deletePaymentInstructionById(final String id) {
        paymentInstructionRepository.deleteById(id);
    }

    public void processPaymentInstruction(final String xml) throws JAXBException, XMLStreamException {
        Document pain001 = utilityService.unmarshal(xml);
    }
}
