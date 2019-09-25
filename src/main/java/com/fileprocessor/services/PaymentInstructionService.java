package com.fileprocessor.services;

import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;

@Service
public class PaymentInstructionService {
    private static final Logger log = LoggerFactory.getLogger(PaymentInstructionService.class);

    @Autowired
    private PaymentInstructionRepository paymentInstructionRepository;

    @Autowired
    private UtilityService utilityService;

    public void processPaymentInstruction(final String xml) throws JAXBException, XMLStreamException {
        Document pain001 = utilityService.unmarshal(xml);

        PaymentInstruction paymentInstruction = new PaymentInstruction();
        paymentInstruction.setMessageId(pain001.getCstmrCdtTrfInitn().getGrpHdr().getMsgId());
        paymentInstruction.setCreDtTm(pain001.getCstmrCdtTrfInitn().getGrpHdr().getCreDtTm());
        paymentInstruction.setCtrlSum(pain001.getCstmrCdtTrfInitn().getGrpHdr().getCtrlSum());
        paymentInstruction.setPmtInfId(pain001.getCstmrCdtTrfInitn().getPmtInves().get(0).getPmtInfId());
        paymentInstruction.setXml(xml);
        paymentInstructionRepository.save(paymentInstruction);
    }

    public void save(final PaymentInstruction paymentInstruction) {
        paymentInstructionRepository.save(paymentInstruction);
    }

    public Optional<PaymentInstruction> getPaymentInstructionById(final String id) throws Exception{
        Optional<PaymentInstruction> paymentInstruction = paymentInstructionRepository.findById(id);
        if (paymentInstruction.isPresent()) {
            return paymentInstructionRepository.findById(id);
        } else{
            log.debug("No id present " + id);
            return paymentInstruction;
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

}
