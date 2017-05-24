package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Entity;
import model.TrainingFileReference;

public class DAOTrainingFileReference<T> implements IDAO {
	@Override
	public T select(Entity entDominio) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity insert(Entity entDominio) throws SQLException {
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return entDominio;
	}

	@Override
	public void update(Entity entDominio) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Entity entDominio) throws SQLException {
		// TODO Auto-generated method stub
	}

}
