/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pas.facade;

import java.util.ArrayList;

import com.pas.domain.Entity;

/**
 *
 * @author lucas
 */
public interface IFacade<T> {
    public Entity insert(Entity entity);
    public Entity update(Entity entity);
    public Entity delete(Entity entity);
    public Entity select(Entity entity);
}
