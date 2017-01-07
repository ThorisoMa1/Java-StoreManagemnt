/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.KemptinBranch.Presentation;

import java.awt.Component;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_1.KemptinBranch.Presentation.Business_Logic.ItemClass;
import project_1.KemptinBranch.Presentation.Business_Logic.Lists;
import project_1.KemptinBranch.Presentation.Business_Logic.Uniforms;


/**
 *
 * @author TeezyT
 */
public class purchase_Uniform extends javax.swing.JFrame {

    static Registry r;
    static IkemptonOrders KemptonOrders;

    static DefaultTableModel dtm_uniform;
    static DefaultTableModel dtm_uniformOrder;
    static int selectedi;
    static String Type;
    static String ID;

    static String[] details;

    /**
     * Creates new form purchase_Uniform
     *
     * @throws java.rmi.RemoteException
     */
    public purchase_Uniform()  {

        initComponents();
    }

    private static void ShowConnectionFailed() {
        Component frame = null;
        JOptionPane.showMessageDialog(frame, "Failed to connect to Server");
        //System.out.println(" failed to Update");
    }

    private static void ShowConnectionSuceeded() {
        Component frame = null;
        JOptionPane.showMessageDialog(frame, "Connected to server");
        //System.out.println(" failed to Update");
    }

    private void PopulateJtable() {

        dtm_uniform = new DefaultTableModel();
        PopLists();
        String[] Uniform_ColNames = new String[]{"ID", "Type", "Date Added", "Size", "Quantity", "Price", "Total"};
        dtm_uniform.setColumnIdentifiers(Uniform_ColNames);
        tbl_Uniform.setModel(dtm_uniform);
        tbl_Uniform.setAutoResizeMode(15);
        tbl_Uniform.setEditable(false);

        newBuild();

        jScrollPane1.setViewportView(tbl_Uniform);
        tbl_Uniform.setRowSelectionInterval(0, 0);

        // SetboxValues();
    }

    private static boolean StartRmi() throws NotBoundException {
        try {
            // TODO add your handling code here:
            r = LocateRegistry.getRegistry("localhost", 1111);
            KemptonOrders = (IkemptonOrders) r.lookup("Kempton");
            ShowConnectionSuceeded();

            return true;
        } catch (RemoteException ex) {
            ShowConnectionFailed();
            Logger.getLogger(purchase_Book.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }//starts the rmi services

    private void PopulatePurchaseTable() {

        dtm_uniformOrder = new DefaultTableModel();
        dtm_uniformOrder.setRowCount(0);
        String[] uniformOrderItems = new String[8];

        // PopLists();//poulates the lists of orders
        String[] Uniform_ColNames = new String[]{"ID", "Type", "Date Added", "Size", "Quantity", "Price", "Total"};
        dtm_uniformOrder.setColumnIdentifiers(Uniform_ColNames);
        tbl_Checkout.setModel(dtm_uniformOrder);
        tbl_Checkout.setAutoResizeMode(15);
        tbl_Checkout.setEditable(false);

        // newBuild();
//        jScrollPane1.setViewportView(tbl_Checkout);
//        tbl_Checkout.setRowSelectionInterval(0, 0);
        // SetboxValues();
    }

    private static void SetDetails() throws ParseException//sets array values
    {

        String name;
        int id;
        Date dt;
        String size;
        int qu;
        double p;
        String tp;

        // {"ID", "Type", "Date Added", "Size", "Quantity", "Price", "Total"};
        details = new String[7];
        details[0] = String.valueOf(dtm_uniform.getValueAt(selectedi, 0));
        details[1] = String.valueOf(dtm_uniform.getValueAt(selectedi, 1));//need to fix
        details[2] = String.valueOf(dtm_uniform.getValueAt(selectedi, 2));
        details[3] = String.valueOf(dtm_uniform.getValueAt(selectedi, 3));
        details[4] = String.valueOf(dtm_uniform.getValueAt(selectedi, 4));
        details[5] = String.valueOf(dtm_uniform.getValueAt(selectedi, 5));
        details[6] = String.valueOf(dtm_uniform.getValueAt(selectedi, 6));

        size = details[3];
        tp = details[1];
        p = Double.parseDouble(details[5]);
        qu = 1;
        id = Integer.parseInt(details[0]);
        dt = convertToDate(details[2]);

        Lists.uf = new Uniforms(size, tp, p, qu, id, dt);

        
    }

    private static void SetOrderDetails() throws ParseException//sets array values
    {

        String name;
        int id;
        Date dt;
        String size;
        int qu;
        double p;
        String tp;

        // {"ID", "Type", "Date Added", "Size", "Quantity", "Price", "Total"};
        details = new String[7];
        details[0] = String.valueOf(dtm_uniformOrder.getValueAt(selectedi, 0));
        details[1] = String.valueOf(dtm_uniformOrder.getValueAt(selectedi, 1));//need to fix
        details[2] = String.valueOf(dtm_uniformOrder.getValueAt(selectedi, 2));
        details[3] = String.valueOf(dtm_uniformOrder.getValueAt(selectedi, 3));
        details[4] = String.valueOf(dtm_uniformOrder.getValueAt(selectedi, 4));
        details[5] = String.valueOf(dtm_uniformOrder.getValueAt(selectedi, 5));
        details[6] = String.valueOf(dtm_uniformOrder.getValueAt(selectedi, 6));

        size = details[3];
        tp = details[1];
        p = Double.parseDouble(details[5]);
        qu = 1;
        id = Integer.parseInt(details[0]);
        dt = convertToDate2(details[2]);

        Lists.uf = new Uniforms(size, tp, p, qu, id, dt);

        //Lists.uf=new Uniforms
        //details[7] = "null";
    }

    private static Date convertToDate(String Date) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yy");
        return (Date) df.parse(Date);

    }

    private static Date convertToDate2(String Date) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("EEEE MMM dd HH:mm:ss");
        try {

            return (Date) df.parse(Date.replaceAll("CAT$", ""));
        } catch (Exception e) {
            System.out.println("failed");
        }

        return (Date) df.parse(Date.replace("CAT 2169", ""));

    }

