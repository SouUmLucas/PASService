package com.pas.service;

import com.google.gson.Gson;
import com.pas.domain.Chat;
import com.pas.domain.ChatFile;
import com.pas.domain.Entity;
import com.pas.handler.ChatFileHandler;
import com.pas.util.IParseObjectToJson;
import com.pas.util.ParseChat;
import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/chat")
public class ChatService implements IService {
	HashMap<String, IParseObjectToJson> jsonParsers;
	
	public ChatService() {
		jsonParsers = new HashMap<>();
		jsonParsers.put(Chat.class.getName(), new ParseChat());
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") int id) {
    	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String json) {
    	Gson gson = new Gson();
    	ChatFile chatfile = gson.fromJson(json, ChatFile.class);
        ChatFileHandler chatFileHandler = new ChatFileHandler();
        
        Chat chat = (Chat) chatFileHandler.handle(chatfile);
        IParseObjectToJson parser = jsonParsers.get(chat.getClass().getName());
        String jsonResult = parser.parse(chat);
        return jsonResult;
    }
    
    @Override
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @DELETE
    @Path("/")
    public Response delete(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
