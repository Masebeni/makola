package com.fileprocessor.services;

import com.fileprocessor.PaymentProcessor;
import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class UtilityService {
    private static final Logger log = LoggerFactory.getLogger(UtilityService.class);


    private PaymentInstructionRepository paymentInstructionRepository;

    @Autowired
    public UtilityService(PaymentInstructionRepository paymentInstructionRepository) {
        this.paymentInstructionRepository = paymentInstructionRepository;
    }

    public Document unmarshal(final String xml)throws JAXBException, XMLStreamException {
        JAXBContext jaxbContext = JAXBContext.newInstance(iso.std.iso._20022.tech.xsd.pain_001_001.Document.class);
        log.debug("\n\n======== Start unmarshalling ========");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(xml));
        System.out.println("\n\n======== Start unmarshalling ========");
        Document pain001 = (Document) unmarshaller.unmarshal(reader);
        System.out.println(pain001.getCstmrCdtTrfInitn().getGrpHdr().getMsgId());
        System.out.println(pain001.getCstmrCdtTrfInitn().getGrpHdr().getCreDtTm());
        //System.out.println(pain001.getCstmrCdtTrfInitn().getGrpHdr().getAuthstn());
        log.debug("\n\n----> pain001: pain001:" + pain001);

        return  pain001;
    }

  /*  public String marshal(final Document pain001) throws JAXBException{
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(pain001, stringWriter);
        return stringWriter.toString();
    }*/

}
