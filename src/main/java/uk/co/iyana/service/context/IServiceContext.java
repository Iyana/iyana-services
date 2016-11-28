/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.iyana.service.context;

import uk.co.iyana.commons.usererror.ErrorContext;
import uk.co.iyana.service.locator.ServiceLocator;

/**
 *
 * @author fgyara
 */
public interface IServiceContext {

    public void setUserName(String name);
    public String getUserName();
    
    public void setServiceLocator(ServiceLocator serviceLocator);
    public ServiceLocator getServiceLocator();
    
    public void setErrorContext(ErrorContext context);
    public ErrorContext getErrorContext();
    
    public void pushErrorContext(String contextName, Integer index);
    public void pushErrorContext(String contextName);
    public void pushErrorContext(Integer index);
    
    public void popErrorContext();
    
}
