package gui;

import ejb.BouquetOrder;
import ejb.BouquetOrderFactoryBeanRemote;
import ejb.Status;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ejb.ConnectionBeanRemote;

/**
 *
 * @author ShaldNikita
 */
public class Main extends javax.swing.JFrame {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField customerField;
    private javax.swing.JTextField doUntilField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton imgButton;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton insertButton;
    private javax.swing.JCheckBox isReadyCheckButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable mainTable;
    private javax.swing.JTextField pathField;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField spentField;
    private javax.swing.JTextField totalField;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextArea wishesField;
    // End of variables declaration//GEN-END:variables
    @EJB(lookup = "ejb.ConnectionBeanRemote")
    private static ConnectionBeanRemote connection;
    @EJB(lookup = "ejb.BouquetOrderFactoryBeanRemote")
    static BouquetOrderFactoryBeanRemote boFactory;
    
    private Map<Long, BouquetOrder> orders;

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    public Main() {
        orders = new HashMap<>();
        initComponents();
        setResizable(false);
        showValuesInTable();
    }

    private void showValuesInTable() {
        connection.getBouquetOrderList().forEach((p) -> {
            addRowToTable(p);
            orders.put(p.getId(), p);
        });
    }

    private void addRowToTable(BouquetOrder order) {
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.addRow(createNewRow(order));
    }

