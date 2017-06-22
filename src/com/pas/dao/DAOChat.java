package com.pas.dao;

import java.sql.*;

import com.pas.domain.Chat;
import com.pas.domain.Entity;

/**
 * Created by lucas on 24/05/2017.
 */
public class DAOChat implements IDAO {
    @Override
    public Entity select(Entity entDominio) {
        return null;
    }

    @Override
    public Entity insert(Entity entDominio) {
        Connection conn;
        Chat chat = (Chat) entDominio;

        try {
            conn = BDConnection.getConnection();
            String sql = "INSERT INTO chats (alias) VALUES (?);";

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, chat.getAlias());

            if(ps.executeUpdate() > 0) {
                ResultSet generatedKey = ps.getGeneratedKeys();
                if (generatedKey.next()) {
                    chat.setId(generatedKey.getInt(1));
                }
            }

            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return chat;
    }

    @Override
    public void update(Entity entDominio) {

    }

    @Override
    public void delete(Entity entDominio) {

    }
}
