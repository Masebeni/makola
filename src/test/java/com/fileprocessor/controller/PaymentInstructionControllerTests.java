package com.fileprocessor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fileprocessor.PaymentProcessor;
import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import com.fileprocessor.services.PaymentInstructionService;
import com.fileprocessor.web.PaymentInstructionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PaymentInstructionController.class)
@WebAppConfiguration
public class PaymentInstructionControllerTests {
    private static final Logger log = LoggerFactory.getLogger(PaymentProcessor.class);

    private MockMvc mockMvc;

    @Autowired
    private PaymentInstructionService paymentInstructionService;

    @MockBean
    private PaymentInstructionRepository paymentInstructionRepository;

    @Test
    public void testGetPaymentInstructionById() throws Exception {
    }

}
