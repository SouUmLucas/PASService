package dao;

import model.ChatFileReference;
import model.ClassificationEntity;
import model.Entity;

import java.sql.*;

/**
 * Created by lucas on 24/05/2017.
 */
public class DAOChatFileReference<T> implements IDAO {

    @Override
    public T select(Entity entDominio) throws SQLException {
        return null;
    }

    @Override
    public Entity insert(Entity entDominio) throws SQLException {
        Connection conn;
        ChatFileReference chatFileReference = (ChatFileReference) entDominio;

        try {
            conn = BDConnection.getConnection();
            String sql = "INSERT INTO chat_file_references (filename, filepath) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, chatFileReference.getFilename());
            ps.setString(2, chatFileReference.getFilepath());

            // returns the new id
            if (ps.executeUpdate() > 0) {
                ResultSet generatedKey = ps.getGeneratedKeys();
                if (generatedKey.next()) {
                    chatFileReference.setId(generatedKey.getInt(1));
                }
            }

            conn.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return chatFileReference;
    }

    @Override
    public void update(Entity entDominio) throws SQLException {

    }

    @Override
    public void delete(Entity entDominio) throws SQLException {

    }
}
