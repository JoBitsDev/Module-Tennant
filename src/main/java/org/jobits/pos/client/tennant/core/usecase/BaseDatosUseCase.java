/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.usecase;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.time.LocalDateTime;
import org.jobits.pos.client.tennant.core.domain.BaseDatos;
import org.jobits.pos.client.tennant.core.domain.Token;

/**
 *
 * @author Jorge
 */
public interface BaseDatosUseCase extends CRUDUseCase<BaseDatos> {

    public BaseDatos findByToken(String tenantID);

    /**
     * 
     * @param dataBaseId
     * @param until Dejarlo null si se quiere valor por defecto
     * @return el token creado
     */
    public Token createTokenForDataBase(int dataBaseId, LocalDateTime until);

    public Token getOrRefreshTokenFor(int idBaseDatos);

}
