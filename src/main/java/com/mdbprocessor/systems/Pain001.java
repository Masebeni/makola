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
    private Integer id;

    @Column(name = "messsage_id")
    private String message_id;

    @Column(name = "xml")
    private String xml;

    public Pain001(String message_id, String xml) {
        this.message_id = message_id;
        this.xml = xml;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }
}

