/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DI_SH
 */
public interface UserController extends Remote {

    boolean addUser(User user) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    boolean updateUser(User user) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    User getUser(User user) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    boolean removeUser(String user) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    ArrayList<User> getAllUsers() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;
}
