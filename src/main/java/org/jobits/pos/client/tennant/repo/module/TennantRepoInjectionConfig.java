/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.jobits.pos.client.tennant.core.repo.BaseDatosRepo;
import org.jobits.pos.client.tennant.core.repo.CuentaRepo;
import org.jobits.pos.client.tennant.core.repo.TokenRepo;
import org.jobits.pos.client.tennant.repo.impl.BaseDatosRepoImpl;
import org.jobits.pos.client.tennant.repo.impl.CuentaRepoImpl;
import org.jobits.pos.client.tennant.repo.impl.TokenRepoImpl;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
class TennantRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(CuentaRepo.class).to(CuentaRepoImpl.class).in(Singleton.class);
        bind(BaseDatosRepo.class).to(BaseDatosRepoImpl.class).in(Singleton.class);
        bind(TokenRepo.class).to(TokenRepoImpl.class).in(Singleton.class);
    }

}
