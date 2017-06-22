package com.pas.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.pas.domain.analysis.MessageAnalysis;
import com.pas.handler.analysis.MessageAnalysisHandler;

@Path("/api/analysis")
public class AnalysisService implements IService {

	@Override
	@GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String get(@PathParam("id") int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GET
    @Path("/messages")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String get() {
		MessageAnalysisHandler handler = new MessageAnalysisHandler();
		MessageAnalysis messageAnalysis = (MessageAnalysis) handler.handle(new MessageAnalysis());
		
		Gson gson = new Gson();
		String jsonResult = gson.toJson(messageAnalysis);
		return jsonResult;
	}

	@Override
	public String create(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(String json) {
		// TODO Auto-generated method stub
		return null;
	}

}
