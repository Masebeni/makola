package com.fileprocessor.services;

import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentInstructionServiceTests {

    @Autowired
    PaymentInstructionService paymentInstructionService;
    @Autowired
    PaymentInstructionRepository paymentInstructionRepository;

    @Test
    public void testSaveOrUpdatePayment() throws Exception {
        PaymentInstruction paymentInstruction = new PaymentInstruction();
        paymentInstruction.setId(1);
        paymentInstruction.setMessageId("Poovan");
        paymentInstruction.setXml("xml");
        paymentInstructionService.save(paymentInstruction);
        System.out.println("\n\n=====> paymentInstruction: " + paymentInstruction);
        Assert.assertNotEquals(null, paymentInstruction);
    }

    @Test
    public void testGetPaymentInstructionByMessageId() throws Exception {
        PaymentInstruction paymentInstruction = new PaymentInstruction();
        paymentInstruction.setId(1);
        paymentInstruction.setMessageId("Poovan");
        paymentInstruction.setXml("xml");
        paymentInstructionService.save(paymentInstruction);
         paymentInstructionRepository.findById("Poovan");
        System.out.println("\n\n======>getMessageId: "+paymentInstruction.getMessageId());
        Assert.assertEquals("Poovan",paymentInstruction.getMessageId());
    }

    @Test
    public void testGetAllPaymentInstructions() throws Exception {
        PaymentInstruction paymentInstruction = new PaymentInstruction();
        paymentInstruction.setId(1);
        paymentInstruction.setMessageId("Poovan");
        paymentInstruction.setXml("xml");
        paymentInstructionService.save(paymentInstruction);

        paymentInstruction = new PaymentInstruction();
        paymentInstruction.setId(2);
        paymentInstruction.setMessageId("Liza");
        paymentInstruction.setXml("xml");
        paymentInstructionService.save(paymentInstruction);

        paymentInstruction = new PaymentInstruction();
        paymentInstruction.setId(3);
        paymentInstruction.setMessageId("Xolela");
        paymentInstruction.setXml("xml");
        paymentInstructionService.save(paymentInstruction);

        System.out.println("\n\n======>getAllPaymentInstructions: "+paymentInstructionService.getAllPaymentInstructions());
        Assert.assertEquals(true,paymentInstructionService.getAllPaymentInstructions().containsAll(paymentInstructionService.getAllPaymentInstructions()));

    }

    @Test
    public void testDeletePaymentInstructionById() throws Exception {
        PaymentInstruction paymentInstruction = new PaymentInstruction();
        paymentInstruction.setId(1);
        paymentInstruction.setMessageId("Poovan");
        paymentInstruction.setXml("xml");
        paymentInstructionService.save(paymentInstruction);
        paymentInstructionRepository.delete(paymentInstructionService.getPaymentInstructionById("Poovan"));
        System.out.println("\n\n======>PaymentInstructionById: "+paymentInstructionService.getPaymentInstructionById("Poovan"));
        Assert.assertEquals(null, paymentInstructionService.getPaymentInstructionById("Poovan"));
    }

}
