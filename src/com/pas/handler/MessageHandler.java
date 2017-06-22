package com.pas.handler;

import java.util.ArrayList;

import com.pas.dao.DAOMessage;
import com.pas.domain.Entity;
import com.pas.domain.Message;

public class MessageHandler implements IEntityHandler {

	@Override
	public Entity handle(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity handle(Entity entity, String action) {
		Message message = (Message) entity;
		Message newMessage = new Message();
		
		if (action.equals("create")) {
			newMessage = createMessage(message);
		
		} else if (action.equals("select")) {
			newMessage = selectMessage(message);
		
		} else if (action.equals("update")) {
			newMessage = updateMessage(message);
		
		} else if (action.equals("delete")) {
			newMessage = deleteMessage(message);
		}
		return newMessage;
	}

	private Message deleteMessage(Message message) {
		DAOMessage daoMessage = new DAOMessage();
		daoMessage.delete(message);
		return null;
	}

	private Message updateMessage(Message message) {
		DAOMessage daoMessage = new DAOMessage();
		daoMessage.update(message);
		return message;
	}

	private Message selectMessage(Message message) {
		DAOMessage daoMessage = new DAOMessage();
		return (Message) daoMessage.select(message);
	}

	private Message createMessage(Message message) {
		DAOMessage daoMessage = new DAOMessage();
		return (Message) daoMessage.insert(message);
	}

	public ArrayList<Message> getAll() {
		DAOMessage daoMessage = new DAOMessage();
		
		return daoMessage.selectAll();
	}

}
