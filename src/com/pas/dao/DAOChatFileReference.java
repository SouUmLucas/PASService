package com.pas.dao;

import java.sql.*;

import com.pas.domain.ChatFile;
import com.pas.domain.Entity;

/**
 * Created by lucas on 24/05/2017.
 */
public class DAOChatFileReference implements IDAO {

    @Override
    public Entity select(Entity entDominio) {
        return null;
    }

    @Override
    public Entity insert(Entity entDominio) {
        Connection conn;
        ChatFile chatFileReference = (ChatFile) entDominio;

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chatFileReference;
    }

    @Override
    public void update(Entity entDominio) {

    }

    @Override
    public void delete(Entity entDominio) {

    }
}
