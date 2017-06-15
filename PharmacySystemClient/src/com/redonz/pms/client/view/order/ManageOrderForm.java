/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.view.order;

import com.redonz.pms.client.connector.ServerConnector;
import com.redonz.pms.client.observer.OrderObserver;
import com.redonz.pms.client.view.customer.AddCustomerForm;
import com.redonz.pms.client.view.payment.SettlePaymentForm;
import com.redonz.pms.common.controller.CustomerOrderController;
import com.redonz.pms.common.model.Customer;
import com.redonz.pms.common.model.CustomerOrder;
import com.redonz.pms.common.model.CustomerOrderDetail;
import com.redonz.pms.common.model.ObserverTO;
import com.redonz.pms.common.model.Payment;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DI_SH
 */
public class ManageOrderForm extends javax.swing.JDialog {

    private final int SEARCH_BY_ORDER_ID = 1;
    private final int SEARCH_BY_CUSTOMER = 2;
    private final int SEARCH_BY_DATE = 3;
    private final int SEARCH_BY_DATE_RANGE = 4;
    private int searchIndex;
    private boolean loadCustomerComplete;
    private DefaultTableModel orderModel;
    private DefaultTableModel orderDetailModel;
    private String currentReservedID;
    private SimpleDateFormat simpleDateFormat;
    private Date date;
    private CustomerOrderController customerOrderController;
    private OrderObserver orderObserver;
    private int row;

    /**
     * Creates new form ManageOrderForm
     */
    public ManageOrderForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            orderObserver = new OrderObserver(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setLocationRelativeTo(null);
        date = new Date();
        orderModel = (DefaultTableModel) orderTable.getModel();
        orderDetailModel = (DefaultTableModel) orderDetailTable.getModel();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            loadCustomersToComboBox();
        } catch (NotBoundException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            customerOrderController = ServerConnector.getServerConnector().getCustomerOrderController();
            customerOrderController.addObserver(orderObserver);
        } catch (RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ManageOrderForm(Dialog owner, boolean modal, String custId) {
        super(owner, modal);
        try {
            orderObserver = new OrderObserver(this);
        } catch (RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setLocationRelativeTo(null);
        date = new Date();
        orderModel = (DefaultTableModel) orderTable.getModel();
        orderDetailModel = (DefaultTableModel) orderDetailTable.getModel();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            loadCustomersToComboBox();
        } catch (NotBoundException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            customerOrderController = ServerConnector.getServerConnector().getCustomerOrderController();
        } catch (RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < customerComboBox.getItemCount(); i++) {
            if (((Customer) customerComboBox.getItemAt(i)).getCustId().equals(custId)) {
                customerComboBox.setSelectedIndex(i);
                break;

            }
        }
        seachByCustomer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        orderIdTextField = new javax.swing.JTextField();
        customerComboBox = new javax.swing.JComboBox();
        orderIdLabel = new javax.swing.JLabel();
        customerLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderDetailTable = new javax.swing.JTable();
        orderDateLabel = new javax.swing.JLabel();
        orderDatePicker = new org.jdesktop.swingx.JXDatePicker();
        dateRangeCheckBox = new javax.swing.JCheckBox();
        endOrderDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        paymentHistoryButton = new javax.swing.JButton();
        onlyUnsettledCheckBox = new javax.swing.JCheckBox();
        msgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(247, 247, 247));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(102, 102, 102));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Manage Orders");
        titleLabel.setOpaque(true);

