package com.mdbprocessor.pain001.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CstmrCdtTrfInitn")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pain001s {
    @XmlElement(name = "GrpHdr")
    private List<Pain001> pain001s;

    public List<Pain001> getPain001s() {
        return pain001s;
    }

    public void setPain001s(List<Pain001> pain001s) {
        this.pain001s = pain001s;
    }
}
