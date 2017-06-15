/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.controller;

import com.redonz.pms.common.model.Category;
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
public interface CategoryController extends Remote {

    boolean addCategory(Category category) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    ArrayList<Category> getAllCategories() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    String getLastCategoryId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    Category searchCategory(String categoryId) throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException;

    String getNextCategoryId() throws RemoteException, SQLException, ClassNotFoundException,FileNotFoundException, IOException ;

    void releaseCategoryId(String id) throws RemoteException;
}
