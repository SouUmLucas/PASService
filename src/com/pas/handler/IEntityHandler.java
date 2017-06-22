package com.pas.handler;

import com.pas.domain.Entity;

public interface IEntityHandler {
	public Entity handle(Entity entity);
	public Entity handle(Entity entity, String action);
}
