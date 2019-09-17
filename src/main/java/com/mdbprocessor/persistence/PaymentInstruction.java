package com.mdbprocessor.persistence;

import lombok.Data;

import javax.persistence.*;

//persist
@Data
@Entity
public class PaymentInstruction {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "message_id")
    private String message_id;

    @Lob
    private String xml;
}
