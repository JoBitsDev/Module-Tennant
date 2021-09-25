/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.root101.clean.core.domain.services.ResourceHandler;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 * FirstDream
 *
 * @author Jorge
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cuenta {

    private Integer id;
    @NotNull
    private String usuario;
    @NotNull
    private String contrasena;
    private String estado;
    private List<BaseDatos> baseDatos;
    //TODO: lastseen and created

    public Cuenta() {
        setEstado(EstadoCuenta.ACTIVA.toString());
    }

    public Cuenta(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        setEstado(EstadoCuenta.ACTIVA.toString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = validateEstado(estado);
    }

    public Boolean isActiva() {
        return true;
    }

    public List<BaseDatos> getBaseDatos() {
        return baseDatos;
    }

    public BaseDatos addBaseDatos(BaseDatos newBaseDatos) {
        if (getBaseDatos().contains(newBaseDatos)) {
            throw new IllegalArgumentException("Base de datos ya existe en esta cuenta");
        }
        getBaseDatos().add(newBaseDatos);
        return newBaseDatos;
    }

    public void setBaseDatos(List<BaseDatos> baseDatos) {
        this.baseDatos = baseDatos;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + ", estado=" + estado + ", baseDatos=" + baseDatos + '}';
    }

    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.contrasena);
        hash = 89 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return true;
    }

    private String validateEstado(String estado) {
        for (EstadoCuenta v : EstadoCuenta.values()) {
            if (estado.equals(v.toString())) {
                return estado;
            }
        }
        throw new IllegalArgumentException(ResourceHandler.getString("msg.org.jobits.pos.tennant.core.domain.estado_no_valido"));
    }
}
