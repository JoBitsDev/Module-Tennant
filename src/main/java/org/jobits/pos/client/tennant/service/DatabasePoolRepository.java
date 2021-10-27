/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.service;

import com.root101.clean.core.domain.services.ResourceHandler;
import org.jobits.pos.client.tennant.core.domain.BaseDatos;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jobits.db.core.domain.ConexionPropertiesModel;
import org.jobits.db.core.domain.TipoConexion;
import org.jobits.db.pool.ConnectionPoolService;

/**
 * FirstDream
 *
 * @author Jorge
 *
 */
public class DatabasePoolRepository implements ConnectionPoolService {

    private static final String PU_DEFAULT_NAME = "pasarela_loggeo";
    private static final HashMap<String, String> PU_DEFAULT_PROPERTIES = getDefaultProperties();
    private static EntityManagerFactory DEFAULT_EMF;
    private EntityManager currentConnection;

    @Override
    public EntityManagerFactory getEMF() {
        if (DEFAULT_EMF == null) {
            DEFAULT_EMF = Persistence.createEntityManagerFactory(PU_DEFAULT_NAME, PU_DEFAULT_PROPERTIES);
        }
        return DEFAULT_EMF;
    }

    @Override
    public EntityManager getCurrentConnection() {
        if (currentConnection == null) {
            currentConnection = getEMF().createEntityManager();
        }
        if (!currentConnection.isOpen()) {
            currentConnection = getEMF().createEntityManager();
        } else {
            getEMF().getCache().evictAll();
            currentConnection = getEMF().createEntityManager();
        }
        return currentConnection;
    }

    @Override
    public ConexionPropertiesModel getCurrentUbicacion() {
        return getDefautlUbicacion();
    }

    @Override
    public EntityManagerFactory getEmfFrom(ConexionPropertiesModel connectionsProperties) {
        return getEMF();
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public void resetConnection() {
        if (currentConnection != null) {
            getEMF().getCache().evictAll();
            currentConnection.close();
            currentConnection = null;
        }
    }

    public static EntityManagerFactory getFactoryFrom(BaseDatos cuenta) {
        return Persistence.createEntityManagerFactory(PU_DEFAULT_NAME, getPropertiesFrom(cuenta));
    }

    private static HashMap<String, String> getDefaultProperties() {
        HashMap<String, String> ret = new HashMap<>();
        ret.put(PersistenceProperties.URL.getName(), ResourceHandler.getString("com.jobits.pos.tennant.repo.db.url"));
        ret.put(PersistenceProperties.USER.getName(), ResourceHandler.getString("com.jobits.pos.tennant.repo.db.user"));
        ret.put(PersistenceProperties.PASSWORD.getName(), ResourceHandler.getString("com.jobits.pos.tennant.repo.db.pass"));
        ret.put(PersistenceProperties.DRIVER.getName(), ResourceHandler.getString("com.jobits.pos.tennant.repo.db.driver"));
        return ret;
    }

    private static Map getPropertiesFrom(BaseDatos baseDatos) {
        HashMap<String, String> ret = new HashMap<>();
        ret.put(PersistenceProperties.URL.getName(), baseDatos.getUrl());
        ret.put(PersistenceProperties.USER.getName(), baseDatos.getUsuario());
        ret.put(PersistenceProperties.PASSWORD.getName(), baseDatos.getContrasena());
        ret.put(PersistenceProperties.DRIVER.getName(), baseDatos.getDriver());
        return ret;
    }

    public static ConexionPropertiesModel getDefautlUbicacion() {

        return new ConexionPropertiesModel() {
            @Override
            public String getContrasena() {
                return PU_DEFAULT_PROPERTIES.get(PersistenceProperties.PASSWORD.getName());
            }

            @Override
            public String getDriver() {
                return PU_DEFAULT_PROPERTIES.get(PersistenceProperties.DRIVER.getName());
            }

            @Override
            public String getNombreUbicacion() {
                return "DEFAULT";
            }

            @Override
            public TipoConexion getTipoUbicacion() {
                return TipoConexion.MASTER;//TODO: fix
            }

            @Override
            public String getUrl() {
                return PU_DEFAULT_PROPERTIES.get(PersistenceProperties.URL.getName());
            }

            @Override
            public String getUsuario() {
                return PU_DEFAULT_PROPERTIES.get(PersistenceProperties.USER.getName());
            }
        };
    }

}
