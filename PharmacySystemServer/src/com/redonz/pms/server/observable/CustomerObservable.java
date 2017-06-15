/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.observable;

import com.redonz.pms.common.model.Customer;
import com.redonz.pms.common.model.ObserverTO;
import java.rmi.RemoteException;

/**
 *
 * @author DI_SH
 */
public class CustomerObservable extends Observable{
    public void customerAdded(Customer customer)throws RemoteException{
        notifyObservers(new ObserverTO(ObserverTO.ADD, customer));
    }
}
