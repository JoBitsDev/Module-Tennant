/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.impl;

import org.jobits.pos.client.tennant.core.domain.BaseDatos;
import org.jobits.pos.client.tennant.core.domain.Token;
import org.jobits.pos.client.tennant.core.repo.BaseDatosRepo;
import org.jobits.pos.client.tennant.core.repo.TokenRepo;
import org.jobits.pos.client.tennant.repo.entity.BaseDatosEntity;
import org.jobits.pos.client.tennant.repo.entity.TokenEntity;

public class BaseDatosRepoImpl extends AbstractRepo<BaseDatos, BaseDatosEntity>
        implements BaseDatosRepo {

    public BaseDatosRepoImpl() {
        super(BaseDatos.class, BaseDatosEntity.class);
    }

}
