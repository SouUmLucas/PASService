package com.pas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pas.domain.Entity;
import com.pas.domain.MessageClassification;

/**
 * Created by lucas on 24/05/2017.
 */
public class DAOMessageClassification implements IDAO {
    public Entity select(Entity entDominio) {
        return null;
    }

    public ArrayList<MessageClassification> insert(ArrayList<MessageClassification> messageClassifications) {
        Connection conn;
        ArrayList<MessageClassification> newMessagesClassifications = new ArrayList<>();

        try {
            conn = BDConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO messages_classification (fk_message, classification, accuracy) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for(MessageClassification messageClassification : messageClassifications) {
                ps.setInt(1, messageClassification.getMessage().getId());
                ps.setString(2, messageClassification.getClassification());
                ps.setDouble(3, messageClassification.getAccuracy());
                
                if(ps.executeUpdate() > 0) {
                	ResultSet generatedKey = ps.getGeneratedKeys();
                	if(generatedKey.next()) {
                		messageClassification.setId(generatedKey.getInt(1));
                	}
                }
                newMessagesClassifications.add(messageClassification);
            }

            conn.commit();
            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return newMessagesClassifications;
    }

    public ArrayList<MessageClassification> update(ArrayList<MessageClassification> messageClassifications) {
    	Connection conn;
        ArrayList<MessageClassification> newMessagesClassifications = new ArrayList<>();

        try {
            conn = BDConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "UPDATE messages_classification SET classification = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for(MessageClassification messageClassification : messageClassifications) {
                ps.setString(1, messageClassification.getClassification());
                ps.setInt(2, messageClassification.getId());
                
                if(ps.executeUpdate() > 0) {
                	ResultSet generatedKey = ps.getGeneratedKeys();
                	if(generatedKey.next()) {
                		messageClassification.setId(generatedKey.getInt(1));
                	}
                }
                newMessagesClassifications.add(messageClassification);
            }

            conn.commit();
            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return newMessagesClassifications;
    }
    
    @Override
    public void delete(Entity entDominio) {

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
}
