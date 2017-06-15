/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.controller.impl;

import com.redonz.pms.common.controller.CustomerOrderController;
import com.redonz.pms.common.model.CustomerOrder;
import com.redonz.pms.common.model.Payment;
import com.redonz.pms.common.observer.Observer;
import com.redonz.pms.server.dao.CustomerOrderDAO;
import com.redonz.pms.server.dao.impl.CustomerOrderDAOImpl;
import com.redonz.pms.server.model.ID;
import com.redonz.pms.server.observable.OrderObservable;
import com.redonz.pms.server.others.IDGen;
import com.redonz.pms.server.pool.id.IdPool;
import com.redonz.pms.server.reservation.Reservation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadeeshan
 */
public class CustomerOrderControllerImpl extends UnicastRemoteObject implements CustomerOrderController {

    private final CustomerOrderDAO customerOrderDAO = new CustomerOrderDAOImpl();
    private static final Reservation<CustomerOrderController> CUSTOMER_ORDER_RESERVATION = new Reservation<>();
    private static IdPool orderIdPool = new IdPool();
    private static OrderObservable orderObservable = new OrderObservable();

    public CustomerOrderControllerImpl() throws RemoteException {
    }

    @Override
    public boolean saveCustomerOrder(final CustomerOrder customerOrder) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        boolean res = customerOrderDAO.insert(customerOrder);
        new Thread() {
            @Override
            public void run() {
                try {
                    orderObservable.orderAdded(customerOrder);
                } catch (RemoteException ex) {
                    Logger.getLogger(CustomerOrderControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();

        return res;
    }

    @Override
    public CustomerOrder searchCustomerOrder(String orderId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomerOrder(CustomerOrder customerOrder) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomerOrder(String orderId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastOrderId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.lastId();
    }

    @Override
    public boolean updateOrderDiscount(String orderId, double discount, double netAmount) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.update(new CustomerOrder(null, orderId, null, 0, netAmount, discount));
    }

    @Override
    public ArrayList<CustomerOrder> getOrdersByDateRange(String bDate, String eDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.ordersForDateRange(bDate, eDate);
    }

    @Override
    public ArrayList<CustomerOrder> getOrdersByOrderDate(String orderDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.ordersByOrderDate(orderDate);
    }

    @Override
    public ArrayList<CustomerOrder> getOrdersByCustId(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.ordersByCustId(custId);
    }

    @Override
    public boolean saveCustomerOrder(CustomerOrder customerOrder, Payment payment) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.saveWithPayment(customerOrder, payment);
    }

    @Override
    public boolean reserveCustomerOrder(String orderId) throws RemoteException {
        return CUSTOMER_ORDER_RESERVATION.reserve(orderId, this);
    }

    @Override
    public boolean releaseCustomerOrder(String orderId) throws RemoteException {
        return CUSTOMER_ORDER_RESERVATION.release(orderId, this);
    }

    @Override
    public String getNextOrderId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        ID id = orderIdPool.getId();
        if (id == null) {
            String nextID = IDGen.getNextId(customerOrderDAO.lastId());
            orderIdPool.addId(nextID);
            return nextID;
        }
        return id.getId();
    }

    @Override
    public void releaseOrderId(String id) throws RemoteException {
        orderIdPool.releaseID(id);
    }

    @Override
    public ArrayList<CustomerOrder> getUnsettledOrdersByDateRange(String bDate, String eDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.unsettledOrdersForDateRange(bDate, eDate);
    }

    @Override
    public ArrayList<CustomerOrder> getUnsettledOrdersByOrderDate(String orderDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.unsettledOrdersByOrderDate(orderDate);
    }

    @Override
    public ArrayList<CustomerOrder> getUnsettledOrdersByCustId(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerOrderDAO.unsettledOrdersByCustId(custId);
    }

    @Override
    public void removeObserver(Observer observer) throws RemoteException {
        orderObservable.removeObserver(observer);
    }

    @Override
    public void addObserver(Observer observer) throws RemoteException {
        orderObservable.addObserver(observer);
    }
}
