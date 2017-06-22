package com.pas.dao.analysis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pas.dao.BDConnection;
import com.pas.dao.IDAO;
import com.pas.domain.Entity;
import com.pas.domain.analysis.*;

public class DAOMessageSender implements IDAO {

	@Override
	public Entity select(Entity entDominio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<MessageSender> selectAll() {
		
		ArrayList<MessageSender> messageSenders = new ArrayList<>();
		
		try {
			Connection conn = BDConnection.getConnection();
			String sql = "SELECT id, name FROM senders";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MessageSender messageSender = new MessageSender();
				messageSender.setId(rs.getInt(1));
				messageSender.setName(rs.getString(2));
				
				messageSenders.add(messageSender);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return messageSenders;
	}
	
	@Override
	public Entity insert(Entity entDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Entity entDominio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Entity entDominio) {
		// TODO Auto-generated method stub
		
	}

}
