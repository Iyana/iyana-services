package uk.co.iyana.service.locator;

import javax.servlet.http.HttpServletRequest;
import uk.co.iyana.service.IService;
import uk.co.iyana.service.context.IServiceContext;
import uk.co.iyana.service.context.ServiceContextFactory;
import uk.co.iyana.service.exception.ServiceLocatorRuntimeException;
import uk.co.iyana.service.registry.ServiceRegistry;

/**
 * An implementation of the Service Locator pattern
 * 
 * The ServiceLocator uses a ServiceRegistry to locate, instantiate and return a service.
 * 
 * The Service must have a default constructor
 * @author fgyara
 */
public class ServiceLocator  {

    public IServiceContext serviceContext;
    
    ServiceLocator() {
    }
    
    void setContext(IServiceContext serviceContext) {
        this.serviceContext = serviceContext;
    }

    public IService locateService(ServiceRegistry registry) throws ServiceLocatorRuntimeException {
        
        if (registry == null) {
            throw new ServiceLocatorRuntimeException("registry parameter cannot be null");
        }
        
        Class serviceClass = registry.getServiceClass();
        
        if (serviceClass == null) {
            throw new ServiceLocatorRuntimeException("Service class not defined for " + registry.toString());
        }
        
        try {
            Object serviceObject = serviceClass.newInstance();

            IService service;
            if (serviceObject != null) {
                service = (IService)serviceObject;
            } else {
                throw new ServiceLocatorRuntimeException("Could not instantiate service " + registry.toString() + " class " + serviceClass.getName());
            }
            
            // set up its context
            service.setServiceContext(this.serviceContext);
            
            return service;
            
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new ServiceLocatorRuntimeException("Could not instantiate service " + registry.toString() + " class " + serviceClass.getName(), ex);
        } catch (ClassCastException e2) {
            throw new ServiceLocatorRuntimeException("Class " + serviceClass.getName() + " must extend " + IService.class.getName(), e2);
        }
    }

}
