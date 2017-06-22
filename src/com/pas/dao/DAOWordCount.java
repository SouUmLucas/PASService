package com.pas.dao;

import java.sql.*;
import java.util.ArrayList;

import com.pas.domain.Entity;
import com.pas.domain.WordCount;

public class DAOWordCount {

    public WordCount select(Entity entDominio) {
        return null;
    }

    public ArrayList<WordCount> select() {
        Connection conn;
        ArrayList<WordCount> wordCounts = new ArrayList<>();

        try {
            conn = BDConnection.getConnection();
            String sql = "SELECT word, count FROM word_count;";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (!rs.isBeforeFirst()) {
                // if there aren't any data
                return wordCounts;
            }

            while(rs.next()) {
                WordCount wordCount = new WordCount();
                wordCount.setWord(rs.getString(1));
                wordCount.setCount(rs.getInt(2));
                wordCount.setUpdateble(true);

                wordCounts.add(wordCount);
            }

            conn.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return wordCounts;
    }

    public WordCount insert(Entity entDominio) {
        Connection conn;
        WordCount wordCount = (WordCount) entDominio;
        try {
            conn = BDConnection.getConnection();

            String sql = "INSERT INTO word_count (word, count) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, wordCount.getWord());
            ps.setInt(2, wordCount.getCount());

            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return wordCount;
    }

    public void update(Entity entDominio) {

    }

    public void delete(Entity entDominio) {

    }

}
