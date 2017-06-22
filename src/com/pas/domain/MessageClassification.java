package com.pas.domain;

import java.util.ArrayList;

/**
 * Created by lucas on 22/05/2017.
 */
public class MessageClassification extends ClassificationEntity {
    private ArrayList<Message> messages;
    private Message message;
    
	public ArrayList<Message> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
    
    
}
