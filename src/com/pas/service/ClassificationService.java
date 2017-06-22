package com.pas.service;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.pas.domain.Chat;
import com.pas.domain.ChatFile;
import com.pas.domain.Entity;
import com.pas.domain.MessageClassification;
import com.pas.domain.MessagesClassifications;
import com.pas.handler.MessageClassificationHandler;
import com.pas.util.IParseObjectToJson;
import com.pas.util.ParseChat;

@Path("/messageclassification")
public class ClassificationService implements IService {
HashMap<String, IParseObjectToJson> jsonParsers;
	
	public ClassificationService() {
		jsonParsers = new HashMap<>();
		jsonParsers.put(MessageClassification.class.getName(), new ParseChat());
	}
	
	@Override
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public String get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String create(String json) {
    	Gson gson = new Gson();
		MessageClassificationHandler messageClassificationHandler = new MessageClassificationHandler();
		MessageClassification messageClassification = gson.fromJson(json, MessageClassification.class);	
		String jsonResult = gson.toJson(messageClassificationHandler.handle(messageClassification));
        return jsonResult;
	}
    
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String update(String json) {
    	Gson gson = new Gson();
    	MessageClassificationHandler messageClassificationHandler = new MessageClassificationHandler();
    	MessagesClassifications messagesClassifications = gson.fromJson(json, MessagesClassifications.class);
    	
    	String jsonResult = gson.toJson(messageClassificationHandler.update(messagesClassifications));
    	return jsonResult;
	}

	@Override
	public Response delete(String json) {
		// TODO Auto-generated method stub
		return null;
	}

}
