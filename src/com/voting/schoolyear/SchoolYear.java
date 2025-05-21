/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.schoolyear;

import com.voting.controller.schoolyear;
import com.voting.model.SchoolYearModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SchoolYear extends javax.swing.JInternalFrame {
public static DefaultTableModel tbm_sy;
public static int OperationUpdate = 0;
public static int sy_id;
SchoolYearModel model = new SchoolYearModel();
    public SchoolYear() {
        initComponents();
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        tbm_sy = (DefaultTableModel) table_schoolyear.getModel();
         
        schoolyear.showrecord();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_schoolyear = new com.voting.components.table.SelectableRowTable();
        panelShadow1 = new com.voting.components.panel.PanelShadow();
        sy = new com.voting.swing.textfield.TextField();
        jLabel4 = new javax.swing.JLabel();
        save_sy = new javax.swing.JLabel();
        isActive = new javax.swing.JCheckBox();
        sy_delete = new javax.swing.JLabel();
        Refresh = new com.voting.components.button.MyButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SCHOOL YEAR");

        table_schoolyear.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SCHOOL YEAR", "ACTIVE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_schoolyear.getTableHeader().setReorderingAllowed(false);
        table_schoolyear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_schoolyearMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_schoolyear);

        sy.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("School Year");

        save_sy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_sy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/voting/assets/icons/buttons/btn-save.png"))); // NOI18N
        save_sy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_syMouseClicked(evt);
            }
        });

        isActive.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        isActive.setText("Active");
        isActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isActiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save_sy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addGap(368, 368, 368))
                    .addComponent(isActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sy, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(isActive, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save_sy, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        sy_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/voting/assets/icons/buttons/btn-delete.png"))); // NOI18N
        sy_delete.setEnabled(false);
        sy_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sy_deleteMouseClicked(evt);
            }
        });

        Refresh.setText("REFRESH");
        Refresh.setColorClick(new java.awt.Color(0, 153, 255));
        Refresh.setColorOver(new java.awt.Color(0, 153, 255));
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshMouseClicked(evt);
            }
        });
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sy_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sy_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_schoolyearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_schoolyearMousePressed
        sy_delete.setEnabled(true);
        schoolyear.edit();
    }//GEN-LAST:event_table_schoolyearMousePressed

    private void save_syMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_syMouseClicked
       
        if(OperationUpdate == 0){
            schoolyear.AddSchoolYear(model);
        }else{
            schoolyear.UpdateSchoolYear(model);
        }
    }//GEN-LAST:event_save_syMouseClicked

    private void isActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isActiveActionPerformed

    private void sy_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sy_deleteMouseClicked
        int dialogButton =  JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "", JOptionPane.YES_NO_OPTION);
        int row = table_schoolyear.getSelectedRow();
        SchoolYear.sy_id = (int) SchoolYear.table_schoolyear.getValueAt(row, 0);

        if (dialogButton == JOptionPane.YES_OPTION) {
            schoolyear.delete(model);
        }
    }//GEN-LAST:event_sy_deleteMouseClicked

    private void RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseClicked
        //       SchoolID.setText("");
        //       Fname.setText("");
        //       Mname.setText("");
        //       Lname.setText("");
        //       Username.setText("");
        //       Password.setText("");
        //       showRecord();
        schoolyear.refresh(model);
    }//GEN-LAST:event_RefreshMouseClicked

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed

    }//GEN-LAST:event_RefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.voting.components.button.MyButton Refresh;
    public static javax.swing.JCheckBox isActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.voting.components.panel.PanelShadow panelShadow1;
    public static javax.swing.JLabel save_sy;
    public static com.voting.swing.textfield.TextField sy;
    public static javax.swing.JLabel sy_delete;
    public static com.voting.components.table.SelectableRowTable table_schoolyear;
    // End of variables declaration//GEN-END:variables
}
