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
public class HoldOrder implements Serializable{
    int holdOrderId;
    String custId;
    ArrayList<CustomerOrderDetail> customerOrderDetailList;

    public HoldOrder() {
    }

    public HoldOrder(int holdOrderId, String custId, ArrayList<CustomerOrderDetail> customerOrderDetailList) {
        this.holdOrderId = holdOrderId;
        this.custId = custId;
        this.customerOrderDetailList = customerOrderDetailList;
    }

    public int getHoldOrderId() {
        return holdOrderId;
    }

    public void setHoldOrderId(int holdOrderId) {
        this.holdOrderId = holdOrderId;
    }


    public String getCustId() {
        return custId;
    }

    public ArrayList<CustomerOrderDetail> getCustomerOrderDetailList() {
        return customerOrderDetailList;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setCustomerOrderDetailList(ArrayList<CustomerOrderDetail> customerOrderDetailList) {
        this.customerOrderDetailList = customerOrderDetailList;
    }
    
}
