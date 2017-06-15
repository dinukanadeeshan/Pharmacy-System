/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.model;

import java.io.Serializable;

/**
 *
 * @author Nadeeshan
 */
public class CustomerOrderDetail implements Serializable {

    private String itemCode;
    private String orderId;
    private String batchNo;
    private double qty;
    private double unitprice;
    private String expDate;

    /**
     * Default Constructor
     */
    public CustomerOrderDetail() {
    }

    /**
     *
     * @param itemCode
     * @param orderId
     * @param batchNo
     * @param qty
     * @param unitprice
     * @param expDate
     */
    public CustomerOrderDetail(String itemCode, String orderId, String batchNo, double qty, double unitprice, String expDate) {
        this.itemCode = itemCode;
        this.orderId = orderId;
        this.batchNo = batchNo;
        this.qty = qty;
        this.unitprice = unitprice;
        this.expDate = expDate;
    }

    /**
     *
     * @param itemCode
     * @param orderId
     * @param qty
     * @param unitprice
     * @param expDate
     */
    public CustomerOrderDetail(String itemCode, String orderId, double qty, double unitprice, String expDate) {
        this.itemCode = itemCode;
        this.orderId = orderId;
        this.qty = qty;
        this.unitprice = unitprice;
        this.expDate = expDate;
    }

    /**
     *
     * @return
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     *
     * @param batchNo
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    
    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }

    /**
     * @return the unitprice
     */
    public double getUnitprice() {
        return unitprice;
    }

    /**
     * @param unitprice the unitprice to set
     */
    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * @return the expDate
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * @param expDate the expDate to set
     */
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
