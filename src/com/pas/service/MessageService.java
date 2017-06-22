package com.pas.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.pas.domain.Message;
import com.pas.handler.MessageHandler;

@Path("/messages")
public class MessageService implements IService {

	@Override
	@GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String get(@PathParam("id") int id) {
		Gson gson = new Gson();
		MessageHandler messageHandler = new MessageHandler();
		Message message = new Message();
		message.setId(id);
		Message newMessage = (Message) messageHandler.handle(message, "select");
		String jsonResult = gson.toJson(newMessage);
		return jsonResult;
	}
	
	@GET
    @Path("/allmessages")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String get() {
		Gson gson = new Gson();
		MessageHandler messageHandler = new MessageHandler();
		ArrayList<Message> messages = messageHandler.getAll();
		String jsonResult = gson.toJson(messages);
		return jsonResult;
	}

	@Override
	@POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String create(String json) {
		Gson gson = new Gson();
		MessageHandler messageHandler = new MessageHandler();
		Message message = gson.fromJson(json, Message.class);
		Message savedMessage = (Message) messageHandler.handle(message, "create");
		String jsonResult = gson.toJson(savedMessage);
		return jsonResult;
	}

	@Override
	@PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String update(String json) {
		Gson gson = new Gson();
		MessageHandler messageHandler = new MessageHandler();
		Message message = gson.fromJson(json, Message.class);
		Message savedMessage = (Message) messageHandler.handle(message, "update");
		String jsonResult = gson.toJson(savedMessage);
		return jsonResult;
	}

	@Override
	@DELETE
    @Path("/")
	public Response delete(String json) {
		Gson gson = new Gson();
		MessageHandler messageHandler = new MessageHandler();
		Message message = gson.fromJson(json, Message.class);
		messageHandler.handle(message, "delete");
		return Response.status(200).build();
	}

}
