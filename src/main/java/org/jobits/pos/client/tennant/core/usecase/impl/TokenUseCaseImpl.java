/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.usecase.impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
import org.jobits.pos.client.tennant.core.domain.Token;
import org.jobits.pos.client.tennant.core.module.TennantCoreModule;
import org.jobits.pos.client.tennant.core.repo.TokenRepo;
import org.jobits.pos.client.tennant.core.usecase.TokenUseCase;

public class TokenUseCaseImpl extends DefaultCRUDUseCase<Token>
        implements TokenUseCase {

    public TokenUseCaseImpl() {
        setRepo(TennantCoreModule.getInstance().getImplementation(TokenRepo.class));
    }

    @Override
    public Token generateToken() {
        Token newToken = new Token();
        newToken.setToken(generateStringToken());
        return create(newToken);
    }

    @Override
    public Token generateToken(LocalDateTime ultil) {
        var ret = generateToken();
        ret.setExpira(ultil);
        return edit(ret);
    }

    @Override
    public Token refreshToken(int tokenId, LocalDateTime until) {
        var tmp = generateToken();
        var ret = findBy(tokenId);
        ret.setExpira(tmp.getExpira());
        ret.setToken(tmp.getToken());
        return edit(ret);
    }

    private String generateStringToken() {
        Random random = new SecureRandom();
        return new BigInteger(121, random).toString(32);
    }

}
