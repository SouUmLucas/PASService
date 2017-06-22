package com.pas.domain.analysis;

import java.sql.Timestamp;

public class Message {
	private String sender;
	private Timestamp timestamp;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
