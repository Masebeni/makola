package com.fileprocessor.persistence;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
public class PaymentInstruction {

    @Id
    @Column(name = "messageId")
    private String messageId;
    @Column(name = "creDtTml")
    private OffsetDateTime creDtTml;
    @Column(name = "pmtInfId")
    private String pmtInfId;

    @Column(name = "ctrlSum")
    private BigDecimal ctrlSum;
    @Lob
    private String xml;

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    public String getMessageId() {
        return messageId;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
    public String getXml() { return xml; }

    public OffsetDateTime getCreDtTm() {
        return creDtTml;
    }
    public void setCreDtTm(OffsetDateTime creDtTml) {
        this.creDtTml = creDtTml;
    }

    public void setPmtInfId(String pmtInfId) {
        this.pmtInfId = pmtInfId;
    }
    public String getPmtInfId() {
        return pmtInfId;
    }

    public void setCtrlSum(BigDecimal ctrlSum) {
        this.ctrlSum = ctrlSum;
    }
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

}
