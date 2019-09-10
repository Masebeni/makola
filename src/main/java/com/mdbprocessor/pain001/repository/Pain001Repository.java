package com.mdbprocessor.pain001.repository;

import com.mdbprocessor.pain001.entity_model.Pain001;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Pain001Repository extends JpaRepository<Pain001, String> {
    Optional<Pain001> findById(String id);
}
