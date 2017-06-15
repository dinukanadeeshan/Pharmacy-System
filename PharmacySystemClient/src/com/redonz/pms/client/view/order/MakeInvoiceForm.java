 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redonz.pms.client.view.order;

//<editor-fold defaultstate="collapsed" desc="Import Statements">
import com.redonz.pms.client.view.payment.CustomerPaymentForm;
import com.redonz.pms.client.connector.ServerConnector;
import com.redonz.pms.client.observer.BatchItemObserver;
import com.redonz.pms.client.view.ChangeDateForm;
import com.redonz.pms.client.view.item.UpdateStockForm;
import com.redonz.pms.common.controller.HoldOrderController;
import com.redonz.pms.common.model.BatchItem;
import com.redonz.pms.common.model.Customer;
import com.redonz.pms.common.model.Item;
import java.awt.Color;
import java.awt.Component;
import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import com.redonz.pms.client.others.ComboSearchNew;
import com.redonz.pms.client.others.IDGen;
import com.redonz.pms.client.others.Validation;
import com.redonz.pms.client.view.customer.AddCustomerForm;
import com.redonz.pms.client.view.item.SearchItemForm;
import com.redonz.pms.common.model.CustomerOrder;
import com.redonz.pms.common.model.CustomerOrderDetail;
import com.redonz.pms.common.model.HoldOrder;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
//</editor-fold>

/**
 *
 * @author Nadeeshan
 */
public class MakeInvoiceForm extends javax.swing.JDialog {

    private boolean closed = false;
    private DefaultTableModel dtm;
    private boolean fillingItemCompleted;
    private boolean inFocus;
    private boolean fillingCustomerCompleted;
    private int existRow;
    private double total;
    private double qtyOnHand;
    private String barcode;
    private String itemCode;
    private BatchItemObserver batchItemObserver;
    private String orderId;

