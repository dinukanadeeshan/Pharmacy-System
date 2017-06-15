/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.observer;

import com.redonz.pms.client.view.customer.ManageCustomer;
import com.redonz.pms.common.model.ObserverTO;
import com.redonz.pms.common.observer.Observer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JDialog;

/**
 *
 * @author DI_SH
 */
public class CustomerObserver extends UnicastRemoteObject implements Observer{

    private JDialog dialog;
    private boolean changed;
    public CustomerObserver(JDialog dialog) throws RemoteException{
        this.dialog = dialog
                ;
    }

    @Override
    public void update(ObserverTO observerTO) throws RemoteException {
        if (dialog instanceof ManageCustomer) {
            ManageCustomer manageCustomer = (ManageCustomer) dialog;
            
            manageCustomer.notifyChanges(observerTO);
            
        }
    }

    @Override
    public boolean isChanged() throws RemoteException {
        return changed;
    }

    @Override
    public void setChanged(boolean changed) throws RemoteException {
        this.setChanged(changed);
    }
    
}
