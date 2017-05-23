package dao;

import java.sql.SQLException;

import model.Entity;

public interface IDAO<T> {
	public T select(Entity entDominio) throws SQLException;
	public void insert(Entity entDominio) throws SQLException;
	public void update(Entity entDominio) throws SQLException;
	public void delete(Entity entDominio) throws SQLException;
}
