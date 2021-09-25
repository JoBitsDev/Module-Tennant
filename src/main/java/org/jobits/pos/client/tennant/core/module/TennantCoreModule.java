/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.exceptions.AlreadyInitModule;
import com.root101.clean.core.exceptions.NotInitModule;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class TennantCoreModule extends DefaultAbstractModule {

    public static final String MODULE_NAME = "Tennant Core Module";

    private final Injector inj = Guice.createInjector(new TennantInjectionConfig());

    private static TennantCoreModule INSTANCE;

    public static TennantCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NotInitModule(ResourceHandler.getString("com.jobits.pos.tennant.name"));
        }
        return INSTANCE;
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @param repoModule
     * @return
     * @Deprecated
     */
    public static TennantCoreModule init(AbstractModule... repoModule) {
        if (INSTANCE != null) {
            throw new AlreadyInitModule(ResourceHandler.getString("com.jobits.pos.tennant.name"));
        }
        INSTANCE = new TennantCoreModule();
        for (AbstractModule m : repoModule) {
            INSTANCE.registerModule(m);
        }
        return getInstance();
    }

    private TennantCoreModule() {

    }


    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

}
