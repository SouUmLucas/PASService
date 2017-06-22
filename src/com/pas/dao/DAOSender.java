package com.pas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.pas.domain.Entity;
import com.pas.domain.Sender;

public class DAOSender implements IDAO {

	@Override
	public Entity select(Entity entDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity insert(Entity entDominio) {
		Connection conn;
        Sender sender = (Sender) entDominio;

        try {
            conn = BDConnection.getConnection();
            String sql = "INSERT INTO senders (name, fk_chat) VALUES (?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sender.getName());
            ps.setInt(2, sender.getChat().getId());

            if(ps.executeUpdate() > 0) {
                ResultSet generatedKey = ps.getGeneratedKeys();
                if (generatedKey.next()) {
                    sender.setId(generatedKey.getInt(1));
                }
            }

            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sender;
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
