package com.fileprocessor.persistence;

import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Entity
public class PaymentInstruction {

    @GeneratedValue
    @Id
    private int id;

    @Column(name = "messageId")
    private String messageId;

    @Lob
    private String xml;


}
