/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.co.iyana.service.context;

import java.util.Stack;
import uk.co.iyana.commons.usererror.ErrorContext;
import uk.co.iyana.service.locator.ServiceLocator;

/**
 *
 * @author fgyara
 */
public class ServiceContext implements IServiceContext {
    
    private String userName;
    private ServiceLocator serviceLocator;
    private Stack<ErrorContext> errorContextStack;
            
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userName
     */
    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public ServiceLocator getServiceLocator() {
        return this.serviceLocator;
    }

    @Override
    public void setErrorContext(ErrorContext errorContext) {
        this.errorContextStack = new Stack();
        this.errorContextStack.push(errorContext);
    }

    @Override
    public ErrorContext getErrorContext() {
        return this.errorContextStack.peek();
    }

    @Override
    public void pushErrorContext(String incrementalContextName, Integer index) {
        ErrorContext errorContext = new ErrorContext(this.getErrorContext(), incrementalContextName, index);
        this.errorContextStack.push(errorContext);
    }

    public void pushErrorContext(String incrementalContextName) {
        this.pushErrorContext(incrementalContextName, null);
    }

    public void pushErrorContext(Integer index) {
        this.pushErrorContext(null, index);
    }

    @Override
    public void popErrorContext() {
        this.errorContextStack.pop();
    }
}
