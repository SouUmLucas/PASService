package dao;

import model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 * Created by lucas on 24/05/2017.
 */
public class DAOMessage {
    public Message select(Message message) throws SQLException {
        return null;
    }

    public Message insert(Message message) throws SQLException {
        return null;
    }

    public void insert(ArrayList<Message> messages) throws SQLException {
        Connection conn;

        try {
            conn = BDConnection.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO messages (fk_chat, message_content) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for(Message message : messages) {
                ps.setInt(1, message.getChat().getId());
                ps.setString(2, message.getMessageContent());
                ps.executeUpdate();
            }

            conn.commit();
            conn.close();
            ps.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(Message message) throws SQLException {

    }

    public void delete(Message message) throws SQLException {

    }
}
