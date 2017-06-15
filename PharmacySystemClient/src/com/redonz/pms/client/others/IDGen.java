/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.others;



/**
 *
 * @author Nadeeshan
 */
public class IDGen {
//    private static final List<Class> classList = new ArrayList<>();
//    static {
//        classList.add(CustomerController.class);
//        classList.add(CustomerOderDetailController.class);
//        classList.add(CustomerOrderController.class);
//        classList.add(CategoryController.class);
//    }
    public static String getNextId(String lastId) {
        if (lastId != null) {
            int index = -1;
            for (int i = 0; i < lastId.length(); i++) {
                char ch = lastId.charAt(i);
                if (Character.isDigit(ch)) {
                    index = i;
                    break;
                }
            }
            String prefix = lastId.substring(0, index);
            int num = Integer.parseInt(lastId.substring(index));
            num++;

            if (num < 10) {
                return prefix + "000" + num;
            } else if (num < 100) {
                return prefix + "00" + num;
            } else if (num < 1000) {
                return prefix + "0" + num;
            } else {
                return prefix + num;
            }
        }
        throw new IllegalArgumentException("Illegal last Id");

    }

    public static String getNextId(String tableName, String colName, String prefix) {
//        Class c = null; 
//        for (Class class1 : classList) {
//            if (class1.getSimpleName().startsWith(tableName)) {
//                c = class1;
//                break;
//            }
//        }
//        Method[] declaredMethods = c.getDeclaredMethods();
//        Method method  = null;
//        for (Method m: declaredMethods) {
//            if (m.getName().startsWith("getLast")) {
//                method = m;
//                break;
//            }
//        }
//        method.invoke(c, declaredMethods)
        
        
        
//        String sql = "select "+colName+" from "+tableName+" order by 1 desc limit 1";
//        DBc
//        if (lastId != null) {
//            int index = -1;
//            for (int i = 0; i < lastId.length(); i++) {
//                char ch = lastId.charAt(i);
//                if (Character.isDigit(ch)) {
//                    index = i;
//                    break;
//                }
//            }
//            
//            int num = Integer.parseInt(lastId.split(prefix));
//            num++;
//
//            if (num < 10) {
//                return prefix + "000" + num;
//            } else if (num < 100) {
//                return prefix + "00" + num;
//            } else if (num < 1000) {
//                return prefix + "0" + num;
//            } else {
//                return prefix + num;
//            }
        return prefix + "0001";
    }
}
