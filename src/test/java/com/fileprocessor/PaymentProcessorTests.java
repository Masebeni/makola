package com.fileprocessor;

import com.fileprocessor.persistence.PaymentInstruction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentProcessorTests {
	private PaymentInstruction paymentInstruction;

	@Before
	public void setUp() {
		paymentInstruction = new PaymentInstruction();
		paymentInstruction.setId(202);
		paymentInstruction.setMessageId("MessageId");
		paymentInstruction.setXml("xmlBody");
	}

	@Test
	public void marshaller() throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInstruction.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(paymentInstruction, new File("c:/temp/pain001.xml"));
		marshaller.marshal(paymentInstruction, System.out);
	}

	@Test
	public void unmarshaller() throws JAXBException, FileNotFoundException {
		File file = new File("c:/temp/pain001.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInstruction.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PaymentInstruction paymentInstruction = (PaymentInstruction) unmarshaller.unmarshal(file);
		System.out.println(paymentInstruction);
	}

}
