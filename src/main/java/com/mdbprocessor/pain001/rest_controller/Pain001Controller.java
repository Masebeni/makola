package com.mdbprocessor.pain001.rest_controller;

import com.mdbprocessor.pain001.entity_model.Pain001;
import com.mdbprocessor.pain001.service.Pain001Service;
import com.mdbprocessor.pain001.service_implementation.Pain001ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@XmlRootElement(name = "GrpHdr")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pain001Controller {
    @XmlElement(name = "GrpHdr")
    public Pain001Service pain001Service;

    public void setPain001Service(Pain001Service pain001Service) {
        this.pain001Service = pain001Service;
    }

    @GetMapping("/api/pain001")
    public List<Pain001> getPain001s() {
        List<Pain001> pain001s = pain001Service.retrievePain001s();
        return pain001s;
    }

    @GetMapping("/api/employees/{employeeId}")
    public Pain001 getPain001(@PathVariable(name="Id")String Id) {
        return pain001Service.getPain001(Id);
    }

    @PostMapping("/api/pain001s")
    public void savePain001(Pain001 pain001){
        pain001Service.savePain001(pain001);
        System.out.println("Pain001 Saved Successfully");
    }

    @DeleteMapping("/api/pain001s/{id}")
    public void deletePain001(@PathVariable(name="id")String Id){
        pain001Service.deletePain001(Id);
        System.out.println("Pain001 Deleted Successfully");
    }

    @PutMapping("/api/pain001s/{id}")
    public void updatePain001(@RequestBody Pain001 pain001,
                               @PathVariable(name="Id")String Id) {
        Pain001 pain0011 = pain001Service.getPain001(Id);
        if (pain001 != null) {
            pain001Service.updatePain001(pain001);
        }
    }
}
