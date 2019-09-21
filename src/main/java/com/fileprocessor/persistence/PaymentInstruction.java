package com.fileprocessor.persistence;

import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Entity
@XmlRootElement(name = "pain001")
public class PaymentInstruction {

    @GeneratedValue
    @Id
    private int id;

    @Column(name = "messageId")
    private String messageId;

    @Lob
    private String xml;


}
