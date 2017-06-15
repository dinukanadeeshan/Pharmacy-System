/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.observable;

import com.redonz.pms.common.model.CustomerOrder;
import com.redonz.pms.common.model.ObserverTO;
import java.rmi.RemoteException;

/**
 *
 * @author DI_SH
 */
public class OrderObservable extends Observable{
    public void orderAdded(CustomerOrder customerOrder) throws RemoteException{
        notifyObservers(new ObserverTO(ObserverTO.ADD, customerOrder));
    }
}
