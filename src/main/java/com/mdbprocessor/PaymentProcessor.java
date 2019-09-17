package com.mdbprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentProcessor {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProcessor.class, args);
    }
/*
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            fileRepository.save(new FileEntity(1,"NBC/DRT/AAH/20190906/14444076377","xml body"));
            fileRepository.save(new FileEntity(2,"NBC/DRT/AAH/20190906/14444076378","XML BODY"));
        };
    }*/
}
