package com.pas.util;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.pas.domain.Chat;
import com.pas.domain.Entity;
import com.pas.domain.Message;
import com.pas.domain.Sender;

public class ParseChat extends AbstractParseObjectToJson {

	@Override
	public String parse(Entity _entity) {
		Gson gson = new Gson();
		
		Chat _chat = (Chat) _entity;
		Chat chat = new Chat();
		chat.setAlias(_chat.getAlias());
		chat.setId(_chat.getId());
		

		ArrayList<Message> messages = new ArrayList<>();
		for(Message _message : _chat.getMessages()) {
			Message message = new Message();
			
			Sender sender = new Sender();
			sender.setId(_message.getSender().getId());
			sender.setName(_message.getSender().getName());
			
			message.setSender(sender);
			
			message.setId(_message.getId());
			message.setTimestamp(_message.getTimestamp());
			message.setMessageContent(_message.getMessageContent());
			messages.add(message);
		}
		chat.setMessages(messages);
		
		String json = gson.toJson(chat);
		return json;
	}

}
