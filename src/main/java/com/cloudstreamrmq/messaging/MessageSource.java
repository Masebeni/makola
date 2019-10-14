package com.cloudstreamrmq.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {
    @Output("MessageChannel")
    MessageChannel messageChannel();
}