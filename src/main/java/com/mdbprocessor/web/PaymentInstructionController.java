package com.mdbprocessor.web;

import com.mdbprocessor.persistence.PaymentInstruction;
import com.mdbprocessor.services.PaymentInstructionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class PaymentInstructionController {

    @Autowired
    private  PaymentInstructionService paymentInstructionService;

    @RequestMapping(value = "get/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<PaymentInstruction> getFile(@PathVariable(value = "id") long id) {
        System.out.println("X said Im in here, Poovan said no");
        PaymentInstruction paymentInstruction = paymentInstructionService.findFileById(id);
        if(paymentInstruction == null){
            return new ResponseEntity<PaymentInstruction>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PaymentInstruction>(paymentInstruction,HttpStatus.OK);
    }



}

