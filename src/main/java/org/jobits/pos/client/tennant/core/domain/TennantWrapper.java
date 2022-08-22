/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.domain;

import org.jobits.db.core.domain.ConexionPropertiesModel;
import org.jobits.db.core.domain.TipoConexion;

/**
 * FirstDream
 *
 * @author Jorge
 *
 */
public class TennantWrapper {

    private Token tennantToken;
    private ConexionPropertiesModel tennantEmf;

    public TennantWrapper(Token tennantToken, ConexionPropertiesModel propertiesModel) {
        this.tennantToken = tennantToken;
        this.tennantEmf = propertiesModel;
    }

    public TennantWrapper(Token tennantToken, BaseDatos c) {
        this.tennantToken = tennantToken;
        c.setToken(tennantToken);
        this.tennantEmf = new ConexionPropertiesModel() {
            @Override
            public String getContrasena() {
                return c.getContrasena();
            }

            @Override
            public String getDriver() {
                return c.getDriver();
            }

            @Override
            public String getNombreUbicacion() {
                return tennantToken.getToken();
            }

            @Override
            public TipoConexion getTipoUbicacion() {
                return TipoConexion.MASTER;//TODO: fix
            }

            @Override
            public String getUrl() {
                return c.getUrl();
            }

            @Override
            public String getUsuario() {
                return c.getUsuario();
            }

            //equals using getters
            @Override
            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final ConexionPropertiesModel other = (ConexionPropertiesModel) obj;
                if ((this.getContrasena() == null) ? (other.getContrasena() != null) : !this.getContrasena().equals(other.getContrasena())) {
                    return false;
                }
                if ((this.getDriver() == null) ? (other.getDriver() != null) : !this.getDriver().equals(other.getDriver())) {
                    return false;
                }
                if ((this.getNombreUbicacion() == null) ? (other.getNombreUbicacion() != null) : !this.getNombreUbicacion().equals(other.getNombreUbicacion())) {
                    return false;
                }
                if (this.getTipoUbicacion() != other.getTipoUbicacion()) {
                    return false;
                }
                if ((this.getUrl() == null) ? (other.getUrl() != null) : !this.getUrl().equals(other.getUrl())) {
                    return false;
                }
                if ((this.getUsuario() == null) ? (other.getUsuario() != null) : !this.getUsuario().equals(other.getUsuario())) {
                    return false;
                }
                return true;
            }
        };
    }

    public Token getTennantToken() {
        return tennantToken;
    }

    public void setTennantToken(Token tennantToken) {
        this.tennantToken = tennantToken;
    }

    public ConexionPropertiesModel getTennantProperties() {
        return tennantEmf;
    }

    public void setTennantProperties(ConexionPropertiesModel tennantEmf) {
        this.tennantEmf = tennantEmf;
    }

}
