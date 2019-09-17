package com.mdbprocessor.repository;

import com.mdbprocessor.persistence.PaymentInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentInstructionRepository extends JpaRepository<PaymentInstruction, Long> {

    PaymentInstruction findFileById(@Param("id") long id);
}
