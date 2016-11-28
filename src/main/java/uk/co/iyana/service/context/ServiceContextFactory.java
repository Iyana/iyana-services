/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.iyana.service.context;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import uk.co.iyana.commons.usererror.ErrorContext;
import uk.co.iyana.service.locator.ServiceLocator;

/**
 *
 * @author fgyara
 */
public class ServiceContextFactory {

    public static IServiceContext createContext(ErrorContext errorContext, ServiceLocator locator) {
        return ServiceContextFactory.createServiceContext(errorContext, null, locator);
    }
    
    public static IServiceContext createContext(ErrorContext errorContext, String userName, ServiceLocator locator) {
        return ServiceContextFactory.createServiceContext(errorContext, userName, locator);
    }

    public static IServiceContext createContext(ErrorContext errorContext, HttpServletRequest request, ServiceLocator locator) {
        Principal principal = request.getUserPrincipal();
        
        if (principal != null) {
            return ServiceContextFactory.createServiceContext(errorContext, principal.getName(), locator);
        } else {
            return ServiceContextFactory.createServiceContext(errorContext, null, locator);
        }
    }
    
    private static IServiceContext createServiceContext(ErrorContext errorContext, String userName, ServiceLocator locator) {
        IServiceContext context = new ServiceContext();
        context.setUserName( userName);
        context.setServiceLocator(locator);
        context.setErrorContext(errorContext);
        return context;
    }    
}
