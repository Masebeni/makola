package com.fileprocessor.services;

import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilityServiceTest {

    @Autowired
    private UtilityService utilityService;

    @Test
    public void testValidXmlUnmarshall() throws JAXBException, XMLStreamException, IOException {
        String xml = new String(Files.readAllBytes(Paths.get("src/test/resources/sample.xml")));
        Document pain001 = utilityService.unmarshal(xml);
        Assert.assertEquals(pain001.getCstmrCdtTrfInitn().getGrpHdr().getMsgId(), "F/BWA/INT/AAH/20190918/11385736842");
    }

    @Test(expected = JAXBException.class)
    public void testInValidXmlUnmarshall() throws JAXBException, XMLStreamException, IOException {
        String xml = "xml";
        Document pain001 = utilityService.unmarshal(xml);
    }

    @Test
    public void testMarshal() throws JAXBException, XMLStreamException, IOException {
        String xml = new String(Files.readAllBytes(Paths.get("src/test/resources/sample.xml")));
        Document pain001 = utilityService.unmarshal(xml);
        String marshalString = utilityService.marshal(pain001);
        System.out.println(marshalString);
    }
}