    /**
     * Creates new form MakeInvoiceForm
     */
    public MakeInvoiceForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            batchItemObserver = new BatchItemObserver(this);
        } catch (RemoteException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setLocationRelativeTo(null);
        try {
            dateLabel.setText(ServerConnector.getServerConnector().getDateController().getCurrentDate());
        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getMessage().contains("Connection refused to host")) {
                JOptionPane.showMessageDialog(this, "Connection has corrupt or no server started....", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        dtm = (DefaultTableModel) itemTable.getModel();
        itemTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        timeLabel.setText(ServerConnector.getServerConnector().getDateController().getCurrentTime());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (closed) {
                            throw new UnsupportedOperationException("This is not concerable error....");
                        }
                    }

                } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();

        new ComboSearchNew().setSearchableCombo(customerComboBox, "No Customer Found...", barcodeTextField);
        new ComboSearchNew().setSearchableCombo(itemComboBox, "No Item Found...", barcodeTextField);
        try {
            fillCustomerComboBox();
            fillItemComboBox();
        } catch (NotBoundException | MalformedURLException | SQLException | ClassNotFoundException | RemoteException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        barcodeTextField.requestFocus();
        try {
            ServerConnector.getServerConnector().getBatchItemController().addBatchItemObserver(batchItemObserver);
        } catch (RemoteException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel1 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        totalAmountTextField = new javax.swing.JTextField();
        holdButton = new javax.swing.JButton();
        continueHoldButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        barcodeTextField = new javax.swing.JTextField();
        itemComboBox = new javax.swing.JComboBox();
        qtyOnHandTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        qtyTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        unitPriceTextField = new javax.swing.JTextField();
        batchNoTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        batchNoLabel = new javax.swing.JLabel();
        itemNameTextField = new javax.swing.JTextField();
        removeButton = new javax.swing.JButton();
        barcodeLabel = new javax.swing.JLabel();
        expDateTextField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        barcodeLabel1 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        customerComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(247, 247, 247));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(102, 102, 102));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("New Invoice");
        titleLabel.setOpaque(true);

        jLabel1.setText("Date :");

        dateLabel.setBackground(new java.awt.Color(204, 204, 204));
        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dateLabel.setOpaque(true);
        dateLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dateLabelMouseExited(evt);
            }
        });

        jLabel3.setText("Time :");

        timeLabel.setBackground(new java.awt.Color(204, 204, 204));
        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setOpaque(true);

        saveButton.setBackground(new java.awt.Color(102, 204, 255));
        saveButton.setText("Payment >");
        saveButton.setEnabled(false);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveButtonMouseExited(evt);
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 153, 153));
        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButtonMouseExited(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Barcode", "Batch No", "Exp Date", "Unit Price", "Qty", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        itemTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                itemTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);
        itemTable.getColumnModel().getColumn(0).setMinWidth(0);
        itemTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        itemTable.getColumnModel().getColumn(0).setMaxWidth(0);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Total :");

        totalAmountTextField.setEditable(false);
        totalAmountTextField.setBackground(new java.awt.Color(255, 255, 255));
        totalAmountTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalAmountTextField.setForeground(new java.awt.Color(0, 51, 0));
        totalAmountTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalAmountTextField.setFocusable(false);
        totalAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmountTextFieldActionPerformed(evt);
            }
        });

        holdButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        holdButton.setText("Hold Invoice");
        holdButton.setEnabled(false);
        holdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holdButtonActionPerformed(evt);
            }
        });

        continueHoldButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        continueHoldButton.setText("<html><center>Continue<br>Hold Invoice</center></html>");
        continueHoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueHoldButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item Detail", 0, 0, new java.awt.Font("Times New Roman", 3, 10))); // NOI18N

        jLabel4.setText("Item  : ");

        barcodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeTextFieldActionPerformed(evt);
            }
        });
        barcodeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                barcodeTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                barcodeTextFieldFocusLost(evt);
            }
        });
        barcodeTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                barcodeTextFieldCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                barcodeTextFieldInputMethodTextChanged(evt);
            }
        });
        barcodeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                barcodeTextFieldKeyReleased(evt);
            }
        });

        itemComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemComboBoxItemStateChanged(evt);
            }
        });
        itemComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComboBoxActionPerformed(evt);
            }
        });

        qtyOnHandTextField.setEditable(false);
        qtyOnHandTextField.setFocusable(false);

        jLabel6.setText("Qty :");

        addButton.setBackground(new java.awt.Color(153, 248, 224));
        addButton.setText("Add");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        qtyTextField.setEditable(false);
        qtyTextField.setText("1");
        qtyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyTextFieldActionPerformed(evt);
            }
        });
        qtyTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                qtyTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                qtyTextFieldFocusLost(evt);
            }
        });
        qtyTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyTextFieldKeyReleased(evt);
            }
        });

        jLabel7.setText("Exp Date : ");

        jLabel8.setText("Qty On Hand :");

        unitPriceTextField.setEditable(false);
        unitPriceTextField.setFocusable(false);

        batchNoTextField.setEditable(false);
        batchNoTextField.setFocusable(false);
        batchNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchNoTextFieldActionPerformed(evt);
            }
        });
        batchNoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                batchNoTextFieldKeyReleased(evt);
            }
        });

        jLabel5.setText("Unit Price :");

        jLabel2.setText("Item :");

        batchNoLabel.setText("Batch No :");

        itemNameTextField.setEditable(false);
        itemNameTextField.setFocusable(false);

        removeButton.setBackground(new java.awt.Color(255, 153, 153));
        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        barcodeLabel.setText("Barcode : ");

        expDateTextField.setEditable(false);
        expDateTextField.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(barcodeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(barcodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(batchNoLabel)
                                .addGap(18, 18, 18)
                                .addComponent(batchNoTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(expDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(unitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qtyOnHandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcodeLabel)
                    .addComponent(barcodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(unitPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batchNoLabel)
                    .addComponent(batchNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(expDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(qtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(qtyOnHandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Detail", 0, 0, new java.awt.Font("Times New Roman", 3, 10))); // NOI18N

        barcodeLabel1.setText("Customer :");

        addressTextField.setEditable(false);
        addressTextField.setFocusable(false);

        jLabel10.setText("Address :");

        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barcodeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barcodeLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(holdButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(continueHoldButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(saveButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(totalAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(holdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(continueHoldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
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

    private void dateLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateLabelMouseEntered
        dateLabel.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_dateLabelMouseEntered

    private void dateLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateLabelMouseClicked
        new ChangeDateForm(this, true, dateLabel.getText(), evt.getXOnScreen() - 50, evt.getYOnScreen() - 50).setVisible(true);
    }//GEN-LAST:event_dateLabelMouseClicked

    private void dateLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateLabelMouseExited
        dateLabel.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_dateLabelMouseExited

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        closed = true;
    }//GEN-LAST:event_formWindowClosed

    private void saveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseExited
        saveButton.setBackground(new Color(153, 204, 255));
    }//GEN-LAST:event_saveButtonMouseExited

    private void saveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseEntered
        saveButton.setBackground(new Color(102, 204, 255));
    }//GEN-LAST:event_saveButtonMouseEntered

    private void cancelButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseExited
        cancelButton.setBackground(new Color(255, 153, 153));
    }//GEN-LAST:event_cancelButtonMouseExited

    private void cancelButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseEntered
        cancelButton.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_cancelButtonMouseEntered

    private void barcodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeTextFieldActionPerformed
        barcode = barcodeTextField.getText();
        searchItemByBarcode();
    }//GEN-LAST:event_barcodeTextFieldActionPerformed

    private void barcodeTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barcodeTextFieldFocusGained
        inFocus = true;
    }//GEN-LAST:event_barcodeTextFieldFocusGained

    private void barcodeTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_barcodeTextFieldInputMethodTextChanged
    }//GEN-LAST:event_barcodeTextFieldInputMethodTextChanged

    private void barcodeTextFieldCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_barcodeTextFieldCaretPositionChanged
    }//GEN-LAST:event_barcodeTextFieldCaretPositionChanged

    private void barcodeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodeTextFieldKeyReleased
        String text = barcodeTextField.getText();
        Validation.validateBarcodeText(barcodeTextField);
        for (int i = 0; i < itemComboBox.getItemCount(); i++) {
            Object selectedItem = itemComboBox.getSelectedItem();
            if (selectedItem instanceof BatchItem) {
                BatchItem bi = (BatchItem) selectedItem;
                if (bi.getBarCode().startsWith(text)) {
                    itemComboBox.setSelectedIndex(i);
                    break;
                }
            }
        }

    }//GEN-LAST:event_barcodeTextFieldKeyReleased

    private void qtyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyTextFieldActionPerformed
        addButton.doClick();

    }//GEN-LAST:event_qtyTextFieldActionPerformed

    private void qtyTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyTextFieldFocusLost
        if (qtyTextField.getText().isEmpty() || qtyTextField.getText() == null) {
            qtyTextField.setText("1");
        }
    }//GEN-LAST:event_qtyTextFieldFocusLost

    private void qtyTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyTextFieldKeyReleased
        String text = qtyTextField.getText();

        int caretPosition = qtyTextField.getCaretPosition();
        if (!text.matches("^[0-9]{0,7}$")) {
            text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
            caretPosition--;
        }
        System.out.println(text);
        if (!text.isEmpty()) {
            double qty = Double.parseDouble(text);
            if (qty > qtyOnHand) {
                text = text.substring(0, caretPosition - 1) + text.substring(caretPosition);
                caretPosition--;
            }
        }
        qtyTextField.setText(text);
        qtyOnHandTextField.setCaretPosition(caretPosition);
    }//GEN-LAST:event_qtyTextFieldKeyReleased

    private void batchNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchNoTextFieldActionPerformed
    }//GEN-LAST:event_batchNoTextFieldActionPerformed

    private void batchNoTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_batchNoTextFieldKeyReleased
    }//GEN-LAST:event_batchNoTextFieldKeyReleased

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        for (int i = 0; i < itemTable.getSelectedRowCount(); i++) {
            int selectedRow = itemTable.getSelectedRow();
            dtm.removeRow(selectedRow);
            try {
                ServerConnector.getServerConnector().getBatchItemController().releaseBatchItem((String) itemTable.getValueAt(selectedRow, 0));
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int rowCount = itemTable.getRowCount();
        saveButton.setEnabled(rowCount > 0);
        holdButton.setEnabled(rowCount > 0);
        continueHoldButton.setEnabled(rowCount == 0);
        removeButton.setEnabled(false);

    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String batchNo = batchNoTextField.getText();
        boolean isExist = false;

        for (int i = 0; i < itemTable.getRowCount(); i++) {
            String bn = (String) itemTable.getValueAt(i, 1);
            String bc = (String) itemTable.getValueAt(i, 0);
            if (bn.equals(batchNo)&& bc.equals(barcode)) {
                isExist = true;
                existRow = i;
                break;
            }
        }

        if (isExist) {
            itemTable.repaint();
            int res = JOptionPane.showConfirmDialog(this, "Item Already Exist. Do you want to replace qty... ?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                dtm.setValueAt(qtyTextField.getText(), existRow, 4);
            }
            existRow = -1;
            itemTable.repaint();

        } else {


            double unitPrice = Double.parseDouble(unitPriceTextField.getText());
            double qty = Double.parseDouble(qtyTextField.getText());
            String expDate = expDateTextField.getText();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//            Exp date comparing


            dtm.addRow(new Object[]{itemCode, barcodeTextField.getText(), batchNo, expDate, unitPrice, qty, qty * unitPrice});
            setTotalTextFieldValue();
            setTextFieldsEmpty();
        }
        int rowCount = itemTable.getRowCount();
        saveButton.setEnabled(rowCount > 0);
        holdButton.setEnabled(rowCount > 0);
        continueHoldButton.setEnabled(rowCount == 0);
    }//GEN-LAST:event_addButtonActionPerformed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        removeButton.setEnabled(true);
        if (evt.getClickCount() == 2) {
            editRow(itemTable.getSelectedRow());
        }
    }//GEN-LAST:event_itemTableMouseClicked

    private void itemTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_itemTablePropertyChange
    }//GEN-LAST:event_itemTablePropertyChange

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
//            String orderId = IDGen.getNextId(ServerConnector.getServerConnector().getCustomerOrderController().getLastOrderId());
            orderId = ServerConnector.getServerConnector().getCustomerOrderController().getNextOrderId();
            String custId = ((Customer) customerComboBox.getSelectedItem()).getCustId();
            String date = dateLabel.getText();
            ArrayList<CustomerOrderDetail> customerOrderDetails = new ArrayList<>();
            for (int i = 0; i < itemTable.getRowCount(); i++) {
                String itemCode = (String) itemTable.getValueAt(i, 0);
                String barcode = (String) itemTable.getValueAt(i, 1);
                String batchNo = (String) itemTable.getValueAt(i, 2);
                String expDate = (String) itemTable.getValueAt(i, 3);
                Double unitPrice = (Double) itemTable.getValueAt(i, 4);
                Double qty = (Double) itemTable.getValueAt(i, 5);
                System.out.println(itemCode);
                customerOrderDetails.add(new CustomerOrderDetail(itemCode, orderId, qty, unitPrice, expDate));
            }
            CustomerOrder customerOrder = new CustomerOrder(custId, orderId, date, total, total, 0, customerOrderDetails);
            System.out.println("A");
