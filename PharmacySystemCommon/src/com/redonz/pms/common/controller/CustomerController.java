/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.Customer;
import com.redonz.pms.common.observer.Observer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nadeeshan
 */
public interface CustomerController extends Remote {

    public boolean saveCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public Customer searchCustomer(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public List<Customer> searchCustomerByName(String name) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public List<Customer> searchCustomerByAddress(String address) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public List<Customer> searchCustomerByContact(String contact) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean updateCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean deleteCustomer(String custId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<Customer> getAllCustomers() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public String getLastCustomerID() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public String getNextCustomerId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public void addObserver(Observer observer) throws RemoteException;

    public void removeObserver(Observer observer) throws RemoteException;

    public boolean releaseCustomerId(String id) throws RemoteException;
}