    private static void newBuild() {

        dtm_uniform.setRowCount(0);
        String[] UniformItems = new String[8];
        dtm_uniform.setRowCount(0);

        for (ItemClass item : Lists.items) {

            switch (item.getClass().getSimpleName().toLowerCase()) {

                case "uniforms":

                    Lists.uf = (Uniforms) item;
                    // {"ID", "Type","Size", "Quantity", "Price","Total"};
                    UniformItems[0] = String.valueOf(Lists.uf.getItemID());
                    UniformItems[1] = String.valueOf(Lists.uf.getType());//need to fix
                    UniformItems[2] = String.valueOf(Lists.uf.getItemDate());

                    UniformItems[3] = String.valueOf(Lists.uf.getSize());
                    UniformItems[4] = String.valueOf(Lists.uf.getQuantity());
                    UniformItems[5] = String.valueOf(Lists.uf.getPrice());
                    UniformItems[6] = String.valueOf(Lists.uf.TotalPrice());
                    UniformItems[7] = "null";
                    dtm_uniform.addRow(UniformItems);

                    break;

                case "book":

                    break;

            }
            System.out.println("Done building table");

        }

    }

    private static void newBuildOrders() {
        dtm_uniformOrder.setRowCount(0);
        //Lists.orders.getCartDetails();

        for (ItemClass detail : Lists.items) {

            if (detail.getClass().getSimpleName() == "books") {

            }
            Lists.uf = (Uniforms) detail;

            details[0] = String.valueOf(Lists.uf.getItemID());
            details[1] = String.valueOf(Lists.uf.getType());//need to fix
            details[2] = String.valueOf(Lists.uf.getItemDate());

            details[3] = String.valueOf(Lists.uf.getSize());
            details[4] = String.valueOf(Lists.uf.getQuantity());
            details[5] = String.valueOf(Lists.uf.getPrice());
            details[6] = String.valueOf(Lists.uf.TotalPrice());
            //details[7] = "null";
            dtm_uniformOrder.addRow(details);

        }

    }

    private static void PopLists() {

        ArrayList<ItemClass> ac = new ArrayList<>();
        Lists.items = new ArrayList<>();

        ac.add(new Uniforms());

        BusinessClassListupdate(ac);
    }//poulates the j Table with itrm data

    public static void BusinessClassListupdate(ArrayList<? extends ItemClass> it) {

        it.stream().forEach((item) -> {
            item.GetAllItems();
        });

        System.out.println("Done populating lists");

    }//Generic method

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Uniform = new org.jdesktop.swingx.JXTable();
        btn_addToCart = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Checkout = new org.jdesktop.swingx.JXTable();
        bt_Cancel = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tbl_Uniform.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Uniform.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_UniformMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Uniform);

        btn_addToCart.setText("Add to Cart");
        btn_addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addToCartActionPerformed(evt);
            }
        });

        jButton1.setText("Remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbl_Checkout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Checkout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CheckoutMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Checkout);

        bt_Cancel.setText("Cancel");

        jButton2.setText("Check out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Send Compalaint to server");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_addToCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bt_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            // TODO add your handling code here:
            StartRmi();
        } catch (NotBoundException ex) {
            Logger.getLogger(purchase_Uniform.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_formWindowActivated

    private void tbl_UniformMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_UniformMouseClicked
        // TODO add your handling code here:
        selectedi = tbl_Uniform.getSelectedRow();
        try {
            SetDetails();
        } catch (ParseException ex) {
            Logger.getLogger(purchase_Uniform.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tbl_UniformMouseClicked

    private void btn_addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addToCartActionPerformed
        // TODO add your handling code here:
        AddItemTocart();
        newBuildOrders();
    }//GEN-LAST:event_btn_addToCartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Lists.orders.RemoveFromCourt(Lists.uf);
        newBuildOrders();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_CheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CheckoutMouseClicked
        // TODO add your handling code here:
        selectedi = tbl_Checkout.getSelectedRow();
        System.out.println("pressed");
        try {
            SetOrderDetails();
        } catch (ParseException ex) {
            Logger.getLogger(purchase_Uniform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_CheckoutMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
      //need to create method for rmi
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        KemptonSocketClient hsc=new KemptonSocketClient();
        hsc.main();

    }//GEN-LAST:event_jButton3ActionPerformed
    private void AddItemTocart() {

       //rmi request
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
            java.util.logging.Logger.getLogger(purchase_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purchase_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purchase_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purchase_Uniform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new purchase_Uniform().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Cancel;
    private javax.swing.JButton btn_addToCart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tbl_Checkout;
    private org.jdesktop.swingx.JXTable tbl_Uniform;
    // End of variables declaration//GEN-END:variables
}
