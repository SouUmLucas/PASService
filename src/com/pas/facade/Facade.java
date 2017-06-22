/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pas.facade;

import com.pas.dao.DAOChat;
import com.pas.dao.DAOTrainingFileReference;
import com.pas.dao.IDAO;
import com.pas.domain.Chat;
import com.pas.domain.Entity;
import com.pas.domain.Message;
import com.pas.domain.TrainingFileReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucas
 */
public class Facade implements IFacade {
    private Map<String, IDAO> daos;
    
    public Facade() {
        daos = new HashMap<String, IDAO>();
        daos.put(Chat.class.getName(), new DAOChat());
        daos.put(TrainingFileReference.class.getName(), new DAOTrainingFileReference());
        
    }

    @Override
    public Entity insert(Entity entity) {
        IDAO dao = daos.get(entity.getClass().getName());
        return dao.insert(entity);
    }
    
    @Override
    public Entity update(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity delete(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entity select(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
