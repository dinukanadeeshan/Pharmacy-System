/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.Payment;
import com.redonz.pms.common.observer.Observer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Nadeeshan
 */
public interface PaymentController extends Remote {

    void addPaymentObserver(Observer observer) throws RemoteException;

    public boolean savePayment(Payment payment) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public Payment searchPayment(String paymentId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean updatePayment(Payment payment) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean deletePayment(String paymentId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public String getLastPaymentId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    boolean releasePayment(String id) throws RemoteException;

    boolean reservePayment(String id) throws RemoteException;

    String getNextPaymentId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    void releasePaymentId(String id) throws RemoteException;

    void removeObserver(Observer observer) throws RemoteException;
}
