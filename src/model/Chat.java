package model;

import java.util.ArrayList;

public class Chat extends Entity {
	private String alias;
	private ChatFileReference chatFileReference;
	private ArrayList<Message> messages;

	public Chat() {}

	public Chat(String alias, ChatFileReference chatFileReference, ArrayList<Message> messages) {
		this.alias = alias;
		this.chatFileReference = chatFileReference;
		this.messages = messages;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public ChatFileReference getChatFileReference() {
		return chatFileReference;
	}

	public void setChatFileReference(ChatFileReference chatFileReference) {
		this.chatFileReference = chatFileReference;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
}
