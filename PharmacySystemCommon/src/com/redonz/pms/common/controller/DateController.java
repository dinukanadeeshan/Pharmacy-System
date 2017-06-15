/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Nadeeshan
 */
public interface DateController extends Remote {

    public String getCurrentDate() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public String getCurrentTime() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean changeSystemDate(String date) throws RemoteException;
}
