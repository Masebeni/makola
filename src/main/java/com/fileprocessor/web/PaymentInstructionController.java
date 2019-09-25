package com.fileprocessor.web;

import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.services.PaymentInstructionService;
import com.fileprocessor.services.UtilityService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class PaymentInstructionController {
    private static final Logger log = LoggerFactory.getLogger(PaymentInstructionController.class);


    @Autowired
    PaymentInstructionService paymentInstructionService;

    @GetMapping("/files")
    private List<PaymentInstruction> getAllPaymentInstructions() {
        return paymentInstructionService.getAllPaymentInstructions();
    }

    @GetMapping("/files/{id}")
    private Optional<PaymentInstruction> getPaymentInstruction(@PathVariable("id") String id) throws Exception{
        log.debug("----->PaymentInstruction: Id" + id);
        return paymentInstructionService.getPaymentInstructionById(id);
    }

    @DeleteMapping("/files/{id}")
    private ResponseEntity deletePaymentInstruction(@PathVariable("id") String id) {
        paymentInstructionService.deletePaymentInstructionById(id);
        log.debug("----->Deleted paymentInstruction: Id" + id);
        return  new ResponseEntity(HttpStatus.GONE);
    }

    @PostMapping("/files")
    private ResponseEntity savePaymentInstruction(@RequestBody PaymentInstruction paymentInstruction) {
        paymentInstructionService.save(paymentInstruction);
        log.debug("----->Saved paymentInstruction message id: " + paymentInstruction.getMessageId());
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/files/xml")
    private ResponseEntity processPaymentInstruction(@RequestBody String xml) throws JAXBException, XMLStreamException {
        paymentInstructionService.processPaymentInstruction(xml);
        log.debug("----->PaymentInstruction processed");
        return  new ResponseEntity(HttpStatus.CREATED);

    }
}