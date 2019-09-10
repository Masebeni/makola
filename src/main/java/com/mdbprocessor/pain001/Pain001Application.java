package com.mdbprocessor.pain001;

import com.mdbprocessor.pain001.entity_model.Pain001;
import com.mdbprocessor.pain001.service_implementation.Pain001ServiceImpl;
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
		JAXBContext jaxbContext = JAXBContext.newInstance(Pain001.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Pain001 pain001s = (Pain001ServiceImpl) jaxbUnmarshaller.unmarshal(new File("c:/temp/pain001.xml"));

		for (Pain001 pain001 : ((Pain001ServiceImpl) pain001s).getPain001s()) {
			System.out.println(pain001.getId());
			System.out.println(pain001.getMessage_id());
		}
		System.out.println("======== DONE UNMARSHALING ========");
	}

}
