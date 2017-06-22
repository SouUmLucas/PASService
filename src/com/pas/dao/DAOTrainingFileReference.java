package com.pas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pas.domain.Entity;
import com.pas.domain.TrainingFileReference;

public class DAOTrainingFileReference implements IDAO {
	@Override
	public Entity select(Entity entDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity insert(Entity entDominio) {
		Connection conn;
		try {
			conn = BDConnection.getConnection();
			TrainingFileReference trainingFile = (TrainingFileReference) entDominio;
			String sql = "INSERT INTO training_file_references (filename, filepath) VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, trainingFile.getFilename());
			ps.setString(2, trainingFile.getFilepath());
			
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entDominio;
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
