/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.CustomerOrderDetail;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nadeeshan
 */
public interface CustomerOderDetailController extends Remote {

    public boolean saveCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;

    public CustomerOrderDetail searchCustomerOrderDetail(String orderDetailId) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;

    public boolean updateCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;

    public boolean deleteCustomerOrderDetail(String orderDetailId) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;

    public boolean saveCustomerOrderDetailList(ArrayList<CustomerOrderDetail> customerOrderDetails, Connection connection) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;

    public ArrayList<CustomerOrderDetail> getOrderDetailsByOrderId(String orderId) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;
    
    String getNextOrderDetailId() throws RemoteException, SQLException, ClassNotFoundException,FileNotFoundException, IOException ;

    void releaseOrderDetailId(String id) throws RemoteException;
}
