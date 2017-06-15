/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.CustomerOrder;
import com.redonz.pms.common.model.Payment;
import com.redonz.pms.common.observer.Observer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nadeeshan
 */
public interface CustomerOrderController extends Remote {

    public boolean saveCustomerOrder(CustomerOrder customerOrder) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean saveCustomerOrder(CustomerOrder customerOrder, Payment payment) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public CustomerOrder searchCustomerOrder(String orderId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean updateCustomerOrder(CustomerOrder customerOrder) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean deleteCustomerOrder(String orderId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public String getLastOrderId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean updateOrderDiscount(String orderId, double discount, double netAmount) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<CustomerOrder> getOrdersByDateRange(String bDate, String eDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<CustomerOrder> getUnsettledOrdersByDateRange(String bDate, String eDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<CustomerOrder> getOrdersByOrderDate(String orderDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<CustomerOrder> getUnsettledOrdersByOrderDate(String orderDate) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<CustomerOrder> getOrdersByCustId(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<CustomerOrder> getUnsettledOrdersByCustId(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean reserveCustomerOrder(String orderId) throws RemoteException;

    public boolean releaseCustomerOrder(String orderId) throws RemoteException;

    String getNextOrderId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    void releaseOrderId(String id) throws RemoteException;

    void addObserver(Observer observer) throws RemoteException;

    void removeObserver(Observer observer) throws RemoteException;
}