    private Object[] createNewRow(BouquetOrder order) {
        Object[] row = new Object[9];
        row[0] = order.getId();
        row[1] = order.getCustomer();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd MMMM YYYY");
        row[2] = sdf.format(order.getDoUntil());
        row[3] = order.getQuantity();
        row[4] = order.getWishes();
        row[5] = order.getPrice();
        row[6] = order.getMoneySpent();
        row[7] = order.getTotal();
        row[8] = order.getStatus();

        return row;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        infoPanel = new javax.swing.JPanel();
        imgLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        Label = new javax.swing.JLabel();
        customerField = new javax.swing.JTextField();
        doUntilField = new javax.swing.JTextField();
        Label1 = new javax.swing.JLabel();
        imgButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        wishesField = new javax.swing.JTextArea();
        Label3 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        spentField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        pathField = new javax.swing.JTextField();
        isReadyCheckButton = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 204));

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Заказчик", "Сделать до", "Кол-во", "Пожелания", "Цена", "Потратила", "Итог", "Статус"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainTable.setToolTipText("");
        mainTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        mainTable.setColumnSelectionAllowed(true);
        mainTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainTable.setOpaque(false);
        mainTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        mainTable.getTableHeader().setReorderingAllowed(false);
        mainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        infoPanel.setBackground(new java.awt.Color(231, 250, 188));
        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Информация о заказе"));

        imgLabel.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID");

        idField.setEditable(false);
        idField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label.setText("Заказчик");
        Label.setFocusable(false);

        customerField.setEditable(false);
        customerField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        doUntilField.setEditable(false);
        doUntilField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label1.setText("Сделать до");
        Label1.setFocusable(false);

        imgButton.setText("Прикрепить изображение");
        imgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgButtonActionPerformed(evt);
            }
        });

        wishesField.setColumns(20);
        wishesField.setLineWrap(true);
        wishesField.setRows(5);
        jScrollPane2.setViewportView(wishesField);

        Label3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label3.setText("Пожелания");
        Label3.setFocusable(false);

        Label2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label2.setText("Потратила");
        Label2.setFocusable(false);

        spentField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spentField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spentFieldFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Итог:");
        jLabel1.setFocusable(false);

        totalField.setEditable(false);
        totalField.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(231, 250, 188));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        insertButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        insertButton.setText("Добавить");
        insertButton.setIconTextGap(15);
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        updateButton.setText("Обновить");
        updateButton.setIconTextGap(15);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        removeButton.setText("Удалить");
        removeButton.setIconTextGap(15);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(insertButton)
                                .addGap(2, 2, 2))
                            .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(insertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addGap(45, 45, 45)
                .addComponent(removeButton))
        );

        pathField.setEditable(false);
        pathField.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        pathField.setOpaque(false);

        isReadyCheckButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        isReadyCheckButton.setText("Готово");
        isReadyCheckButton.setOpaque(false);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(71, 71, 71)
                        .addComponent(Label))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Label3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label1)
                            .addComponent(Label2)
                            .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(doUntilField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(infoPanelLayout.createSequentialGroup()
                                    .addComponent(spentField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)
                                    .addComponent(isReadyCheckButton)))
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(imgButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathField))
                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgButton)
                    .addComponent(pathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Label)
                            .addComponent(Label1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doUntilField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label2)
                            .addComponent(Label3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(isReadyCheckButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(spentField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalField, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
            .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addNewOrder(BouquetOrder order) throws Exception {
        connection.addElementToDB(order);
        addRowToTable(order);
        orders.put(order.getId(), order);
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            Optional<String> wishes;
            Optional<Integer> moneySpent;
            Optional<Integer> totalSpent;
            Optional<String> path;

            String wishesText = wishesField.getText();
            String pathText = pathField.getText();
            String spentText = spentField.getText();
            String totalText = totalField.getText();

            if (pathText.equals("")) {
                path = Optional.ofNullable(null);
            } else {
                path = Optional.of(pathText);
            }

            if (wishesText.equals("")) {
                wishes = Optional.ofNullable(null);
            } else {
                wishes = Optional.of(wishesText);
            }

            if (spentText.equals("")) {
                moneySpent = Optional.ofNullable(null);
            } else {
                try {
                    moneySpent = Optional.of(Integer.parseInt(spentText));
                } catch (NumberFormatException e) {
                    moneySpent = Optional.ofNullable(null);
                }
            }

            if (totalText.equals("")) {
                totalSpent = Optional.ofNullable(null);
            } else {
                try {
                    totalSpent = Optional.of(Integer.parseInt(spentText));
                } catch (NumberFormatException e) {
                    totalSpent = Optional.ofNullable(null);
                }
            }

            connection.updateField(Long.parseLong(idField.getText()), wishes, moneySpent,
                    totalSpent, path, isReadyCheckButton.isSelected());

            updateLocalOrderList(Long.parseLong(idField.getText()), wishes, moneySpent,
                    totalSpent, path, isReadyCheckButton.isSelected());

            updateRowInTable();
            JOptionPane.showMessageDialog(null, "Заказ обновлен");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Невозможно обновить заказ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void updateLocalOrderList(Long id, Optional<String> wishes, Optional<Integer> moneySpent, Optional<Integer> total, Optional<String> path, Boolean isReady) {
        BouquetOrder order = orders.get(id);
        order.setWishes(wishes.orElse(null));
        order.setMoneySpent(moneySpent.orElse(null));
        order.setTotal(total.orElse(null));
        order.setImgPath(path.orElse(null));
        order.setStatus(isReady ? Status.Ready : Status.Accepted);
    }

    private void updateRowInTable() {
        mainTable.setValueAt(wishesField.getText(), mainTable.getSelectedRow(), 4);
        mainTable.setValueAt(spentField.getText(), mainTable.getSelectedRow(), 6);
        mainTable.setValueAt(totalField.getText(), mainTable.getSelectedRow(), 7);
        mainTable.setValueAt(isReadyCheckButton.isSelected() ? Status.Ready : Status.Accepted, mainTable.getSelectedRow(), 8);
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        try {
            connection.removeOrder(Long.parseLong(idField.getText()));
            removeSelectedRow();
            clearAllFields();
            JOptionPane.showMessageDialog(null, "Заказ удален");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Невозможно удалить заказ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void removeSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        model.removeRow(getRowIndexWithId(Long.parseLong(idField.getText())));
    }

    private Integer getRowIndexWithId(Long id) {
        DefaultTableModel model = (DefaultTableModel) mainTable.getModel();
        int rows = model.getRowCount();
        for (int i = 0; i < rows; i++) {
            if (id.equals(model.getValueAt(i, 0))) {
                return i;
            }
        }
        return null;
    }

    private void clearAllFields() {
        idField.setText(null);
        totalField.setText(null);
        customerField.setText(null);
        pathField.setText(null);
        spentField.setText(null);
        wishesField.setText(null);
        doUntilField.setText(null);
        imgLabel.setIcon(null);
        isReadyCheckButton.setSelected(false);
    }

    private void mainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTableMouseClicked
        int index = mainTable.getSelectedRow();
        showItemValueInFields(index);
    }//GEN-LAST:event_mainTableMouseClicked

    private void showItemValueInFields(int index) {
        Object id = mainTable.getValueAt(index, 0);
        idField.setText(String.valueOf(id));
        customerField.setText(String.valueOf(mainTable.getValueAt(index, 1)));
        doUntilField.setText(String.valueOf(mainTable.getValueAt(index, 2)));
        wishesField.setText(String.valueOf(mainTable.getValueAt(index, 4)));
        Integer moneySpent = orders.get((Long) id).getMoneySpent();
        if (moneySpent == null) {
            spentField.setText("");
        } else {
            spentField.setText(String.valueOf(moneySpent));
        }
        imgLabel.setIcon(resizeImg(orders.get((Long) mainTable.getValueAt(index, 0)).
                getImgPath() == null ? "noImg" : orders.get((Long) mainTable.getValueAt(index, 0)).
                                getImgPath(),
                new ImageIcon(getClass().getResource("/defImg.jpg")).getImage()));
        pathField.setText(orders.get((Long) id).getImgPath());

        Status status = (Status) mainTable.getValueAt(index, 8);
        isReadyCheckButton.setSelected(status == Status.Ready);
    }

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        new AddDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_insertButtonActionPerformed

    private void imgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        fc.addChoosableFileFilter(filter);
        int result = fc.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imgLabel.setIcon(resizeImg(path, null));
            pathField.setText(path);
        }
    }//GEN-LAST:event_imgButtonActionPerformed

    private void spentFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spentFieldFocusLost
        try {
            if (!spentField.getText().trim().equals("")) {
                Integer spentMoney = Integer.parseInt(spentField.getText());
                totalField.setText(String.valueOf(orders.get(Long.parseLong(idField.getText())).getPrice() - spentMoney));
            }
        } catch (NumberFormatException e) {
        }

    }//GEN-LAST:event_spentFieldFocusLost

    private ImageIcon resizeImg(String imgPath, Image defImg) {
        ImageIcon myImage;
        if (imgPath != null && !imgPath.equals("noImg")) {
            myImage = new ImageIcon(imgPath);
        } else {
            myImage = new ImageIcon(defImg);
        }

        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

}
