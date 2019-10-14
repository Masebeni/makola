package com.cloudstreamrmq.messaging.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageListener {
    @StreamListener(target = Sink.INPUT)
    public void processMessageChannel(String message){
        System.out.println("Your message: "+ message);
    }
}
