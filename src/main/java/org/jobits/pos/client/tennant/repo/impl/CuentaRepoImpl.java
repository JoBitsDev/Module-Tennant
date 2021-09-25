/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.impl;

import org.jobits.pos.client.tennant.core.domain.Cuenta;
import org.jobits.pos.client.tennant.core.repo.CuentaRepo;
import org.jobits.pos.client.tennant.repo.entity.CuentaEntity;

public class CuentaRepoImpl extends AbstractRepo<Cuenta, CuentaEntity>
        implements CuentaRepo {

    public CuentaRepoImpl() {
        super(Cuenta.class, CuentaEntity.class);
    }

}
