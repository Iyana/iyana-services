/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.iyana.service.locator;

import javax.servlet.http.HttpServletRequest;
import uk.co.iyana.commons.usererror.ErrorContext;
import uk.co.iyana.service.context.IServiceContext;
import uk.co.iyana.service.context.ServiceContextFactory;

/**
 *
 * @author fgyara
 */
public class ServiceLocatorFactory {
    private ServiceLocatorFactory() {
    }
    
    public static ServiceLocator getServiceLocator(String errorContextName, HttpServletRequest request) {
        ServiceLocator locator = new ServiceLocator();
        
        IServiceContext context = ServiceContextFactory.createContext(new ErrorContext(errorContextName), request, locator);
        locator.setContext(context);
        
        return locator;
    }   
    
    public static ServiceLocator getServiceLocator(String errorContextName, String userName) {
        ServiceLocator locator = new ServiceLocator();
        
        IServiceContext context = ServiceContextFactory.createContext(new ErrorContext(errorContextName), userName, locator);
        locator.setContext(context);
        
        return locator;
    }   
    
    public static ServiceLocator getServiceLocator(String errorContextName) {
        ServiceLocator locator = new ServiceLocator();
        
        IServiceContext context = ServiceContextFactory.createContext(new ErrorContext(errorContextName), locator);
        locator.setContext(context);
        
        return locator;
    }   
    
}
