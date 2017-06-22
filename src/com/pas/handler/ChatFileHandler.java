/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pas.handler;

import com.pas.dao.DAOChat;
import com.pas.dao.DAOMessage;
import com.pas.dao.DAOSender;
import com.pas.domain.Chat;
import com.pas.domain.ChatFile;
import com.pas.domain.Entity;
import com.pas.domain.Message;
import com.pas.domain.Sender;
import com.pas.util.ParseDateString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class ChatFileHandler implements IEntityHandler {
	
	private HashMap<String, Sender> chatSenders;
	private ChatFile chatfile;
	
	@Override
    public Entity handle(Entity entity) {
		this.chatfile = (ChatFile) entity;
		
        Chat chat = null;
        try {
            chat = saveChat(getChat(chatfile));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return chat;
    }
    
    private Chat getChat(ChatFile chatfile) {
    	Chat chat = new Chat();
    	chat.setAlias(chatfile.getFilename());
        ArrayList<Message> messages = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new StringReader(chatfile.getFilecontent()))) {
            String line = reader.readLine();
            
            while(line != null) {
            	if (line.equals("MESSAGES")) {
                    line = reader.readLine();
                    
                    // if is a new conversation
                    while(line != null) {
                        Message message = new Message();
                        message.setChat(chat);
                        
                        String[] messageLine = line.split("\\|");
                        
                        message.setSender(new Sender(messageLine[0]));
                        message.setTimestamp(ParseDateString.parse(messageLine[1]));
                        message.setMessageContent(messageLine[2]);
                        
                        messages.add(message);
                        line = reader.readLine();
                    }
                    chat.setMessages(messages);
                } else {
                	line = reader.readLine();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatFileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chat.setMessages(messages);
        return chat;
    }

    public Chat saveChat(Chat chat) {
    	DAOChat daoChat = new DAOChat();
    	chat.setId(daoChat.insert(chat).getId());
    	chatSenders = saveSenders(chat);
    	chat.setMessages(saveMessages(chat.getMessages()));
    	return chat;
    }

    public ArrayList<Message> saveMessages(ArrayList<Message> messages) {
    	DAOMessage daoMessage = new DAOMessage();
    	
    	for(Message message : messages) {
    		message.setSender(chatSenders.get(message.getSender().getName()));
    	}
    	
    	return daoMessage.insert(messages);
    }
    
    public HashMap<String, Sender> saveSenders(Chat chat) {
    	DAOSender daoSender = new DAOSender();
    	
    	Sender remetente = new Sender();
    	Sender destinatario = new Sender();
    	
    	remetente.setChat(chat);
    	destinatario.setChat(chat);
    	remetente.setName(chatfile.getSender());
    	destinatario.setName(chatfile.getRecipient());
    	
    	remetente.setId(daoSender.insert(remetente).getId());
    	destinatario.setId(daoSender.insert(destinatario).getId());
    	
    	HashMap<String, Sender> senders = new HashMap<>();
    	senders.put(remetente.getName(), remetente);
    	senders.put(destinatario.getName(), destinatario);
    	
    	return senders;
    }

	@Override
	public Entity handle(Entity entity, String action) {
		// TODO Auto-generated method stub
		return null;
	}

    /*public void countWords(String fileContent) {
        String[] words = fileContent.split(" ");

        DAOWordCount daoWordCount = new DAOWordCount();
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        System.out.println("Counting words...");
        for(String word : words) {
            if (!word.trim().equals("")) {
                if(wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
        }

        System.out.println("Updating word count table...!");
        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            WordCount wordCount = new WordCount();
            DAOWordCount dao = new DAOWordCount();

            wordCount.setWord(entry.getKey().trim());
            wordCount.setCount(entry.getValue());

            System.out.println("Current word ->" + entry.getKey() + ": " + entry.getValue());

            dao.insert(wordCount);

        }

        System.out.println("Word count updated!");
    }*/
}
