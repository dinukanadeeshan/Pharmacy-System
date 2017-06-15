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
public class Item implements Serializable {

    private String barcode;
    private String categoryId;
    private String description;
    private double reorderlevel;
    private double currentQTY;

    public Item() {
    }

    public Item(String barcode, String description) {
        this.barcode = barcode;
        this.description = description;
    }

    public Item(String barcode, String categoryId, String description, double reorderlevel) {
        this.barcode = barcode;
        this.categoryId = categoryId;
        this.description = description;
        this.reorderlevel = reorderlevel;
    }

    public Item(String barcode, String categoryId, String description, double reorderlevel, double currentQTY) {
        this.barcode = barcode;
        this.categoryId = categoryId;
        this.description = description;
        this.reorderlevel = reorderlevel;
        this.currentQTY = currentQTY;
    }

    public double getCurrentQTY() {
        return currentQTY;
    }

    public void setCurrentQTY(double currentQTY) {
        this.currentQTY = currentQTY;
    }

    public double getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(double reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return barcode + " - " + description;
    }
}
