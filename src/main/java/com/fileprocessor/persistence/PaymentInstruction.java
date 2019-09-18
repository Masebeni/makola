package com.fileprocessor.persistence;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class PaymentInstruction {
    @Id
    @GeneratedValue
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

    public String getXml(String xml) {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
