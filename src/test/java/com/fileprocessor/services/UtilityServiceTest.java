package com.fileprocessor.services;

import com.fileprocessor.persistence.PaymentInstruction;
import com.fileprocessor.repository.PaymentInstructionRepository;
import iso.std.iso._20022.tech.xsd.pain_001_001.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilityServiceTest {


    @Autowired
    private PaymentInstructionRepository paymentInstructionRepository;
    private PaymentInstruction paymentInstruction;

    @Autowired
    private UtilityService utilityService;


    @Test
    public void unmarshalling()throws JAXBException, XMLStreamException {
//        PaymentInstruction paymentInstruction = new PaymentInstruction();
//        JAXBContext jContext = JAXBContext.newInstance(PaymentInstruction.class);
//        Unmarshaller unmarshaller = jContext.createUnmarshaller();
//        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader("xmlString"));
//        Document pain001 = (Document) unmarshaller.unmarshal(reader);
//
//        paymentInstruction.setId(101);
//        paymentInstruction.setMessageId(pain001.getCstmrCdtTrfInitn().getGrpHdr().getMsgId());
//        paymentInstruction.setXml(pain001.toString());
//
//        paymentInstructionRepository.save(paymentInstruction);
    }

    @Test(expected = JAXBException.class)
    public void testInvalidXmlUnmarshall() throws JAXBException, XMLStreamException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.05\">\n" +
                "    <CstmrCdtTrfInitn>\n" +
                "        <GrpHdr>\n" +
                "            <MsgId>F/NBC/DRT/AAH/20190906/14444076377</MsgId>\n" +
                "            <CreDtTm>2018-11-21T09:57:28.567+02:00</CreDtTm>\n" +
                "            <NbOfTxs>1</NbOfTxs>\n" +
                "\n" +
                "            <CtrlSum>10</CtrlSum>\n" +
                "\n" +
                "            <InitgPty>\n" +
                "\n" +
                "                <Nm>AAH</Nm>\n" +
                "\n" +
                "            </InitgPty>\n" +
                "\n" +
                "        </GrpHdr>\n" +
                "\n" +
                "        <PmtInf>\n" +
                "\n" +
                "            <PmtInfId>67b1df568d2d4684be440e5202c10926</PmtInfId>\n" +
                "\n" +
                "            <PmtMtd>TRF</PmtMtd>\n" +
                "\n" +
                "            <BtchBookg>false</BtchBookg>\n" +
                "\n" +
                "            <PmtTpInf>\n" +
                "\n" +
                "                <SvcLvl>\n" +
                "\n" +
                "                    <Cd>URGP</Cd>\n" +
                "\n" +
                "                </SvcLvl>\n" +
                "\n" +
                "                <CtgyPurp>\n" +
                "\n" +
                "                    <Cd>EPAY</Cd>\n" +
                "\n" +
                "                </CtgyPurp>\n" +
                "\n" +
                "            </PmtTpInf>\n" +
                "\n" +
                "            <ReqdExctnDt>2019-09-06</ReqdExctnDt>\n" +
                "\n" +
                "            <Dbtr>\n" +
                "\n" +
                "                <Nm>Merchant 01</Nm>\n" +
                "\n" +
                "                <PstlAdr>\n" +
                "\n" +
                "                    <StrtNm>Alice Lane15</StrtNm>\n" +
                "\n" +
                "                    <BldgNb>15</BldgNb>\n" +
                "\n" +
                "                    <PstCd>2000</PstCd>\n" +
                "\n" +
                "                    <TwnNm>Mkwakwani</TwnNm>\n" +
                "\n" +
                "                    <Ctry>TZ</Ctry>\n" +
                "\n" +
                "                    <AdrLine>Adress line 2</AdrLine>\n" +
                "\n" +
                "                </PstlAdr>\n" +
                "\n" +
                "            </Dbtr>\n" +
                "\n" +
                "            <DbtrAcct>\n" +
                "\n" +
                "                <Id>\n" +
                "\n" +
                "                    <Othr>\n" +
                "\n" +
                "                        <Id>001101108978</Id>\n" +
                "\n" +
                "                    </Othr>\n" +
                "\n" +
                "                </Id>\n" +
                "\n" +
                "                <Ccy>TZS</Ccy>\n" +
                "\n" +
                "            </DbtrAcct>\n" +
                "\n" +
                "            <DbtrAgt>\n" +
                "\n" +
                "                <FinInstnId>\n" +
                "\n" +
                "                    <BICFI>FNMITZTZ</BICFI>\n" +
                "\n" +
                "                    <ClrSysMmbId>\n" +
                "\n" +
                "                        <MmbId>15</MmbId>\n" +
                "\n" +
                "                    </ClrSysMmbId>\n" +
                "\n" +
                "                </FinInstnId>\n" +
                "\n" +
                "                <BrnchId>\n" +
                "\n" +
                "                    <Id>001</Id>\n" +
                "\n" +
                "                </BrnchId>\n" +
                "\n" +
                "            </DbtrAgt>\n" +
                "\n" +
                "            <CdtTrfTxInf>\n" +
                "\n" +
                "                <PmtId>\n" +
                "\n" +
                "                    <InstrId>cc724c17712642d182c8caa89a92a529</InstrId>\n" +
                "\n" +
                "                    <EndToEndId>76beaeae38154f19964ab995304a3355</EndToEndId>\n" +
                "\n" +
                "                </PmtId>\n" +
                "\n" +
                "                <PmtTpInf>\n" +
                "\n" +
                "                    <SvcLvl>\n" +
                "\n" +
                "                        <Cd>URGP</Cd>\n" +
                "\n" +
                "                    </SvcLvl>\n" +
                "\n" +
                "                    <CtgyPurp>\n" +
                "\n" +
                "                        <Cd>EPAY</Cd>\n" +
                "\n" +
                "                    </CtgyPurp>\n" +
                "\n" +
                "                </PmtTpInf>\n" +
                "\n" +
                "                <Amt>\n" +
                "\n" +
                "                    <InstdAmt Ccy=\"TZS\">11.00</InstdAmt>\n" +
                "\n" +
                "                </Amt>\n" +
                "\n" +
                "                <CdtrAgt>\n" +
                "\n" +
                "                    <FinInstnId>\n" +
                "\n" +
                "                        <BICFI>AZANTZTZ</BICFI>\n" +
                "\n" +
                "                    </FinInstnId>\n" +
                "\n" +
                "                    <BrnchId>\n" +
                "\n" +
                "                        <Id>020</Id>\n" +
                "\n" +
                "                    </BrnchId>\n" +
                "\n" +
                "                </CdtrAgt>\n" +
                "\n" +
                "                <Cdtr>\n" +
                "\n" +
                "                    <Nm>Test018</Nm>\n" +
                "\n" +
                "                    <PstlAdr>\n" +
                "\n" +
                "                        <StrtNm>Alice Lane1</StrtNm>\n" +
                "\n" +
                "                        <BldgNb>16</BldgNb>\n" +
                "\n" +
                "                        <PstCd>2100</PstCd>\n" +
                "\n" +
                "                        <TwnNm>gauteng</TwnNm>\n" +
                "\n" +
                "                        <Ctry>UG</Ctry>\n" +
                "\n" +
                "                        <AdrLine>ADD1</AdrLine>\n" +
                "\n" +
                "                    </PstlAdr>\n" +
                "\n" +
                "                </Cdtr>\n" +
                "\n" +
                "                <CdtrAcct>\n" +
                "\n" +
                "                    <Id>\n" +
                "\n" +
                "                        <Othr>\n" +
                "\n" +
                "                            <Id>020101005252</Id>\n" +
                "\n" +
                "                        </Othr>\n" +
                "\n" +
                "                    </Id>\n" +
                "\n" +
                "                    <Ccy>TZS</Ccy>\n" +
                "\n" +
                "                </CdtrAcct>\n" +
                "\n" +
                "                <RmtInf>\n" +
                "\n" +
                "                    <Strd>\n" +
                "\n" +
                "                        <CdtrRefInf>\n" +
                "\n" +
                "                            <Ref>77671df4940213</Ref>\n" +
                "\n" +
                "                        </CdtrRefInf>\n" +
                "\n" +
                "                    </Strd>\n" +
                "\n" +
                "                </RmtInf>\n" +
                "\n" +
                "            </CdtTrfTxInf>\n" +
                "\n" +
                "        </PmtInf>\n" +
                "\n" +
                "    </CstmrCdtTrfInitn>\n" +
                "\n" +
                "</Document>";
        Document pain001 = utilityService.unmarshal(xml);
     /*   File file = new File("c:/temp/pain001.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInstruction.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        PaymentInstruction paymentInstruction = (PaymentInstruction) unmarshaller.unmarshal(file);
        System.out.println(paymentInstruction);*/
    }
}
