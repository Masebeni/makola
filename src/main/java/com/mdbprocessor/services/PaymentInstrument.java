package com.mdbprocessor.services;

import com.mdbprocessor.systems.Pain001;
import com.mdbprocessor.repository.Pain001Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentInstrument {
    @Autowired
    private Pain001Repository pain001Repository;

    public void setPain001Repository(Pain001Repository pain001Repository) {
        this.pain001Repository = pain001Repository;
    }

    public List<Pain001> getPain001s() {
        List<Pain001> pain001s = pain001Repository.findAll();
        return pain001s;
    }

    public Pain001 getPain001(String Id) {
        Optional<Pain001> optPain001 = pain001Repository.findById(Id);
        return optPain001.get();
    }

    public void savePain001(Pain001 pain001){
        pain001Repository.save(pain001);
    }

    public void deletePain001(String Id){
        pain001Repository.deleteById(Id);
    }

    public void updatePain001(Pain001 pain001) {
        pain001Repository.save(pain001);
    }

}