        closeButton.setBackground(new java.awt.Color(255, 153, 153));
        closeButton.setText("Close");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
        });
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        orderIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIdTextFieldActionPerformed(evt);
            }
        });
        orderIdTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderIdTextFieldFocusGained(evt);
            }
        });
        orderIdTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                orderIdTextFieldKeyReleased(evt);
            }
        });

        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerComboBoxItemStateChanged(evt);
            }
        });
        customerComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerComboBoxFocusGained(evt);
            }
        });

        orderIdLabel.setText("Order ID : ");

        customerLabel.setText("Customer :");

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Orders"));

        orderTable.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cust ID", "Order ID", "Date", "Amount", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.setRowHeight(25);
        orderTable.setSelectionBackground(new java.awt.Color(0, 153, 153));
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        orderTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orderTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Order Details"));

        orderDetailTable.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        orderDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch No", "Description", "Unit Price", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderDetailTable.setFocusable(false);
        orderDetailTable.setRowHeight(25);
        orderDetailTable.setSelectionBackground(new java.awt.Color(0, 153, 153));
        orderDetailTable.getTableHeader().setReorderingAllowed(false);
        orderDetailTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orderDetailTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(orderDetailTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        orderDateLabel.setText("Order Date :");

        orderDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDatePickerActionPerformed(evt);
            }
        });
        orderDatePicker.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderDatePickerFocusGained(evt);
            }
        });

        dateRangeCheckBox.setText("Use date range");
        dateRangeCheckBox.setEnabled(false);
        dateRangeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateRangeCheckBoxActionPerformed(evt);
            }
        });

        endOrderDatePicker1.setEnabled(false);
        endOrderDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endOrderDatePicker1ActionPerformed(evt);
            }
        });
        endOrderDatePicker1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                endOrderDatePicker1FocusGained(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        paymentHistoryButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        paymentHistoryButton.setText("Payment Histrory");
        paymentHistoryButton.setEnabled(false);

        onlyUnsettledCheckBox.setText("Unsettled orders only");
        onlyUnsettledCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlyUnsettledCheckBoxActionPerformed(evt);
            }
        });

        msgLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        msgLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(orderIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(onlyUnsettledCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orderDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateRangeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endOrderDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator2)))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(401, 401, 401)
                                                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(paymentHistoryButton)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateRangeCheckBox)
                    .addComponent(endOrderDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderDateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(onlyUnsettledCheckBox))
                    .addComponent(msgLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paymentHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        closeButton.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        closeButton.setBackground(new Color(255, 153, 153));
    }//GEN-LAST:event_closeButtonMouseExited

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void orderIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIdTextFieldActionPerformed
    }//GEN-LAST:event_orderIdTextFieldActionPerformed

    private void orderIdTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderIdTextFieldFocusGained
        searchIndex = 1;
    }//GEN-LAST:event_orderIdTextFieldFocusGained

    private void orderIdTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderIdTextFieldKeyReleased
    }//GEN-LAST:event_orderIdTextFieldKeyReleased

    private void customerComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerComboBoxItemStateChanged
        if (loadCustomerComplete) {
            seachByCustomer();
        }
    }//GEN-LAST:event_customerComboBoxItemStateChanged

    private void customerComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerComboBoxFocusGained
        searchIndex = SEARCH_BY_CUSTOMER;
    }//GEN-LAST:event_customerComboBoxFocusGained

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        try {
            int selectedRow = orderTable.getSelectedRow();
            String orderId = (String) orderModel.getValueAt(selectedRow, 1);

            String custId = (String) orderModel.getValueAt(selectedRow, 0);
            for (int i = 0; i < customerComboBox.getItemCount(); i++) {
                if (customerComboBox.getItemAt(i).toString().contains(custId)) {
                    customerComboBox.setSelectedIndex(i);
                    break;
                }
            }

            paymentHistoryButton.setEnabled(true);

            ArrayList<CustomerOrderDetail> orderDetails = ServerConnector.getServerConnector().getCustomerOderDetailController().getOrderDetailsByOrderId(orderId);
            fillOrderDetailTable(orderDetails);



        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_orderTableMouseClicked

    private void orderTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderTableKeyPressed
    }//GEN-LAST:event_orderTableKeyPressed

    private void orderDetailTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderDetailTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderDetailTableKeyPressed

    private void orderDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderDatePickerActionPerformed
        dateRangeCheckBox.setEnabled(orderDatePicker.getDate() != null);
        if (!dateRangeCheckBox.isSelected()) {
            searchByDate();
        } else {
            searchDateRange();
        }
    }//GEN-LAST:event_orderDatePickerActionPerformed

    private void orderDatePickerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderDatePickerFocusGained
    }//GEN-LAST:event_orderDatePickerFocusGained

    private void dateRangeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateRangeCheckBoxActionPerformed

        endOrderDatePicker1.setEnabled(dateRangeCheckBox.isSelected());
        endOrderDatePicker1.setDate(date);
        if (dateRangeCheckBox.isSelected()) {
            searchIndex = SEARCH_BY_DATE_RANGE;
        } else {
            searchIndex = SEARCH_BY_DATE;
        }
    }//GEN-LAST:event_dateRangeCheckBoxActionPerformed

    private void endOrderDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endOrderDatePicker1ActionPerformed


        searchDateRange();
    }//GEN-LAST:event_endOrderDatePicker1ActionPerformed

    private void endOrderDatePicker1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_endOrderDatePicker1FocusGained
    }//GEN-LAST:event_endOrderDatePicker1FocusGained

    private void onlyUnsettledCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlyUnsettledCheckBoxActionPerformed
        switch (searchIndex) {
            case SEARCH_BY_ORDER_ID:

                break;
            case SEARCH_BY_CUSTOMER:
                seachByCustomer();
                break;
            case SEARCH_BY_DATE:
                searchByDate();
                break;
            case SEARCH_BY_DATE_RANGE:
                searchDateRange();
                break;

        }
    }//GEN-LAST:event_onlyUnsettledCheckBoxActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            customerOrderController.removeObserver(orderObserver);
        } catch (RemoteException ex) {
            Logger.getLogger(ManageOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ManageOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ManageOrderForm dialog = new ManageOrderForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox customerComboBox;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JCheckBox dateRangeCheckBox;
    private org.jdesktop.swingx.JXDatePicker endOrderDatePicker1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JCheckBox onlyUnsettledCheckBox;
    private javax.swing.JLabel orderDateLabel;
    private org.jdesktop.swingx.JXDatePicker orderDatePicker;
    private javax.swing.JTable orderDetailTable;
    private javax.swing.JLabel orderIdLabel;
    private javax.swing.JTextField orderIdTextField;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton paymentHistoryButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    private void loadCustomersToComboBox() throws NotBoundException, RemoteException, SQLException, MalformedURLException, ClassNotFoundException, FileNotFoundException, IOException {
        loadCustomerComplete = false;
        ArrayList<Customer> allCustomers = ServerConnector.getServerConnector().getCustomerController().getAllCustomers();
        customerComboBox.removeAllItems();
        customerComboBox.addItem("<select customer>");
        for (Customer customer : allCustomers) {
            customerComboBox.addItem(customer);
        }
        loadCustomerComplete = true;
    }

    private void seachByCustomer() {
        if (customerComboBox.getSelectedItem() instanceof Customer) {
            String custId = ((Customer) customerComboBox.getSelectedItem()).getCustId();
            try {
                ArrayList<CustomerOrder> ordersByCustId = null;
                if (onlyUnsettledCheckBox.isSelected()) {
                    ordersByCustId = ServerConnector.getServerConnector().getCustomerOrderController().getUnsettledOrdersByCustId(custId);
                } else {
                    ordersByCustId = ServerConnector.getServerConnector().getCustomerOrderController().getOrdersByCustId(custId);
                }
                fillOrderTable(ordersByCustId);
            } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(SettlePaymentForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            checkOrderTable();
        }

    }

    private void checkOrderTable() {
        boolean b = orderTable.getRowCount() > 0;

        paymentHistoryButton.setEnabled(b);
        if (!b) {
            new Thread() {
                @Override
                public void run() {
                    if (onlyUnsettledCheckBox.isSelected()) {
                        msgLabel.setText("No any un settled orders found...");
                    } else {
                        msgLabel.setText("No any orders found...");
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SettlePaymentForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    msgLabel.setText("");
                }
            }.start();
        }
    }

    private void fillOrderDetailTable(ArrayList<CustomerOrderDetail> orderDetails) throws NotBoundException, MalformedURLException, RemoteException, SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        orderDetailModel.setRowCount(0);
        for (CustomerOrderDetail customerOrderDetail : orderDetails) {
            String desc = ServerConnector.getServerConnector().getBatchItemController().getItemByItemCode(customerOrderDetail.getItemCode()).getDescription();
            orderDetailModel.addRow(new Object[]{customerOrderDetail.getBatchNo(), desc, customerOrderDetail.getUnitprice(), customerOrderDetail.getQty()});
        }
    }

    private void searchByDate() {
        Date date = orderDatePicker.getDate();
        String orderDate = simpleDateFormat.format(date);
        try {
            ArrayList<CustomerOrder> ordersByOrderDate = null;
            if (onlyUnsettledCheckBox.isSelected()) {
                ordersByOrderDate = ServerConnector.getServerConnector().getCustomerOrderController().getUnsettledOrdersByOrderDate(orderDate);
            } else {
                ordersByOrderDate = ServerConnector.getServerConnector().getCustomerOrderController().getOrdersByOrderDate(orderDate);
            }
            fillOrderTable(ordersByOrderDate);

        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SettlePaymentForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        checkOrderTable();
    }

    private void searchDateRange() {
        Date bDate = orderDatePicker.getDate();
        Date eDate = endOrderDatePicker1.getDate();
        if (bDate.compareTo(eDate) < 0) {
            String biginDate = simpleDateFormat.format(bDate);
            String endDate = simpleDateFormat.format(eDate);
            try {
                ArrayList<CustomerOrder> orders = null;
                if (onlyUnsettledCheckBox.isSelected()) {
                    orders = ServerConnector.getServerConnector().getCustomerOrderController().getUnsettledOrdersByDateRange(biginDate, endDate);
                } else {
                    orders = ServerConnector.getServerConnector().getCustomerOrderController().getOrdersByDateRange(biginDate, endDate);
                }
                fillOrderTable(orders);

            } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(SettlePaymentForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
//            new Thread() {
//                @Override
//                public void run() {
//
//                    msgLabel.setText("Invalid Date range...");
//
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(SettlePaymentForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    msgLabel.setText("");
//                }
//            }.start();
            endOrderDatePicker1.setDate(bDate);
        }

//        paymentRecievedTextField.setEditable(orderTable.getRowCount() > 0);
        paymentHistoryButton.setEnabled(orderTable.getRowCount() > 0);
        checkOrderTable();
    }

    private void fillOrderTable(ArrayList<CustomerOrder> orders) {

        orderModel.setRowCount(0);
        for (CustomerOrder customerOrder : orders) {
            orderModel.addRow(new Object[]{customerOrder.getCustId(), customerOrder.getOrderId(), customerOrder.getDate(), customerOrder.getTotalAmount(), customerOrder.getBalance()});
        }
    }

    public void notifyChanges(ObserverTO observerTO) {
        if (observerTO.getObj() instanceof CustomerOrder) {
        } else if (observerTO.getObj() instanceof Payment) {
            Payment payment = (Payment) observerTO.getObj();

            for (int i = 0; i < orderTable.getRowCount(); i++) {
                if (orderTable.getValueAt(i, 1).equals(payment.getOrderId())) {
                    row = i;
                    orderTable.setValueAt(((Double) orderTable.getValueAt(i, 4)) - payment.getAmount(), i, 4);
                    break;
                }
            }

            orderTable.repaint();
            JOptionPane.showMessageDialog(this, "Payment done for order : " + payment.getOrderId());
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SettlePaymentForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    row = -1;
                    orderTable.repaint();
                }
            }.start();

        }
    }

    class MyRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(null);
            setForeground(Color.BLACK);
            Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            if (row == ManageOrderForm.this.row) {

                setBackground(new Color(255, 153, 153));
                setForeground(Color.WHITE);

            }

            return tableCellRendererComponent;
        }
    }
}
