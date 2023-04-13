package com.behavioral.ObserverPattern;

public final class Message {
    private final String messageContent;

    public Message (String m) {
        this.messageContent = m;
    }

    public String getMessageContent() {
        return messageContent;
    }

    @Override
    public String toString() {
        return "Message {" +
                "Content='" + messageContent + '\'' +
                '}';
    }
}
