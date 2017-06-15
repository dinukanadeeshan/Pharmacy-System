/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.server.pool.id;

import com.redonz.pms.server.model.ID;
import com.redonz.pms.server.others.IDGen;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author cmjd
 */
public class IdPool {

    protected final List<ID> idList;

    public IdPool() {
        idList = new Vector<>();
    }

    public ID addId() {
        Collections.sort(idList);
        ID newID = null;
        if (!idList.isEmpty()) {
            ID id = idList.get(idList.size() - 1);
            newID = new ID(increaseId(id.getId()));
            idList.add(newID);
            newID.use();
//            System.out.println("-----Added() " + newID);
            return newID;
        }
        return null;


    }

    public String addId(String id) {
//        System.out.println("-----Added(id) " + id);
        ID iD = new ID(id);
        idList.add(iD);
        iD.use();
        return id;
    }

    protected String increaseId(String id) {
        return IDGen.getNextId(id);
    }

    public ID getId() {
        for (ID id : idList) {
//            System.out.println("------getID : id : "+id);
            if (id.use()) {
//                System.out.println("-----This is use");
                return id;
            }
        }
//        System.out.println("-----retruned....");
        return addId();

    }

    public List getAll() {
        return idList;
    }

//    public boolean remove(String id) {
//        for (ID id1 : idList) {
//            if (id1.getId().equals(id) && id1.release()) {
//                idList.remove(id1);
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean releaseID(String id) {
        for (ID id1 : idList) {
            if (id1.getId().equals(id)) {
                return id1.release();
            }
        }
        return false;
    }
}
