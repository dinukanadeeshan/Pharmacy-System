/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.HoldOrder;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Nadeeshan
 */
public interface HoldOrderController extends Remote {

    public boolean addHoldOrder(HoldOrder holdOrder) throws RemoteException;

    public boolean removeHoldOrder(HoldOrder holdOrder) throws RemoteException;

    public boolean removeHoldOrder(int holdOrderId) throws RemoteException;

    public boolean removeAllOrders() throws RemoteException;

    public HoldOrder getHoldOrder(int holdOrderId) throws RemoteException;

    public int getHoldOrderCount() throws RemoteException;

    public ArrayList<HoldOrder> getAllOrders() throws RemoteException;

    public int getLastHoldOrderId() throws RemoteException;

    public ArrayList<HoldOrder> getHoldOrderByCustId(String custId) throws RemoteException;
}
