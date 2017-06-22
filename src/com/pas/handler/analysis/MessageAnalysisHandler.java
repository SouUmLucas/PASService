package com.pas.handler.analysis;

import java.util.ArrayList;

import com.pas.dao.DAOMessage;
import com.pas.dao.analysis.DAOMessageSender;
import com.pas.domain.Entity;
import com.pas.domain.analysis.MessageAnalysis;
import com.pas.domain.analysis.MessageSender;
import com.pas.handler.IEntityHandler;

public class MessageAnalysisHandler implements IEntityHandler {

	@Override
	public Entity handle(Entity entity) {
		MessageAnalysis messageAnalysis = (MessageAnalysis) entity;
		ArrayList<MessageSender> messageSenders = getMessageSenders();
		messageAnalysis.setMessageSender(messageSenders);
		messageAnalysis.setMessages(getMessagesForAnalysis());
		return messageAnalysis;
	}

	private ArrayList<MessageSender> getMessageSenders() {
		DAOMessageSender daoMessageSender = new DAOMessageSender();
		ArrayList<MessageSender> messageSenders = daoMessageSender.selectAll();
		
		return messageSenders;
	}

	private ArrayList<com.pas.domain.analysis.Message> getMessagesForAnalysis() {
		DAOMessage daoMessage = new DAOMessage();
		ArrayList<com.pas.domain.analysis.Message> messages = daoMessage.GetMessagesForAnalysis();
		return messages;
	}

	@Override
	public Entity handle(Entity entity, String action) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
