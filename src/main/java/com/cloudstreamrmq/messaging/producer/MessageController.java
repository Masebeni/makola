package com.cloudstreamrmq.messaging.producer;

import com.cloudstreamrmq.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(MessageSource.class)

public class MessageController {
    @Autowired
    MessageSource messageSource;

    @RequestMapping("/message")
    @ResponseBody
    public String sendMessage(@RequestBody Message message){
        messageSource.messageChannel().send(MessageBuilder.withPayload(message).build());
        System.out.println(message.toString());
        return "Message sent!";
    }
}