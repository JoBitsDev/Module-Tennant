/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.repo.impl;

import org.jobits.pos.client.tennant.core.domain.Token;
import org.jobits.pos.client.tennant.core.repo.TokenRepo;
import org.jobits.pos.client.tennant.repo.entity.TokenEntity;

public class TokenRepoImpl extends AbstractRepo<Token, TokenEntity>
        implements TokenRepo {

    public TokenRepoImpl() {
        super(Token.class, TokenEntity.class);
    }

}
