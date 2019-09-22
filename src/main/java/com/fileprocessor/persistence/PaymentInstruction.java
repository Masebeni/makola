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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
