/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import ejb.BouquetOrder;
import ejb.Status;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.swing.JOptionPane;
import ejb.BouquetOrderFactoryBeanRemote;

/**
 *
 * @author ShaldNikita
 */
public class AddDialog extends javax.swing.JDialog {
    
    public AddDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        customerField = new javax.swing.JTextField();
        customerLabel = new javax.swing.JLabel();
        quantityComboBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        priceField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        doUntilLabel = new javax.swing.JLabel();
        dayDateField = new javax.swing.JTextField();
        dateField3 = new javax.swing.JTextField();
        yearDateField = new javax.swing.JTextField();
        monthDateField = new javax.swing.JTextField();
        dateField6 = new javax.swing.JTextField();
        wishesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        wishesField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 204));

        customerField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerField.setToolTipText("");

        customerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customerLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        customerLabel.setText("Заказчик:");

        quantityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Кол-во", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        addButton.setText("Добавить");
        addButton.setIconTextGap(15);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        priceField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        priceLabel.setText("Цена:");

        doUntilLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        doUntilLabel.setText("Сделать до:");

        dayDateField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dayDateField.setToolTipText("");

        dateField3.setEditable(false);
        dateField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateField3.setText("\\");
            dateField3.setToolTipText("");
            dateField3.setBorder(null);
            dateField3.setFocusable(false);
            dateField3.setOpaque(false);

            yearDateField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            yearDateField.setText(String.valueOf(Calendar.getInstance().get(1)));
            yearDateField.setToolTipText("");
            yearDateField.setEnabled(false);

            monthDateField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            monthDateField.setToolTipText("");

            dateField6.setEditable(false);
            dateField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
            dateField6.setText("\\");
                dateField6.setToolTipText("");
                dateField6.setBorder(null);
                dateField6.setFocusable(false);
                dateField6.setOpaque(false);

                wishesLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
                wishesLabel.setText("Пожелания:");

                wishesField.setColumns(20);
                wishesField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                wishesField.setLineWrap(true);
                wishesField.setRows(5);
                jScrollPane1.setViewportView(wishesField);

                javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
                mainPanel.setLayout(mainPanelLayout);
                mainPanelLayout.setHorizontalGroup(
                    mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(customerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(wishesLabel)
                                    .addComponent(doUntilLabel)
                                    .addComponent(priceLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(dayDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dateField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(monthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dateField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(yearDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(quantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(97, 97, 97)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                );
                mainPanelLayout.setVerticalGroup(
                    mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doUntilLabel)
                            .addComponent(dayDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(wishesLabel)
                                .addGap(69, 69, 69))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(priceLabel)
                                .addComponent(quantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Main main = (Main) getParent();
        try {
            BouquetOrder newOrder = getOrderFromFields();
            main.addNewOrder(newOrder);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Некорректные данные");
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private BouquetOrder getOrderFromFields() throws Exception {
        BouquetOrder newOrder;
        newOrder = Main.boFactory.getNewBouquetOrder(customerField.getText(), getDateFromFields(), Integer.parseInt((String)quantityComboBox.getSelectedItem()),
                Integer.parseInt(priceField.getText()), null, null, Status.Accepted, wishesField.getText(), null);
        return newOrder;
    }

    private Date getDateFromFields() throws Exception {
        Integer year = Integer.parseInt(yearDateField.getText());
        Integer month = Integer.parseInt(monthDateField.getText());
        Integer day = Integer.parseInt(dayDateField.getText());
        return new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            AddDialog dialog = new AddDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField customerField;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JTextField dateField3;
    private javax.swing.JTextField dateField6;
    private javax.swing.JTextField dayDateField;
    private javax.swing.JLabel doUntilLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField monthDateField;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JComboBox<String> quantityComboBox;
    private javax.swing.JTextArea wishesField;
    private javax.swing.JLabel wishesLabel;
    private javax.swing.JTextField yearDateField;
    // End of variables declaration//GEN-END:variables
}
