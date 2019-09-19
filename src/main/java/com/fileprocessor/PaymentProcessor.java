package com.fileprocessor;

import com.fileprocessor.persistence.PaymentInstruction;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.Doc;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

@SpringBootApplication
public class PaymentProcessor {
    private static final Logger log = LoggerFactory.getLogger(PaymentProcessor.class);
    public static void main(String[] args) throws Exception{
      //  SpringApplication.run(PaymentProcessor.class, args);
        marshaling();
        unMarshaling();
    }

    private static void marshaling() throws JAXBException, XMLStreamException {
        try {
            PaymentInstruction  paymentInstruction = new PaymentInstruction();

            log.debug("\n\n======== Start marshalling ========");
            JAXBContext jContext = JAXBContext.newInstance(PaymentInstruction.class);
            Unmarshaller unmarshaller = jContext.createUnmarshaller();
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader("xmlString"));
            Document pain001 = (Document) unmarshaller.unmarshal(reader);

            paymentInstruction.setId(101);
            paymentInstruction.setMessageId( pain001.getCstmrCdtTrfInitn().getGrpHdr().getMsgId());
            paymentInstruction.setXml("passed");

         //   marshallObj.marshal(paymentInstruction, new FileOutputStream("c:/temp/pain001.xml"));

            log.debug("\n\n======== Done marshalling ========");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void unMarshaling() throws JAXBException {
        try {
            log.debug("\n\n======== Start marshalling ========");
            File file = new File("c:/temp/pain001.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInstruction.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PaymentInstruction paymentInstruction = (PaymentInstruction) jaxbUnmarshaller.unmarshal(file);

            PaymentInstruction paymentInstruction1 = (PaymentInstruction) jaxbUnmarshaller.unmarshal(file);
            System.out.println(paymentInstruction1);

            log.debug("\n\n======== Done unmarshalling ========");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}

