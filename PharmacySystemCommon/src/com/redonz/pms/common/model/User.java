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
public class User implements Serializable{
    private String user;
    private String password;
    private int privilage;
    
    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User(String user, String password, int privilage) {
        this.user = user;
        this.password = password;
        this.privilage = privilage;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPrivilage() {
        return privilage;
    }

    public void setPrivilage(int privilage) {
        this.privilage = privilage;
    }
    
}
