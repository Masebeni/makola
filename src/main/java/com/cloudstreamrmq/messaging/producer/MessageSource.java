package com.cloudstreamrmq.messaging.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {
    @Output("MessageChannel")
    MessageChannel messageChannel();
}