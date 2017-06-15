/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.observer;

import com.redonz.pms.common.model.ObserverTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DI_SH
 */
public interface Observer extends Remote {

    void update(ObserverTO observerTO) throws RemoteException;

    boolean isChanged() throws RemoteException;

    public void setChanged(boolean changed) throws RemoteException;
}
