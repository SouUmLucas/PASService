package com.pas.domain;

import java.util.Date;

public class Message extends Entity {
    
    private Chat chat;
    private Date timestamp;
    private Sender sender;
    private String messageContent;

    public Message() {}

    public Message(Chat chat, String messageContent) {
        this.chat = chat;
        this.messageContent = messageContent;
    }

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
    
    
}
