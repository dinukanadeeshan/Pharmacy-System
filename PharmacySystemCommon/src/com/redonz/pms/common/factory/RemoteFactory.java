/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.factory;

import com.redonz.pms.common.controller.BatchItemController;
import com.redonz.pms.common.controller.CategoryController;
import com.redonz.pms.common.controller.CustomerController;
import com.redonz.pms.common.controller.CustomerOderDetailController;
import com.redonz.pms.common.controller.CustomerOrderController;
import com.redonz.pms.common.controller.DateController;
import com.redonz.pms.common.controller.HoldOrderController;
import com.redonz.pms.common.controller.ItemController;
import com.redonz.pms.common.controller.PaymentController;
import com.redonz.pms.common.controller.UserController;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Nadeeshan
 */
public interface RemoteFactory extends Remote {

    UserController getUserController() throws RemoteException;

    public DateController getDateController() throws RemoteException;

    public PaymentController getPaymentController() throws RemoteException;

    public HoldOrderController getHoldOrderController() throws RemoteException;

    public BatchItemController getBatchItemController() throws RemoteException;

    public ItemController getItemController() throws RemoteException;

    public CustomerController getCustomerController() throws RemoteException;

    public CustomerOrderController getCustomerOrderController() throws RemoteException;

    public CategoryController getCategoryController() throws RemoteException;

    public CustomerOderDetailController getCustomerOderDetailController() throws RemoteException;
}
