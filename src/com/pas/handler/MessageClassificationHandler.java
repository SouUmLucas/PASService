package com.pas.handler;

import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.pas.classifier.BayesClassifier;
import com.pas.dao.DAOMessage;
import com.pas.dao.DAOMessageClassification;
import com.pas.domain.Entity;
import com.pas.domain.Message;
import com.pas.domain.MessageClassification;
import com.pas.domain.MessagesClassifications;

public class MessageClassificationHandler {

	public ArrayList<MessageClassification> handle(Entity entity) {
		MessageClassification messageClassification = (MessageClassification) entity;
		ArrayList<Message> messages = getMessagesFromDataBase(messageClassification);
		BayesClassifier bayesClassifier = new BayesClassifier();
		ArrayList<MessageClassification> classifiedMessages = bayesClassifier.classify(messages);
		return saveMessagesClassification(classifiedMessages);
	}

	public MessagesClassifications update(Entity entity) {
		MessagesClassifications messagesClassifications = (MessagesClassifications) entity;
		
		MessagesClassifications newMessagesClassifications = new MessagesClassifications();
		newMessagesClassifications.setMessagesClassification(updateMessagesClassifications(messagesClassifications.getMessagesClassification()));
		
		return newMessagesClassifications;
	}
	
	private ArrayList<MessageClassification> saveMessagesClassification(ArrayList<MessageClassification> messagesClassifications) {
		ArrayList<MessageClassification> savedMessagesClassification = new ArrayList<>();
		DAOMessageClassification daoMessageClassification = new DAOMessageClassification();
		
		savedMessagesClassification = daoMessageClassification.insert(messagesClassifications);
		return savedMessagesClassification;
	}
	
	private ArrayList<Message> getMessagesFromDataBase(MessageClassification messageClassification) {
		ArrayList<Message> messages = new ArrayList<>();
		
		DAOMessage daoMessage = new DAOMessage();
		for(Message message : messageClassification.getMessages()) {
			Message newMessage = (Message) daoMessage.select(message);
			messages.add(newMessage);
		}
		return messages;
	}
	
	private ArrayList<MessageClassification> updateMessagesClassifications(ArrayList<MessageClassification> messagesClassifications) {
		ArrayList<MessageClassification> updatedMessagesClassification = new ArrayList<>();
		DAOMessageClassification daoMessageClassification = new DAOMessageClassification();
		
		updatedMessagesClassification = daoMessageClassification.update(messagesClassifications);
		return updatedMessagesClassification;
	}
}
