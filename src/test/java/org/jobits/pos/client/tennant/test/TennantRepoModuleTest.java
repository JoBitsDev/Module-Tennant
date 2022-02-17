/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.tennant.test;

import com.root101.clean.core.domain.services.ResourceHandler;
import org.jobits.pos.client.tennant.repo.module.TennantRepoModule;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Jorge
 */

public class TennantRepoModuleTest {

    public TennantRepoModuleTest() {
    }

    /**
     * Test of getInstance method, of class TennantRepoModule.
     */
    @Test
    public void testGetInstance() {
        var ret = TennantRepoModule.init();
        System.out.println(ResourceHandler.getString("com.jobits.pos.tennant.repo.db.user"));
    }
  

}
