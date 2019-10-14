package com.cloudstreamrmq.messaging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private String messageSender;
    private String messageHeading;
    private String messageContent;

    public Message(){
    }

    public Message(String messageSender, String messageHeading, String messageContent) {
        this.messageSender = messageSender;
        this.messageHeading = messageHeading;
        this.messageContent = messageContent;
    }

    public void setMessageSender(String messageSender) {
        this.messageSender = messageSender;
    }

    public void setMessageHeading(String messageHeading) {
        this.messageHeading = messageHeading;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageSender() {
        return messageSender;
    }

    public String getMessageHeading() {
        return messageHeading;
    }

    public String getMessageContent() {
        return messageContent;
    }

    @Override
    public String toString() {
        return String.format("Message: messageSender: %s, messageHeading: %s, messageContent: %s",
                messageSender, messageHeading, messageContent);
    }
}
