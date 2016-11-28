package uk.co.iyana.service.registry;

/**
 * An enumeration of services and the classes that implement them.
 * 
 * This allows us to create a hierarchical enumeration of services
 * 
 * @author fgyara
 */
public interface ServiceRegistry<T> {
    public Class<T> getServiceClass();
}
