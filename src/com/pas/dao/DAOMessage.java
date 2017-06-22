package com.pas.dao;

import java.sql.*;
import java.util.ArrayList;

import com.pas.domain.Entity;
import com.pas.domain.Message;

/**
 * Created by lucas on 24/05/2017.
 */
public class DAOMessage implements IDAO {
    public Entity select(Entity _message) {
    	Message message = (Message) _message;
        try {
			Connection conn = BDConnection.getConnection();
			String sql = "SELECT id, message_content FROM messages WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, message.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				message.setId(rs.getInt(1));
				message.setMessageContent(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return message;
    }
    
    public ArrayList<com.pas.domain.analysis.Message> GetMessagesForAnalysis() {
		ArrayList<com.pas.domain.analysis.Message> messages = new ArrayList<>();
		
		try {
			Connection conn = BDConnection.getConnection();
			String sql = "SELECT senders.name, timestamp FROM messages LEFT JOIN senders ON senders.id = messages.fk_sender";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				com.pas.domain.analysis.Message message = new com.pas.domain.analysis.Message();
				message.setSender(rs.getString(1));
				message.setTimestamp(rs.getTimestamp(2));
				messages.add(message);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return messages;
	}

    public int selectMesseageId(String message) {
        int id = 0;
        try {
            Connection conn = BDConnection.getConnection();
            String sql = "SELECT id FROM messages WHERE message_content = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, message);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }

            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public ArrayList<Message> insert(ArrayList<Message> messages) {
        Connection conn;
        ArrayList<Message> newMessages = new ArrayList<>();
        try {
            conn = BDConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO messages (fk_chat, fk_sender, timestamp, message_content) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for(Message message : messages) {
                ps.setInt(1, message.getChat().getId());
                ps.setInt(2, message.getSender().getId());
                ps.setTimestamp(3, new java.sql.Timestamp(message.getTimestamp().getTime()));
                ps.setString(4, message.getMessageContent());
                
                if(ps.executeUpdate() > 0) {
                	ResultSet generatedKey = ps.getGeneratedKeys();
                	if(generatedKey.next()) {
                		message.setId(generatedKey.getInt(1));
                	}
                }
                newMessages.add(message);
            }

            conn.commit();
            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return newMessages;
    }

	@Override
	public Entity insert(Entity entDominio) {
		Message message = (Message) entDominio;
		
		Connection conn;
        try {
            conn = BDConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO messages (message_content) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, message.getMessageContent());
            
            if(ps.executeUpdate() > 0) {
            	ResultSet generatedKey = ps.getGeneratedKeys();
            	if(generatedKey.next()) {
            		message.setId(generatedKey.getInt(1));
            	}
            }

            conn.commit();
            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return message;
	}

	@Override
	public void update(Entity entDominio) {
		Message message = (Message) entDominio;
		Connection conn;
        try {
            conn = BDConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "UPDATE messages SET message_content = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, message.getMessageContent());
            ps.setInt(2, message.getId());
            
            if(ps.executeUpdate() > 0) {
            	ResultSet generatedKey = ps.getGeneratedKeys();
            	if(generatedKey.next()) {
            		message.setId(generatedKey.getInt(1));
            	}
            }

            conn.commit();
            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void delete(Entity entDominio) {
		Message message = (Message) entDominio;
		Connection conn;
        try {
            conn = BDConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "DELETE FROM messages WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, message.getId());
            ps.executeUpdate();
            conn.commit();
            conn.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public ArrayList<Message> selectAll() {
		ArrayList<Message> messages = new ArrayList<>();
		
		try {
			Connection conn = BDConnection.getConnection();
			String sql = "SELECT id, message_content FROM messages";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getInt(1));
				message.setMessageContent(rs.getString(2));
				messages.add(message);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return messages;
	}
}
