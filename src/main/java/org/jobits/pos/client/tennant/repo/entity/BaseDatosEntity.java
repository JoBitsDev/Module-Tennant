/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = BaseDatosEntity.class)
@Entity
@Table(name = "base_datos", schema = "tennant")
@NamedQueries({
    @NamedQuery(name = "BaseDatosEntity.findAll", query = "SELECT b FROM BaseDatosEntity b"),
    @NamedQuery(name = "BaseDatosEntity.findById", query = "SELECT b FROM BaseDatosEntity b WHERE b.id = :id"),
    @NamedQuery(name = "BaseDatosEntity.findByNombre", query = "SELECT b FROM BaseDatosEntity b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "BaseDatosEntity.findByUrl", query = "SELECT b FROM BaseDatosEntity b WHERE b.url = :url"),
    @NamedQuery(name = "BaseDatosEntity.findByUsuario", query = "SELECT b FROM BaseDatosEntity b WHERE b.usuario = :usuario"),
    @NamedQuery(name = "BaseDatosEntity.findByContrasena", query = "SELECT b FROM BaseDatosEntity b WHERE b.contrasena = :contrasena"),
    @NamedQuery(name = "BaseDatosEntity.findByDriver", query = "SELECT b FROM BaseDatosEntity b WHERE b.driver = :driver")})
public class BaseDatosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "driver")
    private String driver;
    @JoinColumn(name = "tokenid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TokenEntity token;

    public BaseDatosEntity() {
    }

    public BaseDatosEntity(Integer id) {
        this.id = id;
    }

    public BaseDatosEntity(Integer id, String nombre, String url, String usuario, String contrasena, String driver) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.driver = driver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public TokenEntity getToken() {
        return token;
    }

    public void setToken(TokenEntity token) {
        this.token = token;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
}

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseDatosEntity)) {
            return false;
        }
        BaseDatosEntity other = (BaseDatosEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jobits.pos.client.tennant.repo.entity.BaseDatos[ id=" + id + " ]";
    }

}
