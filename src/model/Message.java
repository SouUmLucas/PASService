package model;

public class Message extends Entity {
	private Chat chat;
	private String messageContent;

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

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
}
