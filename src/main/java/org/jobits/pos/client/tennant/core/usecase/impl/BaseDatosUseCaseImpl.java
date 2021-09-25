/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.usecase.impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.List;
import org.jobits.pos.client.tennant.core.domain.BaseDatos;
import org.jobits.pos.client.tennant.core.domain.Token;
import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
import org.jobits.pos.client.tennant.core.repo.BaseDatosRepo;
import org.jobits.pos.client.tennant.core.usecase.BaseDatosUseCase;
import org.jobits.pos.client.tennant.core.usecase.TokenUseCase;
import org.jobits.pos.client.tennant.repo.module.TennantRepoModule;

public class BaseDatosUseCaseImpl extends DefaultCRUDUseCase<BaseDatos>
        implements BaseDatosUseCase {

    private TokenUseCase tokenUseCase = TennantCoreModule.getInstance().getImplementation(TokenUseCase.class);

    public BaseDatosUseCaseImpl() {
        setRepo(TennantCoreModule.getInstance().getImplementation(BaseDatosRepo.class));
    }

    @Override
    public Token createTokenForDataBase(int dataBaseId, LocalDateTime until) {
        BaseDatos bd = findBy(dataBaseId);
        Token tk = tokenUseCase.generateToken(until);
        bd.setToken(tk);
        edit(bd);
        return tk;
    }

    @Override
    public BaseDatos findByToken(String tenantID) {
        for (BaseDatos baseDatos : findAll()) {
            if (baseDatos.getToken() != null) {
                if (baseDatos.getToken().getToken().equals(tenantID)) {
                    return baseDatos;
                }
            }
        }
        return null;
    }

    @Override
    public Token getOrRefreshTokenFor(int idBaseDatos) {
        getRepo().startTransaction();
        BaseDatos bd = findBy(idBaseDatos);
        if (bd != null) {
            if (bd.getToken() != null) {
                if (bd.getToken().isAlive()) {
                    return bd.getToken();
                }
            }
            Token ret = tokenUseCase.generateToken();
            bd.setToken(ret);
            edit(bd);
            getRepo().commitTransaction();
            return ret;
        }
        throw new NullPointerException("No existe la base de datos en el sistema con id" + idBaseDatos);
    }

}
