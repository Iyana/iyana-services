package uk.co.iyana.service.exception;

/**
 *
 * @author fgyara
 */
public class ServiceLocatorRuntimeException extends RuntimeException {
    public ServiceLocatorRuntimeException(String mesg, Exception ex) {
        super(mesg, ex);
    }
    
    public ServiceLocatorRuntimeException(String mesg) {
        super(mesg);
    }
}
