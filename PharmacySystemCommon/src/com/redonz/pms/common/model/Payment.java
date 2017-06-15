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
public class Payment implements Serializable{
    private String paymentId;
    private String orderId;
    private String date;
    private double amount;
    private int state;

    public Payment() {
    }

    public Payment(String paymentId, String orderId, String date, double amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
    }

    public Payment(String paymentId, String orderId, String date, double amount, int state) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.date = date;
        this.amount = amount;
        this.state = state;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
