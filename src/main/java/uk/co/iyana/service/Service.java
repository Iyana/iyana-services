/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.iyana.service;

import uk.co.iyana.service.context.IServiceContext;
import uk.co.iyana.service.locator.ServiceLocator;

/**
 *
 * @author fgyara
 */
public class Service implements IService {
    
    private IServiceContext serviceContext;

    @Override
    public void setServiceContext(IServiceContext serviceContext) {
        this.serviceContext = serviceContext;
    }
    
    public IServiceContext getServiceContext() {
        return this.serviceContext;
    }
    
    // convenience
    public ServiceLocator getServiceLocator() {
        return this.serviceContext.getServiceLocator();
    }
}
