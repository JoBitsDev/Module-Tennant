/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.core.usecase;

import com.root101.clean.core.app.usecase.AbstractUseCase;
import java.time.Duration;
import java.time.LocalDateTime;
import org.jobits.pos.client.tennant.core.domain.Token;

/**
 *
 * @author Jorge
 */
public interface TokenUseCase extends AbstractUseCase{
    
    public Token generateToken();
    
    public Token generateToken(LocalDateTime ultil);
    
    public Token refreshToken(int tokenId, LocalDateTime until);
}