//            batchItemObserver.setChanged(true);
//            boolean res = ServerConnector.getServerConnector().getCustomerOrderController().saveCustomerOrder(customerOrder);
//            if (res) {
            System.out.println("B");

            new CustomerPaymentForm(this, true, total, orderId, customerComboBox.getSelectedIndex(), customerOrder).setVisible(true);


//            }
        } catch (NotBoundException | MalformedURLException | RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void itemComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComboBoxActionPerformed
        if (fillingItemCompleted) {
            Object selectedItem = itemComboBox.getSelectedItem();
            if (selectedItem instanceof Item) {
                Item i = (Item) selectedItem;
                barcode = i.getBarcode();
                barcodeTextField.setText(barcode);
                searchItemByBarcode();
            }
        }
    }//GEN-LAST:event_itemComboBoxActionPerformed

    private void barcodeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barcodeTextFieldFocusLost
        inFocus = false;
    }//GEN-LAST:event_barcodeTextFieldFocusLost

    private void itemComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemComboBoxItemStateChanged
        if (!inFocus && fillingItemCompleted) {
            if (itemComboBox.getSelectedItem() instanceof BatchItem) {
                BatchItem bi = (BatchItem) itemComboBox.getSelectedItem();
                barcodeTextField.setText(bi.getBarCode());
            }
        }
    }//GEN-LAST:event_itemComboBoxItemStateChanged

    private void totalAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmountTextFieldActionPerformed

    private void continueHoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueHoldButtonActionPerformed
        ViewHoldOrderForm holdOrderForm = new ViewHoldOrderForm(this, true);
        holdOrderForm.setVisible(true);
    }//GEN-LAST:event_continueHoldButtonActionPerformed

    private void holdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holdButtonActionPerformed
        try {
            int res = JOptionPane.showConfirmDialog(this, "Are you sure want to hold...?", "", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                HoldOrderController holdOrderController = ServerConnector.getServerConnector().getHoldOrderController();
                int lastHoldOrderId = holdOrderController.getLastHoldOrderId();
                ArrayList<CustomerOrderDetail> customerOrderDetails = new ArrayList<>();
                for (int i = 0; i < itemTable.getRowCount(); i++) {
                    String itemCode = (String) itemTable.getValueAt(i, 0);
                    String barcode = (String) itemTable.getValueAt(i, 1);
                    String batchNo = (String) itemTable.getValueAt(i, 2);
                    String expDate = (String) itemTable.getValueAt(i, 3);
                    Double unitPrice = (Double) itemTable.getValueAt(i, 4);
                    Double qty = (Double) itemTable.getValueAt(i, 5);
                    customerOrderDetails.add(new CustomerOrderDetail(itemCode, lastHoldOrderId + 1 + "", batchNo, qty, unitPrice, expDate));
                }
                holdOrderController.addHoldOrder(new HoldOrder(lastHoldOrderId + 1, ((Customer) customerComboBox.getSelectedItem()).getCustId(), customerOrderDetails));
                setTextFieldsEmpty();
                dtm.setRowCount(0);
                totalAmountTextField.setText("");
                continueHoldButton.setEnabled(true);
            }
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_holdButtonActionPerformed

    private void customerComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerComboBoxItemStateChanged
        if (fillingCustomerCompleted) {
//            String custId = ((String) customerComboBox.getSelectedItem()).split("[ - ]")[0];
//            try {
//                Customer customer = ServerConnector.getServerConnector().getCustomerController().searchCustomer(custId);
//                addressTextField.setText(customer.getAddress());
//            } catch (    NotBoundException | MalformedURLException | SQLException | ClassNotFoundException ex) {
//                Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (RemoteException ex) {
//                Logger.getLogger(UpdateStockForm.class
//                        .getName()).log(Level.SEVERE, null, ex);
//            }
            Customer customer = (Customer) customerComboBox.getSelectedItem();
            addressTextField.setText(customer.getAddress());
        }
    }//GEN-LAST:event_customerComboBoxItemStateChanged

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
    }//GEN-LAST:event_saveButtonMouseClicked

    private void qtyTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyTextFieldFocusGained
        qtyOnHand = Double.parseDouble(qtyOnHandTextField.getText());
        qtyTextField.selectAll();
    }//GEN-LAST:event_qtyTextFieldFocusGained

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (itemTable.getRowCount() > 0) {
            int res = JOptionPane.showConfirmDialog(this, "Order doesn't completed. Do you want to hold this order?");
            if (res == JOptionPane.YES_OPTION) {
                holdButton.doClick();
                dispose();
            } else if (res == JOptionPane.NO_OPTION) {
                dispose();
            }

        } else {
            dispose();
        }

    }//GEN-LAST:event_cancelButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (itemTable.getRowCount() > 0) {
            int res = JOptionPane.showConfirmDialog(this, "Order doesn't completed. Do you want to hold this order?");
            if (res == JOptionPane.YES_OPTION) {
                holdButton.doClick();
                dispose();
            } else if (res == JOptionPane.NO_OPTION) {
                dispose();
            }

        } else {
            dispose();
        }
        try {
            ServerConnector.getServerConnector().getBatchItemController().removeObserver(batchItemObserver);
        } catch (RemoteException ex) {
            Logger.getLogger(SearchItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(SearchItemForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SearchItemForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeInvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MakeInvoiceForm dialog = new MakeInvoiceForm(new javax.swing.JFrame(), true);

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
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel barcodeLabel;
    private javax.swing.JLabel barcodeLabel1;
    private javax.swing.JTextField barcodeTextField;
    private javax.swing.JLabel batchNoLabel;
    private javax.swing.JTextField batchNoTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton continueHoldButton;
    private javax.swing.JComboBox customerComboBox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField expDateTextField;
    private javax.swing.JButton holdButton;
    private javax.swing.JComboBox itemComboBox;
    private javax.swing.JTextField itemNameTextField;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField qtyOnHandTextField;
    private javax.swing.JTextField qtyTextField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField totalAmountTextField;
    private javax.swing.JTextField unitPriceTextField;
    // End of variables declaration//GEN-END:variables

    private void fillItemComboBox() {
        fillingItemCompleted = false;
        try {
            ArrayList<Item> allAvailableItems = ServerConnector.getServerConnector().getItemController().getAllAvailableItems();
            itemComboBox.removeAllItems();
            itemComboBox.addItem("<select item>");
            for (Item item : allAvailableItems) {
                itemComboBox.addItem(item);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillingItemCompleted = true;
    }

    private void setTotalTextFieldValue() {
        total = 0.0;
        for (int i = 0; i < itemTable.getRowCount(); i++) {
            Double d = (Double) itemTable.getValueAt(i, 6);
            total += d;
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        totalAmountTextField.setText(currencyInstance.format(total).substring(1));
    }

    private void setTextFieldsEmpty() {
        barcodeTextField.setText("");
        itemNameTextField.setText("");
        qtyOnHandTextField.setText("");
        qtyTextField.setText("1");
        batchNoTextField.setText("");
        expDateTextField.setText("");
        unitPriceTextField.setText("");
        barcode = null;
        itemCode = null;
        barcodeTextField.requestFocus();
        itemComboBox.setSelectedIndex(0);
        qtyTextField.setEditable(false);
        addButton.setEnabled(false);

    }

    private void editRow(int selectedRow) {
        String qty = JOptionPane.showInputDialog(this, "New Qty : ", itemTable.getValueAt(selectedRow, 5));
        if (qty != null) {
            itemTable.setValueAt(Double.parseDouble(qty), selectedRow, 5);
        }
    }

    public void setItemDetail(BatchItem item) throws RemoteException, NotBoundException, SQLException, MalformedURLException, ClassNotFoundException, FileNotFoundException, IOException {
        Item searchItem = ServerConnector.getServerConnector().getItemController().searchItem(barcode);
        itemNameTextField.setText(searchItem.getDescription());
        batchNoTextField.setText(item.getBatchNo());
        unitPriceTextField.setText(item.getUnitPrice() + "");
        expDateTextField.setText(item.getExpDate());
        qtyOnHandTextField.setText(item.getQty() + "");
        qtyTextField.setEditable(true);
        qtyTextField.requestFocus();
        barcode = null;
        saveButton.setEnabled(true);
        addButton.setEnabled(true);
        itemCode = item.getItemCode();

    }

    private void fillCustomerComboBox() throws NotBoundException, MalformedURLException, SQLException, ClassNotFoundException, RemoteException, FileNotFoundException, IOException {
        fillingCustomerCompleted = false;
        customerComboBox.removeAllItems();
        ArrayList<Customer> allCustomers = ServerConnector.getServerConnector().getCustomerController().getAllCustomers();
        for (Customer customer : allCustomers) {
            customerComboBox.addItem(customer);
        }
        fillingCustomerCompleted = true;

    }

    void setOrderDetail(HoldOrder ho) throws SQLException, NotBoundException, ClassNotFoundException, MalformedURLException, RemoteException, FileNotFoundException, IOException {
        setCustomer(ho.getCustId());
        ArrayList<CustomerOrderDetail> customerOrderDetailList = ho.getCustomerOrderDetailList();
        for (CustomerOrderDetail customerOrderDetail : customerOrderDetailList) {
            String itemCode = customerOrderDetail.getItemCode();
            String barcode = ServerConnector.getServerConnector().getBatchItemController().getBarcodeForItemCode(itemCode);
            String batchNo = customerOrderDetail.getBatchNo();
            double unitPrice = customerOrderDetail.getUnitprice();
            double qty = customerOrderDetail.getQty();
            String expDate = customerOrderDetail.getExpDate();
            dtm.addRow(new Object[]{itemCode, barcodeTextField.getText(), batchNo, expDate, unitPrice, qty, qty * unitPrice});
        }
        continueHoldButton.setEnabled(false);
        holdButton.setEnabled(true);
        saveButton.setEnabled(true);
        setTotalTextFieldValue();
    }

    private void setCustomer(String custId) {
        for (int i = 0; i < customerComboBox.getItemCount(); i++) {
            if (customerComboBox.getItemAt(i) instanceof Customer) {
                Customer customer = (Customer) customerComboBox.getItemAt(i);
                if (customer.getCustId().equals(custId)) {
                    customerComboBox.setSelectedIndex(i);
                    break;
                }
            }

        }
    }

    public void refresh() {
        totalAmountTextField.setText("0.00");
        dtm.setRowCount(0);
        saveButton.setEnabled(false);
        holdButton.setEnabled(false);
        continueHoldButton.setEnabled(true);
//        try {
//            batchItemObserver.setChanged(false);
//        } catch (RemoteException ex) {
//            Logger.getLogger(MakeInvoiceForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void searchItemByBarcode() throws HeadlessException {
        try {
            ArrayList<BatchItem> batches = ServerConnector.getServerConnector().getBatchItemController().getAvailableBatchesByBarcode(barcode);
            if (batches.size() > 1) {
                new ChooseBatchItem(this, true, batches).setVisible(true);

            } else if (batches.size() == 1) {

                BatchItem item = batches.get(0);


                setItemDetail(item);
            } else {
                JOptionPane.showMessageDialog(this, "No item found....");
            }
        } catch (ConnectException ex) {
            JOptionPane.showMessageDialog(this, "Server Connection has currupted...");
        } catch (NotBoundException ex) {
            Logger.getLogger(UpdateStockForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(UpdateStockForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(UpdateStockForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateStockForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateStockForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class ItemTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(null);
            Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            if (row == existRow) {
                setBackground(new Color(255, 153, 153));
            }
            return tableCellRendererComponent;
        }
    }
}
