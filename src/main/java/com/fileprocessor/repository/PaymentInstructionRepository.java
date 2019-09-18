package com.fileprocessor.repository;

import com.fileprocessor.persistence.PaymentInstruction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInstructionRepository extends CrudRepository<PaymentInstruction, Integer> {}
