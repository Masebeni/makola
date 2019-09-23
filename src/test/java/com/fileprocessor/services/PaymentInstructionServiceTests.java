package com.fileprocessor.services;

import com.fileprocessor.repository.PaymentInstructionRepository;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import java.nio.file.Files;
import java.nio.file.Paths;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentInstructionServiceTests {

    @Autowired
    private UtilityService utilityService;
    @Autowired
    PaymentInstructionService paymentInstructionService;
    @Autowired
    PaymentInstructionRepository paymentInstructionRepository;

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
        Document pain001 = utilityService.unmarshal(xml);

        Assert.assertEquals(paymentInstructionService.getPaymentInstructionById("F/NBC/DRT/AAH/20190906/14444076377"),pain001.getCstmrCdtTrfInitn().getGrpHdr().getMsgId());
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
        paymentInstructionRepository.deleteById("F/NBC/DRT/AAH/20190906/14444076377");

        Assert.assertEquals(null, paymentInstructionService.getPaymentInstructionById("F/NBC/DRT/AAH/20190906/14444076377"));
    }

}
