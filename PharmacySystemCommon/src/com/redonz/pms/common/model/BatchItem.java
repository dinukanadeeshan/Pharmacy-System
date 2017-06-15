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
public class BatchItem implements Serializable {

    private String itemCode;
    private String barCode;
    private String batchNo;
    private String expDate;
    private double unitPrice;
    private double qty;

    public BatchItem(String itemCode, String barCode, String batchNo, String expDate, double unitPrice, double qty) {
        this.itemCode = itemCode;
        this.barCode = barCode;
        this.batchNo = batchNo;
        this.expDate = expDate;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public BatchItem() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return barCode + " - " + batchNo;
    }
}
