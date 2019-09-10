package com.mdbprocessor.pain001.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Pain001")
@XmlAccessorType(XmlAccessType.FIELD)

public class Pain001 {
    private String MsgId;
    private Integer NbOfTxs;

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }

    public Integer getNbOfTxs() {
        return NbOfTxs;
    }

    public void setNbOfTxs(Integer nbOfTxs) {
        this.NbOfTxs = nbOfTxs;
    }

}
