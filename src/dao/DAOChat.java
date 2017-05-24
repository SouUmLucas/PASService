package dao;

import model.Chat;
import model.Entity;

import java.sql.*;

/**
 * Created by lucas on 24/05/2017.
 */
public class DAOChat<T> implements IDAO {
    @Override
    public Object select(Entity entDominio) throws SQLException {
        return null;
    }

    @Override
    public Entity insert(Entity entDominio) throws SQLException {
        Connection conn;
        Chat chat = (Chat) entDominio;

        try {
            conn = BDConnection.getConnection();
            String sql = "INSERT INTO chats (alias, fk_chatfile_reference) VALUES (?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, chat.getAlias());
            ps.setInt(2, chat.getChatFileReference().getId());

            if(ps.executeUpdate() > 0) {
                ResultSet generatedKey = ps.getGeneratedKeys();
                if (generatedKey.next()) {
                    chat.setId(generatedKey.getInt(1));
                }
            }

            conn.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return chat;
    }

    @Override
    public void update(Entity entDominio) throws SQLException {

    }

    @Override
    public void delete(Entity entDominio) throws SQLException {

    }
}
