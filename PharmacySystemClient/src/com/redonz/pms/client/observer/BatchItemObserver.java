/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.observer;

import com.redonz.pms.client.view.item.SearchItemForm;
import com.redonz.pms.client.view.item.UpdateStockForm;
import com.redonz.pms.common.model.ObserverTO;
import com.redonz.pms.common.observer.Observer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JDialog;

/**
 *
 * @author DI_SH
 */
public class BatchItemObserver extends UnicastRemoteObject implements Observer {

    private JDialog dialog;
    private boolean changed = false;

    public BatchItemObserver(JDialog dialog) throws RemoteException {
        this.dialog = dialog;
    }

    @Override
    public boolean isChanged() throws RemoteException {
        return changed;
    }

    @Override
    public void setChanged(boolean changed) throws RemoteException {
        this.changed = changed;
    }

    @Override
    public void update(ObserverTO observerTO) throws RemoteException {

        if (dialog instanceof UpdateStockForm) {
            ((UpdateStockForm) dialog).notifyChanges(observerTO);
        } else if (dialog instanceof SearchItemForm) {
            ((SearchItemForm) dialog).notifyChanges(observerTO);
        }

    }
}
