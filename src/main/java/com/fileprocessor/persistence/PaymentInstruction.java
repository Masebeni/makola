package com.fileprocessor.persistence;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class PaymentInstruction {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "message_id")
    private String message_id;

    @Lob
    private String xml;

    public int getId() {
        return id;
    }
}
