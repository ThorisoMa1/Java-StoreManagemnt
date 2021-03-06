/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Presentation.Admin_Dept;

import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.MutableComboBoxModel;
import project_1.Business_Layer.Lists;
import project_1.Business_Layer.Uniforms;
import static project_1.Presentation.Admin_Dept.Manage_Stock.ID;

/**
 *
 * @author TeezyT
 */
public class Add_Uniform extends javax.swing.JFrame {

    /**
     * Creates new form Add_Uniform
     */
    public Add_Uniform() {
        initComponents();
        PopSizes();//gets sizes
        PopUniformtypes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbo_Size = new org.jdesktop.swingx.JXComboBox();
        label5 = new java.awt.Label();
        btn_Cancel = new org.jdesktop.swingx.JXButton();
        btn_AddBook = new org.jdesktop.swingx.JXButton();
        sp_Quantity = new javax.swing.JSpinner();
        txt_Price = new org.jdesktop.swingx.JXTextField();
        lbl_genre = new java.awt.Label();
        label2 = new java.awt.Label();
        cbo_uType = new org.jdesktop.swingx.JXComboBox();
        label4 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label5.setText("UniformType");

        btn_Cancel.setText("Cancel");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_AddBook.setText("Add");
        btn_AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddBookActionPerformed(evt);
            }
        });

        lbl_genre.setText("Size");

        label2.setText("Quantity");

        label4.setText("Price");

        jLabel1.setFont(new java.awt.Font("Adobe Devanagari", 1, 14)); // NOI18N
        jLabel1.setText("               Uniform");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79)
                        .addComponent(sp_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_genre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_uType, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_Size, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_AddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbo_uType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_Size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_AddBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddBookActionPerformed
        // TODO add your handling code here:

        Setvalues();

        if (!Lists.uf.InsertItem()) {

            inserted("inserted uniform");
        } else {
            inserted("failed to insert");
        }

        Manage_Stock ms = new Manage_Stock();
        this.setVisible(false);
        ms.setVisible(true);

    }//GEN-LAST:event_btn_AddBookActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // TODO add your handling code here:
        Manage_Stock ms = new Manage_Stock();
        this.setVisible(false);
        ms.setVisible(true);

    }//GEN-LAST:event_btn_CancelActionPerformed
    private void PopSizes() {

        cbo_Size.addItem(Lists.sizes);
        cbo_Size.setModel(new DefaultComboBoxModel());
        //JComboBox box = new JComboBox(new DefaultComboBoxModel());

        MutableComboBoxModel sizemodel = (DefaultComboBoxModel) cbo_Size.getModel();

        Lists.sizes.stream().forEach((size) -> {
            sizemodel.addElement(size);
        });

    }

    private void PopUniformtypes() {

        Lists.item.GetTypes();
        cbo_uType.addItem(Lists.uniformTypes);
        cbo_uType.setModel(new DefaultComboBoxModel());
        //JComboBox box = new JComboBox(new DefaultComboBoxModel());

        MutableComboBoxModel typemodel = (DefaultComboBoxModel) cbo_uType.getModel();

        Lists.uniformTypes.stream().forEach((size) -> {
            typemodel.addElement(size);
        });

    }

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
            java.util.logging.Logger.getLogger(Add_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Uniform().setVisible(true);
            }
        });
    }

    private void Setvalues() {

        Lists.uf = new Uniforms();

        Lists.uf.setPrice(Double.parseDouble(txt_Price.getText()));
        Lists.uf.setQuantity((Integer) sp_Quantity.getValue());
        Lists.uf.setSize(cbo_Size.getSelectedItem().toString());
        Lists.uf.setType(cbo_uType.getSelectedItem().toString());
    }

    private void inserted(String message) {
        Component frame = null;
        JOptionPane.showMessageDialog(frame, message);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton btn_AddBook;
    private org.jdesktop.swingx.JXButton btn_Cancel;
    private org.jdesktop.swingx.JXComboBox cbo_Size;
    private org.jdesktop.swingx.JXComboBox cbo_uType;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label lbl_genre;
    private javax.swing.JSpinner sp_Quantity;
    private org.jdesktop.swingx.JXTextField txt_Price;
    // End of variables declaration//GEN-END:variables
}
