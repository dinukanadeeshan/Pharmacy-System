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
public class CustomerOrder implements Serializable {

    private String custId;
    private String orderId;
    private String date;
    private double totalAmount;
    private double balance;
    private double discount;
    private ArrayList<CustomerOrderDetail> customerOrderDetailList;

    public CustomerOrder() {
    }

    public CustomerOrder(String custId, String orderId, String date, double totalAmount, double balance, double discount) {
        this.orderId = orderId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.balance = balance;
        this.discount = discount;
        this.custId = custId;

    }

    public CustomerOrder(String custId, String orderId, String date, double totalAmount, double balance, double discount, ArrayList<CustomerOrderDetail> customerOrderDetailList) {
        this.orderId = orderId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.balance = balance;
        this.discount = discount;
        this.customerOrderDetailList = customerOrderDetailList;
        this.custId = custId;
    }

    public void setCustomerOrderDetailList(ArrayList<CustomerOrderDetail> customerOrderDetailList) {
        this.customerOrderDetailList = customerOrderDetailList;
    }

    public ArrayList<CustomerOrderDetail> getCustomerOrderDetailList() {
        return customerOrderDetailList;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
