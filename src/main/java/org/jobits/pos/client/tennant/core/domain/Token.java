/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.domain;

import com.root101.clean.core.domain.services.ResourceHandler;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * FirstDream
 *
 * @author Jorge
 *
 */
public class Token {

    private Integer id;
    private String token;
    private LocalDateTime expira;

    public Token() {
        long minutes = Long.valueOf(ResourceHandler.getString("org.jobits.pos.client.tennant.rest.domain.defautl_expiration_time"));
        expira = LocalDateTime.now().plusMinutes(minutes);
    }

    public Token(String token) {
        this();
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        if (expira.isBefore(LocalDateTime.now())) {
            token = null;
        }
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAlive() {
        return LocalDateTime.now().isBefore(expira);
    }

    public LocalDateTime getExpira() {
        return expira;
    }

    public void setExpira(LocalDateTime expira) {
        this.expira = expira;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.token);
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
        final Token other = (Token) obj;
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Token{" + "token=" + token + ", expira=" + expira + '}';
    }

}
