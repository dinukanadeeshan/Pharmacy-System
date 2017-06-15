/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.controller.impl;

import com.redonz.pms.common.controller.CategoryController;
import com.redonz.pms.common.model.Category;
import com.redonz.pms.server.dao.CategoryDAO;
import com.redonz.pms.server.dao.impl.CategoryDAOImpl;
import com.redonz.pms.server.model.ID;
import com.redonz.pms.server.others.IDGen;
import com.redonz.pms.server.pool.id.IdPool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DI_SH
 */
public class CategoryControllerImpl extends UnicastRemoteObject implements  CategoryController{
    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    private static IdPool categoryIdPool = new IdPool();
    public CategoryControllerImpl() throws RemoteException{
    }
    
    @Override
    public boolean addCategory(Category category) throws RemoteException, SQLException, ClassNotFoundException , FileNotFoundException, IOException{
        return categoryDAO.insert(category);
    }

    @Override
    public ArrayList<Category> getAllCategories() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return categoryDAO.getAll();
    }

    @Override
    public String getLastCategoryId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        return categoryDAO.lastId();
    }

    @Override
    public Category searchCategory(String categoryId) throws RemoteException, SQLException, ClassNotFoundException , FileNotFoundException, IOException{
        return categoryDAO.search(categoryId);
    }

    @Override
    public String getNextCategoryId() throws RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        ID id = categoryIdPool.getId();
        if (id == null) {
            String nextID = IDGen.getNextId(categoryDAO.lastId());
            categoryIdPool.addId(nextID);
            return nextID;
        }
        return id.getId();
    }

    @Override
    public void releaseCategoryId(String id) throws RemoteException {
        categoryIdPool.releaseID(id);
    }
    
}
