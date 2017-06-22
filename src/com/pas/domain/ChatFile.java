package com.pas.domain;

/**
 * Created by lucas on 22/05/2017.
 */
public class ChatFile extends File {
	private String recipient;
    private String sender;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
