package com.mdbprocessor;

import com.mdbprocessor.systems.Pain001;
import com.mdbprocessor.services.PaymentInstrument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

@SpringBootApplication
public class Pain001Application {

	public static void main(String[] args) throws JAXBException {
		//marshaling();
		SpringApplication.run(Pain001Application.class, args);
	}

	private static void marshaling() throws JAXBException {
		try{
			JAXBContext jContext = JAXBContext.newInstance(Pain001.class);
			Marshaller marshallObj = jContext.createMarshaller();
			marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Pain001 pain001 = new Pain001("Xolela", "Masebeni");
			marshallObj.marshal(pain001, new FileOutputStream("c:/temp/pain001.xml"));

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
