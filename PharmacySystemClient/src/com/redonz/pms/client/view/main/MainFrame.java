/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.view.main;

import com.redonz.pms.client.connector.ServerConnector;
import com.redonz.pms.client.view.category.AddCategoryForm;
import com.redonz.pms.client.view.customer.AddCustomerForm;
import com.redonz.pms.client.view.customer.ManageCustomer;
import com.redonz.pms.client.view.item.AddItemForm;
import com.redonz.pms.client.view.item.SearchItemForm;
import com.redonz.pms.client.view.item.UpdateStockForm;
import com.redonz.pms.client.view.login.LogIn;
import com.redonz.pms.client.view.order.MakeInvoiceForm;
import com.redonz.pms.client.view.order.ManageOrderForm;
import com.redonz.pms.client.view.payment.SettlePaymentForm;
import com.redonz.pms.common.model.Item;
import com.redonz.pms.common.model.User;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DI_SH
 */
public class MainFrame extends javax.swing.JFrame {

    private User user;

    /**
     * Creates new form MainFrame
     */
    public MainFrame(User user) {
        this.user = user;
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(Toolkit.getDefaultToolkit().getImage("./src/com/redonz/pms/client/img/main.gif"));
//        notificationList.setFixedCellHeight(15);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imgLable = new javax.swing.JLabel();
        makeInvoiceButton = new javax.swing.JButton();
        updateStockButton = new javax.swing.JButton();
        settlePaymentButton = new javax.swing.JButton();
        manageOrderButton = new javax.swing.JButton();
        newItemButton = new javax.swing.JButton();
        searchItemButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logOutLabel = new javax.swing.JLabel();
        exitLabel = new javax.swing.JLabel();
        notificationPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationList = new javax.swing.JList();
        notificationLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        customerMenu = new javax.swing.JMenu();
        addCustomerMenuItem = new javax.swing.JMenuItem();
        manageCustomerMenuItem = new javax.swing.JMenuItem();
        stockMenu = new javax.swing.JMenu();
        newItemMenuItem = new javax.swing.JMenuItem();
        updateStockMenuItem = new javax.swing.JMenuItem();
        searchItemMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        newCategoryMenuItem = new javax.swing.JMenuItem();
        settingMenu = new javax.swing.JMenu();
        userMenu = new javax.swing.JMenu();
        changePasswordMenuItem = new javax.swing.JMenuItem();
        newUserMenuItem = new javax.swing.JMenuItem();
        removeUserMenuItem = new javax.swing.JMenuItem();
        backupMenu = new javax.swing.JMenu();
        createBackupMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        logOutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pharmacy Mangement System");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        imgLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/redonz/pms/client/img/A.png"))); // NOI18N

        makeInvoiceButton.setBackground(new java.awt.Color(0, 153, 0));
        makeInvoiceButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        makeInvoiceButton.setForeground(new java.awt.Color(255, 255, 255));
        makeInvoiceButton.setText("Make Invoice");
        makeInvoiceButton.setBorderPainted(false);
        makeInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeInvoiceButtonActionPerformed(evt);
            }
        });

        updateStockButton.setBackground(new java.awt.Color(0, 153, 0));
        updateStockButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        updateStockButton.setForeground(new java.awt.Color(255, 255, 255));
        updateStockButton.setText("Update Stock");
        updateStockButton.setBorderPainted(false);
        updateStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStockButtonActionPerformed(evt);
            }
        });

        settlePaymentButton.setBackground(new java.awt.Color(0, 153, 0));
        settlePaymentButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        settlePaymentButton.setForeground(new java.awt.Color(255, 255, 255));
        settlePaymentButton.setText("Settle Payment");
        settlePaymentButton.setBorderPainted(false);
        settlePaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settlePaymentButtonActionPerformed(evt);
            }
        });

        manageOrderButton.setBackground(new java.awt.Color(0, 153, 0));
        manageOrderButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        manageOrderButton.setText("Manage Orders");
        manageOrderButton.setBorderPainted(false);
        manageOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrderButtonActionPerformed(evt);
            }
        });

        newItemButton.setBackground(new java.awt.Color(0, 153, 0));
        newItemButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        newItemButton.setForeground(new java.awt.Color(255, 255, 255));
        newItemButton.setText("New Item");
        newItemButton.setBorderPainted(false);
        newItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemButtonActionPerformed(evt);
            }
        });

        searchItemButton.setBackground(new java.awt.Color(0, 153, 0));
        searchItemButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        searchItemButton.setForeground(new java.awt.Color(255, 255, 255));
        searchItemButton.setText("Search Items");
        searchItemButton.setBorderPainted(false);
        searchItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 102, 0));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);

        logOutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/redonz/pms/client/img/gnome-session-logout.png"))); // NOI18N
        logOutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutLabelMouseClicked(evt);
            }
        });

        exitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/redonz/pms/client/img/Actions-session-exit-icon.png"))); // NOI18N
        exitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitLabelMouseClicked(evt);
            }
        });

        notificationPanel.setBackground(new java.awt.Color(247, 247, 247));
        notificationPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        notificationList.setSelectionBackground(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(notificationList);

        javax.swing.GroupLayout notificationPanelLayout = new javax.swing.GroupLayout(notificationPanel);
        notificationPanel.setLayout(notificationPanelLayout);
        notificationPanelLayout.setHorizontalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addContainerGap())
        );
        notificationPanelLayout.setVerticalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        notificationLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        notificationLabel.setForeground(new java.awt.Color(102, 102, 102));
        notificationLabel.setText("Item Notifications (Re-Order-Level) : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imgLable, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(makeInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(settlePaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manageOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exitLabel)
                            .addComponent(logOutLabel))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settlePaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(exitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        customerMenu.setText("Customer");

        addCustomerMenuItem.setText("Add Customer");
        addCustomerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerMenuItemActionPerformed(evt);
            }
        });
        customerMenu.add(addCustomerMenuItem);

        manageCustomerMenuItem.setText("Manage Customer");
        manageCustomerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCustomerMenuItemActionPerformed(evt);
            }
        });
        customerMenu.add(manageCustomerMenuItem);

        jMenuBar1.add(customerMenu);

        stockMenu.setText("Stock");

        newItemMenuItem.setText("New Item");
        newItemMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemMenuItemActionPerformed(evt);
            }
        });
        stockMenu.add(newItemMenuItem);

        updateStockMenuItem.setText("Update Stock");
        updateStockMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStockMenuItemActionPerformed(evt);
            }
        });
        stockMenu.add(updateStockMenuItem);

        searchItemMenuItem.setText("Search Items");
        searchItemMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemMenuItemActionPerformed(evt);
            }
        });
        stockMenu.add(searchItemMenuItem);
        stockMenu.add(jSeparator1);

        jMenu3.setText("Category");

        newCategoryMenuItem.setText("Introduce New");
        newCategoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCategoryMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(newCategoryMenuItem);

        stockMenu.add(jMenu3);

        jMenuBar1.add(stockMenu);

        settingMenu.setText("Settings");

        userMenu.setText("User");

        changePasswordMenuItem.setText("Change Password");
        userMenu.add(changePasswordMenuItem);

        newUserMenuItem.setText("New User");
        userMenu.add(newUserMenuItem);

        removeUserMenuItem.setText("Remove User");
        userMenu.add(removeUserMenuItem);

        settingMenu.add(userMenu);

        backupMenu.setText("Backup");

        createBackupMenuItem.setText("Create Backup");
        backupMenu.add(createBackupMenuItem);

        settingMenu.add(backupMenu);
        settingMenu.add(jSeparator2);

        logOutMenuItem.setText("Log out");
        settingMenu.add(logOutMenuItem);

        exitMenuItem.setText("Exit");
        settingMenu.add(exitMenuItem);

        jMenuBar1.add(settingMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitLabelMouseClicked
        int res = JOptionPane.showConfirmDialog(this, "Are you sure want to exit?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitLabelMouseClicked

    private void logOutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutLabelMouseClicked
        dispose();
        new LogIn(null, true).setVisible(true);


    }//GEN-LAST:event_logOutLabelMouseClicked

    private void makeInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeInvoiceButtonActionPerformed
        new MakeInvoiceForm(this, true).setVisible(true);
    }//GEN-LAST:event_makeInvoiceButtonActionPerformed

    private void updateStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStockButtonActionPerformed
        new UpdateStockForm(this, true).setVisible(true);
    }//GEN-LAST:event_updateStockButtonActionPerformed

    private void settlePaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settlePaymentButtonActionPerformed
        new SettlePaymentForm(this, true).setVisible(true);
    }//GEN-LAST:event_settlePaymentButtonActionPerformed

    private void manageOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrderButtonActionPerformed
        new ManageOrderForm(this, true).setVisible(true);
    }//GEN-LAST:event_manageOrderButtonActionPerformed

    private void newItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemButtonActionPerformed
        new AddItemForm(this, true).setVisible(true);

    }//GEN-LAST:event_newItemButtonActionPerformed

    private void searchItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemButtonActionPerformed
        new SearchItemForm(this, true).setVisible(true);
    }//GEN-LAST:event_searchItemButtonActionPerformed

    private void newItemMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemMenuItemActionPerformed
        new AddItemForm(this, true).setVisible(true);
    }//GEN-LAST:event_newItemMenuItemActionPerformed

    private void updateStockMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStockMenuItemActionPerformed
        new UpdateStockForm(this, true).setVisible(true);
    }//GEN-LAST:event_updateStockMenuItemActionPerformed

    private void searchItemMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemMenuItemActionPerformed
        new SearchItemForm(this, true).setVisible(true);
    }//GEN-LAST:event_searchItemMenuItemActionPerformed

    private void newCategoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCategoryMenuItemActionPerformed
        new AddCategoryForm(null, true).setVisible(true);
    }//GEN-LAST:event_newCategoryMenuItemActionPerformed

    private void addCustomerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerMenuItemActionPerformed
        new AddCustomerForm(this, true
                ).setVisible(true);
    }//GEN-LAST:event_addCustomerMenuItemActionPerformed

    private void manageCustomerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCustomerMenuItemActionPerformed
        new ManageCustomer(this, true).setVisible(true);
    }//GEN-LAST:event_manageCustomerMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(new User("a", null, 1)).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCustomerMenuItem;
    private javax.swing.JMenu backupMenu;
    private javax.swing.JMenuItem changePasswordMenuItem;
    private javax.swing.JMenuItem createBackupMenuItem;
    private javax.swing.JMenu customerMenu;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JLabel imgLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel logOutLabel;
    private javax.swing.JMenuItem logOutMenuItem;
    private javax.swing.JButton makeInvoiceButton;
    private javax.swing.JMenuItem manageCustomerMenuItem;
    private javax.swing.JButton manageOrderButton;
    private javax.swing.JMenuItem newCategoryMenuItem;
    private javax.swing.JButton newItemButton;
    private javax.swing.JMenuItem newItemMenuItem;
    private javax.swing.JMenuItem newUserMenuItem;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JList notificationList;
    private javax.swing.JPanel notificationPanel;
    private javax.swing.JMenuItem removeUserMenuItem;
    private javax.swing.JButton searchItemButton;
    private javax.swing.JMenuItem searchItemMenuItem;
    private javax.swing.JMenu settingMenu;
    private javax.swing.JButton settlePaymentButton;
    private javax.swing.JMenu stockMenu;
    private javax.swing.JButton updateStockButton;
    private javax.swing.JMenuItem updateStockMenuItem;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables

    public class NotificationFinder extends Thread{
        private SimpleDateFormat dateFormat;

        @Override
        public void run() {
//           checkDuePayments();
           lowQtyOfItems();
        }

//        private void checkDuePayments() {
//            Calendar calendar = Calendar.getInstance();
//            Date toDate = calendar.getTime();
//            calendar.add(Calendar.DAY_OF_MONTH, -3);
//            Date fromDate = calendar.getTime();
//        }

        private void lowQtyOfItems() {
            try {
                ArrayList<Item> dueReOrderingItems = ServerConnector.getServerConnector().getItemController().getDueReOrderingItems();
                
            } catch (RemoteException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
