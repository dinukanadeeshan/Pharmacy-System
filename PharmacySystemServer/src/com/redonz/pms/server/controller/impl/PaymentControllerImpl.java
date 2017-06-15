/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.controller.impl;

import com.redonz.pms.common.controller.PaymentController;
import com.redonz.pms.common.model.Payment;
import com.redonz.pms.common.observer.Observer;
import com.redonz.pms.server.reservation.Reservation;
import com.redonz.pms.server.dao.PaymentDAO;
import com.redonz.pms.server.dao.impl.PaymentDAOImpl;
import com.redonz.pms.server.model.ID;
import com.redonz.pms.server.observable.PaymentObservable;
import com.redonz.pms.server.others.IDGen;
import com.redonz.pms.server.pool.id.IdPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadeeshan
 */
public class PaymentControllerImpl extends UnicastRemoteObject implements PaymentController {

    private PaymentDAO paymentDAO = new PaymentDAOImpl();
    private static PaymentObservable paymentObservable = new PaymentObservable();
    private static Reservation<PaymentController> paymentReservation = new Reservation<>();

    private static IdPool paymentIdPool = new IdPool();
    
    public PaymentControllerImpl() throws RemoteException {
    }

    @Override
    public boolean savePayment(final Payment payment) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        boolean res = paymentDAO.insert(payment);
        if (res) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        paymentObservable.paymentDone(payment);
                    } catch (RemoteException ex) {
                        Logger.getLogger(PaymentControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
        return res;
    }

    @Override
    public Payment searchPayment(String paymentId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePayment(Payment payment) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePayment(String paymentId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastPaymentId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return paymentDAO.lastId();
    }

    @Override
    public void addPaymentObserver(Observer observer) throws RemoteException {
        paymentObservable.addObserver(observer);
    }

    @Override
    public boolean releasePayment(String id) throws RemoteException {
        return paymentReservation.release(id, this);
    }

    @Override
    public boolean reservePayment(String id) throws RemoteException {
        return paymentReservation.reserve(id, this);
    }

    @Override
    public String getNextPaymentId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        ID id = paymentIdPool.getId();
        if (id == null) {
            String nextID = IDGen.getNextId(paymentDAO.lastId());
            paymentIdPool.addId(nextID);
            return nextID;
        }
        return id.getId();
    }

    @Override
    public void releasePaymentId(String id) throws RemoteException {
        paymentIdPool.releaseID(id);
    }

    @Override
    public void removeObserver(Observer observer) throws RemoteException {
        paymentObservable.removeObserver(observer);
    }
    
}
