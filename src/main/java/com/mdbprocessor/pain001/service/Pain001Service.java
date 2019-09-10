package com.mdbprocessor.pain001.service;

import com.mdbprocessor.pain001.entity_model.Pain001;

import java.util.List;

public interface Pain001Service {
    public List<Pain001> retrievePain001s();

    public Pain001 getPain001(String Id);

    public void savePain001(Pain001 pain001);

    public void deletePain001(String Id);

    public void updatePain001(Pain001 pain001);
}