/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.controller.impl;

import com.redonz.pms.common.controller.CustomerController;
import com.redonz.pms.common.model.Customer;
import com.redonz.pms.common.observer.Observer;
import com.redonz.pms.server.dao.CustomerDAO;
import com.redonz.pms.server.dao.impl.CustomerDAOImpl;
import com.redonz.pms.server.model.ID;
import com.redonz.pms.server.observable.CustomerObservable;
import com.redonz.pms.server.others.IDGen;
import com.redonz.pms.server.pool.id.IdPool;
import com.redonz.pms.server.reservation.Reservation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadeeshan
 */
public class CustomerControllerImpl extends UnicastRemoteObject implements CustomerController {

    private CustomerDAO customerDAO = new CustomerDAOImpl();
    private static IdPool customerIdPool = new IdPool();
    private static CustomerObservable customerObservable = new CustomerObservable();
    private static Reservation<CustomerController> customerReservation = new Reservation<>();

    public CustomerControllerImpl() throws RemoteException {
    }

    @Override
    public boolean saveCustomer(final Customer customer) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        boolean res = customerDAO.insert(customer);
        if (res) {
            new Thread() {
                public void run() {
                    try {
                        customerObservable.customerAdded(customer);
                    } catch (RemoteException ex) {
                        Logger.getLogger(CustomerControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
        return res;
    }

    @Override
    public Customer searchCustomer(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerDAO.search(custId);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomer(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerDAO.getAll();
    }

    @Override
    public String getLastCustomerID() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerDAO.lastId();
    }

    @Override
    public String getNextCustomerId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        ID id = customerIdPool.getId();
        if (id == null) {
            String nextID = IDGen.getNextId(customerDAO.lastId());
            customerIdPool.addId(nextID);
            return nextID;
        }
        return id.getId();
    }

    @Override
    public boolean releaseCustomerId(String id) throws RemoteException {
        return customerIdPool.releaseID(id);
    }

    @Override
    public void addObserver(Observer observer) throws RemoteException {
        customerObservable.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) throws RemoteException {
        customerObservable.removeObserver(observer);
    }

    @Override
    public List<Customer> searchCustomerByAddress(String address) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerDAO.customersByAddress(address);
    }

    @Override
    public List<Customer> searchCustomerByContact(String contact) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerDAO.customersByContact(contact);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return customerDAO.customersByName(name);
    }
    
}
