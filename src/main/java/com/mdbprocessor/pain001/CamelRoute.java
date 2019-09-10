package com.mdbprocessor.pain001;

import com.mdbprocessor.pain001.model.Pain001;
import com.mdbprocessor.pain001.model.Pain001s;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

public class CamelRoute {
    static Pain001s pain001s = new Pain001s();

    public static void main(String[] args) throws JAXBException {
        unMarshaling();
    }

    private static void unMarshaling() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Pain001s.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Pain001s pain001s = (Pain001s) jaxbUnmarshaller.unmarshal(new File("c:/temp/pain001.xml"));

        for (Pain001 pain001 : pain001s.getPain001s()) {
            System.out.println(pain001.getNbOfTxs());
            System.out.println(pain001.getMsgId());
        }
        System.out.println("======== DONE UNMARSHALING ========");
    }

}
