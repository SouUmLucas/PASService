package com.pas.dao;

import com.pas.domain.Entity;

public interface IDAO {
	public Entity select(Entity entDominio);
	public Entity insert(Entity entDominio);
	public void update(Entity entDominio);
	public void delete(Entity entDominio);
}
