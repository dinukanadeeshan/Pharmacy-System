/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.common.model;

import java.io.Serializable;

/**
 *
 * @author DI_SH
 */
public class ObserverTO implements  Serializable{
    public final static String ADD = "Added ";
    public final static String UPDATE = "Updated ";
    public final static String DELETE = "Deleted ";
    private String action;
    private Object obj;

    public ObserverTO() {
    }

    public ObserverTO(String action, Object obj) {
        this.action = action;
        this.obj = obj;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }
    
}
