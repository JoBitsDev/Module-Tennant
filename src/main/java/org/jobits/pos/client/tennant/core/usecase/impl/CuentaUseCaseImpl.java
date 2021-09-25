/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.usecase.impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import org.jobits.pos.client.tennant.core.domain.Cuenta;
import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
import org.jobits.pos.client.tennant.core.repo.CuentaRepo;
import org.jobits.pos.client.tennant.core.usecase.CuentaUseCase;

public class CuentaUseCaseImpl extends DefaultCRUDUseCase<Cuenta> implements CuentaUseCase {

    public CuentaUseCaseImpl() {
        setRepo(TennantCoreModule.getInstance().getImplementation(CuentaRepo.class));
    }

}
