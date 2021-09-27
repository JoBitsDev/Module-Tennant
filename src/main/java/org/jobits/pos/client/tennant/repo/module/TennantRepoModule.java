/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.exceptions.AlreadyInitModule;
import com.root101.clean.core.exceptions.NotInitModule;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jobits.db.core.module.DataVersionControlModule;
import org.jobits.db.core.usecase.UbicacionConexionHandler;
import org.jobits.db.pool.ConnectionPoolHandler;
import org.jobits.db.versioncontrol.DataVersionControlHandler;
import org.jobits.db.versioncontrol.DataVersionControlService;
import org.jobits.pos.client.tennant.service.DataBaseUbicacionService;
import org.jobits.pos.client.tennant.service.DatabaseRepository;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class TennantRepoModule extends DefaultAbstractModule {

    public static final String MODULE_NAME = "Tennant Repo Module";

    private final Injector inj = Guice.createInjector(new TennantRepoInjectionConfig());

    private static TennantRepoModule INSTANCE;

    private TennantRepoModule() {
        registerResources();
        registerConnectionPool();
        //org.jobits.db.core.usecase.UbicacionConexionHandler.registerUbicacionConexionService(DataBaseUbicacionService.getInstance());

    }

    public static TennantRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NotInitModule(ResourceHandler.getString("com.jobits.pos.reservarepo.name"));
        }
        return INSTANCE;
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @return
     * @Deprecated
     */
    public static TennantRepoModule init(AbstractModule... modules) {
        if (INSTANCE != null) {
            throw new AlreadyInitModule(ResourceHandler.getString("com.jobits.pos.reservarepo.name"));
        }
        INSTANCE = new TennantRepoModule();
        for (AbstractModule m : modules) {
            INSTANCE.registerModule(m);
        }
        return getInstance();
    }

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    private void registerConnectionPool() {
        DataVersionControlModule.init();
        String schema = ResourceHandler.getString("com.jobits.pos.tennant.repo.db.shema");
        String dir = "org/jobits/pos/tennant/sql";
        ConnectionPoolHandler.registerConnectionPoolService(getModuleName(), new DatabaseRepository());
        DataVersionControlHandler.registerDataVersionControlService(DataVersionControlService.from(MODULE_NAME, dir, schema));
        UbicacionConexionHandler.registerUbicacionConexionService(DataBaseUbicacionService.getInstance());
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    private void registerResources() {
        try {
            ResourceHandler.registerExternal("/tennant_module");
        } catch (Exception ex) {
            ResourceHandler.registerInternal("tennant_module");
            Logger.getLogger(TennantRepoModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
