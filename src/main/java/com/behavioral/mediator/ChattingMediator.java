package com.behavioral.mediator;

public interface ChattingMediator {

    public abstract void sendMessage(String message,User user);
    public abstract void addUser(User user);
}
