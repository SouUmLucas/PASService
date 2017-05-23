package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Entity;
import model.WordCount;

public class DAOWordCount<T> implements IDAO {

    @Override
    public T select(Entity entDominio) throws SQLException {
        return null;
    }

    @Override
    public void insert(Entity entDominio) throws SQLException {
        Connection conn;
        try {
            conn = BDConnection.getConnection();
            WordCount wordCount = (WordCount) entDominio;
            String sql = "INSERT INTO word_count (word, count) VALUES (?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, wordCount.getWord());
            ps.setInt(2, wordCount.getCount());

            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Entity entDominio) throws SQLException {

    }

    @Override
    public void delete(Entity entDominio) throws SQLException {

    }

}
