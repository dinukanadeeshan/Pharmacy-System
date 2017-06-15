/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.dao;

import com.redonz.pms.common.model.Customer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nadeeshan
 */
public interface CustomerDAO extends DAO<Customer, String> {

    List<Customer> customersByName(String name) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;

    List<Customer> customersByAddress(String address) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;

    List<Customer> customersByContact(String contact) throws RemoteException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;
}
