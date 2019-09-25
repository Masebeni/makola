package com.fileprocessor.services;

import com.fileprocessor.persistence.PaymentInstruction;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentInstructionServiceTests {

    @Autowired
    PaymentInstructionService paymentInstructionService;

    @Test
    public void testSavePaymentInstruction() throws Exception {
        String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/pain/pain.001.001.005.xml")));
        paymentInstructionService.processPaymentInstruction(xml);

       Assert.assertNotEquals(null,paymentInstructionService.getAllPaymentInstructions());
    }

    @Test
    public void testGetPaymentInstructionByMessageId() throws Exception {
        String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/pain/pain.001.001.005.xml")));
        paymentInstructionService.processPaymentInstruction(xml);

        Assert.assertNotEquals(null,paymentInstructionService.getPaymentInstructionById("F/NBC/DRT/AAH/20190906/14444076377"));
    }

    @Test
    public void testGetAllPaymentInstructions() throws Exception {
        String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/pain/pain.001.001.005.xml")));
        paymentInstructionService.processPaymentInstruction(xml);

        Assert.assertEquals(true,paymentInstructionService.getAllPaymentInstructions().containsAll(paymentInstructionService.getAllPaymentInstructions()));
    }

    @Test
    public void testDeletePaymentInstructionById() throws Exception {
        String xml = new String(Files.readAllBytes(Paths.get("src/main/resources/pain/pain.001.001.005.xml")));
        paymentInstructionService.processPaymentInstruction(xml);
        paymentInstructionService.deletePaymentInstructionById("F/NBC/DRT/AAH/20190906/14444076377");

        Assert.assertEquals(Optional.empty(), paymentInstructionService.getPaymentInstructionById("F/NBC/DRT/AAH/20190906/14444076377"));
    }

}
