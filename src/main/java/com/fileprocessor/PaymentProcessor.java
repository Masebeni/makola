package com.fileprocessor;

import com.fileprocessor.persistence.PaymentInstruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

@SpringBootApplication
public class PaymentProcessor {
    private static final Logger log = LoggerFactory.getLogger(PaymentProcessor.class);
    public static void main(String[] args) throws Exception{
        //SpringApplication.run(PaymentProcessor.class, args);
        marshaling();
        unMarshaling();
    }

    private static void unMarshaling() throws JAXBException {
        try {
            log.debug("\n\n======== Start marshalling ========");
            File file = new File("c:/temp/pain001.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInstruction.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PaymentInstruction paymentInstruction = (PaymentInstruction) jaxbUnmarshaller.unmarshal(file);

            log.debug("\n\n======== Done unmarshalling ========");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void marshaling() throws JAXBException {
        try {
            PaymentInstruction paymentInstruction = new PaymentInstruction();

            log.debug("\n\n======== Start marshalling ========");
            File file = new File("c:/temp/pain001.xml");
            JAXBContext contextObj = JAXBContext.newInstance(PaymentInstruction.class);
            log.debug(contextObj.toString());
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(paymentInstruction, new File("myPain001.xml"));
            log.debug("\n\n======== Done nmarshalling ========");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}

