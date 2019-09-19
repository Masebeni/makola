package com.fileprocessor;

import com.fileprocessor.persistence.PaymentInstruction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentProcessorTests {
	private PaymentInstruction paymentInstruction;
	@Test
	public void unmarshaller() throws JAXBException, FileNotFoundException {
		File file = new File("myXml.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInstruction.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		paymentInstruction = (PaymentInstruction) unmarshaller.unmarshal(file);
		System.out.println(paymentInstruction);
	}

}
