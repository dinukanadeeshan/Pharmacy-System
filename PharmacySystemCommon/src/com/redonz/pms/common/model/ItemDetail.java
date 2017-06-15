/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Nadeeshan
 */
public class ItemDetail implements Serializable{
    private Item item;
    private ArrayList<BatchItem> batchItemList;
    private Category category;

    public ItemDetail() {
    }

    public ItemDetail(Item item, Category category) {
        this.item = item;
        this.category = category;
    }

    public ItemDetail(Item item, ArrayList<BatchItem> batchItemList) {
        this.item = item;
        this.batchItemList = batchItemList;
    }
   

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<BatchItem> getBatchItemList() {
        return batchItemList;
    }

    public void setBatchItemList(ArrayList<BatchItem> batchItemList) {
        this.batchItemList = batchItemList;
    }

   
    
}
