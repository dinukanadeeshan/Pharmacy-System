/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.controller.impl;

import com.redonz.pms.common.controller.CustomerOderDetailController;
import com.redonz.pms.common.model.CustomerOrderDetail;
import com.redonz.pms.server.dao.CustomerOrderDetailDAO;
import com.redonz.pms.server.dao.impl.CustomerOrderDetailDAOImpl;
import com.redonz.pms.server.model.ID;
import com.redonz.pms.server.others.IDGen;
import com.redonz.pms.server.pool.id.IdPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DI_SH
 */
public class CustomerOrderDetailControllerImpl extends UnicastRemoteObject implements CustomerOderDetailController {

    private CustomerOrderDetailDAO customerOrderDetailDAO = new CustomerOrderDetailDAOImpl();
    private static IdPool orderDetailIdPool = new IdPool();

    public CustomerOrderDetailControllerImpl() throws RemoteException {
    }

    @Override
    public boolean saveCustomerOrderDetailList(ArrayList<CustomerOrderDetail> customerOrderDetails, Connection connection) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        return customerOrderDetailDAO.addOrderDetailList(customerOrderDetails, connection);
    }

    @Override
    public boolean saveCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerOrderDetail searchCustomerOrderDetail(String orderDetailId) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomerOrderDetail(String orderDetailId) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerOrderDetail> getOrderDetailsByOrderId(String orderId) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        return customerOrderDetailDAO.orderDetailsForOrderId(orderId);
    }

    @Override
    public String getNextOrderDetailId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        ID id = orderDetailIdPool.getId();
        if (id == null) {
            String nextID = IDGen.getNextId(customerOrderDetailDAO.lastId());
            orderDetailIdPool.addId(nextID);
            return nextID;
        }
        return id.getId();
    }

    @Override
    public void releaseOrderDetailId(String id) throws RemoteException {
        orderDetailIdPool.releaseID(id);
    }
}
