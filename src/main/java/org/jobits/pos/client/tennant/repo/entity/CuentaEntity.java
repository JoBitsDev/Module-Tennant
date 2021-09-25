/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = CuentaEntity.class)
@Entity
@Table(name = "cuenta", schema = "tennant")
@NamedQueries({
    @NamedQuery(name = "CuentaEntity.findAll", query = "SELECT c FROM CuentaEntity c"),
    @NamedQuery(name = "CuentaEntity.findById", query = "SELECT c FROM CuentaEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CuentaEntity.findByUsuario", query = "SELECT c FROM CuentaEntity c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "CuentaEntity.findByContrasena", query = "SELECT c FROM CuentaEntity c WHERE c.contrasena = :contrasena"),
    @NamedQuery(name = "CuentaEntity.findByEstado", query = "SELECT c FROM CuentaEntity c WHERE c.estado = :estado")})
public class CuentaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<BaseDatosEntity> baseDatos;

    public CuentaEntity() {
    }

    public CuentaEntity(Integer id) {
        this.id = id;
    }

    public CuentaEntity(Integer id, String usuario, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
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
        this.estado = estado;
    }

    public List<BaseDatosEntity> getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(List<BaseDatosEntity> baseDatos) {
        this.baseDatos = baseDatos;
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
        if (!(object instanceof CuentaEntity)) {
            return false;
        }
        CuentaEntity other = (CuentaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jobits.pos.client.tennant.repo.entity.Cuenta[ id=" + id + " ]";
    }

}
