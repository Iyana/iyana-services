package uk.co.iyana.service;

import uk.co.iyana.service.context.IServiceContext;

/**
 *
 * @author fgyara
 */

//
// The interface that all services must implement
//
public interface IService {

    public void setServiceContext(IServiceContext serviceContext);
    
}
