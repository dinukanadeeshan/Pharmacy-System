/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.connector;

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
import com.redonz.pms.common.factory.RemoteFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Nadeeshan
 */
public class ServerConnector {

    private static ServerConnector serverConnector;
    private RemoteFactory remoteFacory;
    private DateController dateController;
    private ItemController itemController;
    private CustomerController customerController;
    private CustomerOrderController customerOrderController;
    private CustomerOderDetailController customerOderDetailController;
    private BatchItemController batchItemController;
    private HoldOrderController holdOrderController;
    private PaymentController paymentController;
    private CategoryController categoryController;
    private UserController userController;

    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        remoteFacory = (RemoteFactory) Naming.lookup("rmi://localhost:1055/PharmacyServerRemoteFactory");
    }

    public DateController getDateController() throws RemoteException {
        if (dateController == null) {
            dateController = remoteFacory.getDateController();
        }
        return dateController;
    }

    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnector == null) {
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }

    public static ServerConnector getNewServerConnector() throws NotBoundException, MalformedURLException, RemoteException {

        serverConnector = new ServerConnector();

        return serverConnector;
    }

    public UserController getUserController()  throws NotBoundException, MalformedURLException, RemoteException {
        if (userController == null) {
            userController = remoteFacory.getUserController();
        }
        return userController;
    }
    

    public ItemController getItemController() throws RemoteException {
        if (itemController == null) {
            itemController = remoteFacory.getItemController();
        }
        return itemController;
    }

    public CustomerOderDetailController getCustomerOderDetailController() throws RemoteException {
        if (customerOderDetailController == null) {
            customerOderDetailController = remoteFacory.getCustomerOderDetailController();
        }
        return customerOderDetailController;
    }

    
    public CustomerController getCustomerController() throws RemoteException {
        if (customerController == null) {
            customerController = remoteFacory.getCustomerController();
        }
        return customerController;
    }

    public CustomerOrderController getCustomerOrderController() throws RemoteException {

        if (customerOrderController == null) {
            customerOrderController = remoteFacory.getCustomerOrderController();
        }
        
        return customerOrderController;
    }

    public BatchItemController getBatchItemController() throws RemoteException {
        
        if (batchItemController == null) {
            batchItemController = remoteFacory.getBatchItemController();
        }
        
        return batchItemController;
    }

    public HoldOrderController getHoldOrderController() throws RemoteException {
        if (holdOrderController == null) {
            holdOrderController = remoteFacory.getHoldOrderController();
        }
        
        return holdOrderController;
    }

    public PaymentController getPaymentController() throws RemoteException {
        if (paymentController == null) {
            paymentController = remoteFacory.getPaymentController();
        }
        return paymentController;
    }

    public CategoryController getCategoryController() throws RemoteException {
        if (categoryController == null) {
            categoryController = remoteFacory.getCategoryController();
        }
        return categoryController;
    }
}
