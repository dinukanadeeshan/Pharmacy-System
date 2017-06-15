/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;


import com.redonz.pms.common.model.BatchItem;
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
public interface BatchItemController extends Remote {

    public boolean saveBatchItem(BatchItem batchItem) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public boolean saveBatchItemList(ArrayList<BatchItem> batchItemList) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public BatchItem searchBatchItem(String itemCode) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public boolean updateBatchItem(BatchItem batchItem) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public boolean deleteBatchItem(String itemCode) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ArrayList<BatchItem> getGoingToExpItems(String date) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public String getLastBatchItemCode() throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ArrayList<BatchItem> getAllBatchItemList() throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ArrayList<BatchItem> getBatchesByBarcode(String barcode) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ArrayList<BatchItem> getAvailableBatchesByBarcode(String barcode) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public String getBarcodeForItemCode(String itemCode) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ItemDetail getItemDetailForBatchN0(String batchNo) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ItemDetail getAvailableItemDetailForBatchN0(String batchNo) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ArrayList<ItemDetail> getItemDetailForExpDateRange(String beginDate, String endDate) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public ArrayList<ItemDetail> getAvailableItemDetailForExpDateRange(String beginDate, String endDate) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    public Item getItemByItemCode(String itemCode) throws SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException;

    void addBatchItemObserver(Observer observer) throws RemoteException;

    boolean reserveBatchItem(String id) throws RemoteException;

    boolean releaseBatchItem(String id) throws RemoteException;
    
    String getNextBatchItemCode() throws RemoteException, SQLException, ClassNotFoundException,FileNotFoundException, IOException ;
    
    void releaseBatchItemCode(String id) throws RemoteException;

    public void removeObserver(Observer batchItemObserver)throws RemoteException;
}
