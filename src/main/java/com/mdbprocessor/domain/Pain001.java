package com.mdbprocessor.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Pain001")
@XmlRootElement(name = "CstmrCdtTrfInitn")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pain001 {
    @XmlElement(name = "GrpHdr")
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "MsgId")
    private String MsgId;

    @Column(name = "PmtInfId")
    private String PmtInfId;

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }

}
