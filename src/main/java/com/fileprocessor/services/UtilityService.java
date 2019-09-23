package com.fileprocessor.services;

import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

@Service
public class UtilityService {
    private static final Logger log = LoggerFactory.getLogger(UtilityService.class);


    private JAXBContext pain001Context;


    public Document unmarshal(final String xml)throws JAXBException, XMLStreamException {
        pain001Context = JAXBContext.newInstance(iso.std.iso._20022.tech.xsd.pain_001_001.Document.class);
        Unmarshaller unmarshaller = pain001Context.createUnmarshaller();
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(xml));
        Document pain001 = (Document) unmarshaller.unmarshal(reader);

        return  pain001;
    }

    public String marshal(final Document pain001) throws JAXBException{
        pain001Context = JAXBContext.newInstance(iso.std.iso._20022.tech.xsd.pain_001_001.Document.class);
        Marshaller marshaller = pain001Context.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(pain001, stringWriter);
        return stringWriter.toString();
    }

}
