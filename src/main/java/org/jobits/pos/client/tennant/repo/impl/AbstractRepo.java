/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.impl;

import org.jobits.db.pool.ConnectionPoolHandler;
import org.jobits.db.utils.JpaCRUDRepository;
import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
import org.jobits.pos.client.tennant.repo.module.TennantRepoModule;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public abstract class AbstractRepo<Domain, Entity> extends JpaCRUDRepository<Domain, Entity> {

    public AbstractRepo(Class<Domain> domainClass, Class<Entity> entityClass) {
        super(ConnectionPoolHandler.getConnectionPoolService(TennantRepoModule.getInstance().getModuleName()), domainClass, entityClass);
    }

}
