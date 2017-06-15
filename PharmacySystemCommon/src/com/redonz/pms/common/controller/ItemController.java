/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.Item;
import com.redonz.pms.common.model.ItemDetail;
import com.redonz.pms.common.observer.Observer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nadeeshan
 */
public interface ItemController extends Remote {

    public boolean saveItem(Item item) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public Item searchItem(String barcode) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<Item> searchItemLike(String barcode) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean updateItem(Item item) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public boolean deleteItem(String barcode) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ItemDetail getAbstractItemDetail(String barcode) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<Item> getItemsByDescription(String desc) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<Item> getItemsByCategory(String categoryId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<Item> getDueReOrderingItems() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public ArrayList<Item> getAllAvailableItems() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    public void addItemObserver(Observer observer) throws RemoteException;

    public void removeObserver(Observer observer) throws RemoteException;

    public boolean reserveItem(String barcode) throws RemoteException;

    public boolean releaseItem(String barcode) throws RemoteException;
}
