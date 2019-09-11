package com.mdbprocessor.systems;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Pain001")
public class Pain001 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "messsage_id")
    private String message_id;

    @Column(name = "PmtInfId")
    private String PmtInfId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getPmtInfId() {
        return PmtInfId;
    }

    public void setPmtInfId(String pmtInfId) {
        PmtInfId = pmtInfId;
    }




}

