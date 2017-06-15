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
public class Category implements Serializable{
    private String categoryId;
    private String description;

    public Category() {
    }

    public Category(String categoryId, String description) {
        this.categoryId = categoryId;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return categoryId+" - "+description;
    }
     
    
}
