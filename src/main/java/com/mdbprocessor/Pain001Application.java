package com.mdbprocessor;

import com.mdbprocessor.systems.Pain001;
import com.mdbprocessor.services.PaymentInstrument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@SpringBootApplication
public class Pain001Application {

	public static void main(String[] args) throws JAXBException {
		//unMarshaling();
		SpringApplication.run(Pain001Application.class, args);
	}

	private static void unMarshaling() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInstrument.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		PaymentInstrument pain001s = (PaymentInstrument) jaxbUnmarshaller.unmarshal(new File("c:/temp/pain001.xml"));

		for (Pain001 pain001 : ((PaymentInstrument) pain001s).getPain001s()) {
			System.out.println(pain001.getId());
			System.out.println(pain001.getMessage_id());
		}
		System.out.println("======== DONE UNMARSHALING ========");
	}

}
