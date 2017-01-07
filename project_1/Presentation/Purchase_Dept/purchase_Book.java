/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1.Presentation.Purchase_Dept;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import project_1.Business_Layer.Basket;
import project_1.Business_Layer.Book;
import project_1.Business_Layer.CreateReportPdf;
import project_1.Business_Layer.ItemClass;
import project_1.Business_Layer.Lists;
import project_1.Business_Layer.Uniforms;
import static project_1.Presentation.Purchase_Dept.purchase_Uniform.dtm_uniform;
import static project_1.Presentation.Purchase_Dept.purchase_Uniform.selectedi;

/**
 *
 * @author TeezyT
 */
public class purchase_Book extends javax.swing.JFrame {

    static DefaultTableModel dtm_book;
    static DefaultTableModel dtm_bookOrder;
    static int selectedi;
    static String Type;
    static String ID;

    static String[] details;

    /**
     * Creates new form purchase_Book
     *
     * @throws java.rmi.RemoteException
     */
    public purchase_Book() throws RemoteException {

        Lists.orders = new Basket();
        initComponents();
        PopulateJtable();
        PopulatePurchaseTable();//pos the checkout tbl
        Lists.items=new ArrayList<>();
        Lists.items.clear();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_Cancel = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Checkout = new org.jdesktop.swingx.JXTable();
        btn_addToCart = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Book = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_Cancel.setText("Cancel");
        bt_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CancelActionPerformed(evt);
            }
        });

        jButton2.setText("Check out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        tbl_Book.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_BookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Book);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(75, 75, 75)))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bt_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_addToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void PopulateJtable() {

        dtm_book = new DefaultTableModel();
        PopLists();
        String[] Book_ColNames = new String[]{"ID", "Type", "Date Added", "Size", "Quantity", "Price", "Total"};
        dtm_book.setColumnIdentifiers(Book_ColNames);
        tbl_Book.setModel(dtm_book);
        tbl_Book.setAutoResizeMode(15);
        tbl_Book.setEditable(false);

        newBuild();

        jScrollPane1.setViewportView(tbl_Book);
        tbl_Book.setRowSelectionInterval(selectedi,selectedi);

        // SetboxValues();
    }

    private void PopulatePurchaseTable() {

        dtm_bookOrder = new DefaultTableModel();
        dtm_bookOrder.setRowCount(0);
        String[] BookOrderItems = new String[8];

        String[] Book_ColNames = new String[]{"ID", "Type", "Date Added", "Size", "Quantity", "Price", "Total"};
        dtm_bookOrder.setColumnIdentifiers(Book_ColNames);
        tbl_Checkout.setModel(dtm_bookOrder);
        tbl_Checkout.setAutoResizeMode(15);
        tbl_Checkout.setEditable(false);

    }

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

    private void btn_addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addToCartActionPerformed
        // TODO add your handling code here:
        AddItemTocart();
        newBuildOrders();
    }//GEN-LAST:event_btn_addToCartActionPerformed
    private void AddItemTocart() {

        Lists.orders.AddToCart(Lists.uf);

        //Lists.uf=new Uniforms()
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Lists.orders.RemoveFromCourt(Lists.uf);
        newBuildOrders();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_BookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BookMouseClicked
        try {
            // TODO add your handling code here:
            selectedi = tbl_Book.getSelectedRow();

            SetDetails();
        } catch (ParseException ex) {
            Logger.getLogger(purchase_Book.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tbl_BookMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Lists.orders.Serilizefile();

        CreateReportPdf xrf = new CreateReportPdf();
        if (!Lists.orders.CheckCartOut()) {
            System.out.println("PDF  has been generated and purchase is made");
            
        }
        else
        {
            System.out.println("Faled to by");
        }

        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CancelActionPerformed
        // TODO add your handling code here:
        
        Purchase_SwitchBoard  psw=new Purchase_SwitchBoard();
        psw.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_CancelActionPerformed
    private static void SetDetails() throws ParseException//sets array values
    {

        String name;
        int id;
        Date dt;
        String size;
        int qu;
        double p;
        String tp;

        details = new String[7];
        details[0] = String.valueOf(dtm_book.getValueAt(selectedi, 0));
        details[1] = String.valueOf(dtm_book.getValueAt(selectedi, 1));//need to fix
        details[2] = String.valueOf(dtm_book.getValueAt(selectedi, 2));
        details[3] = String.valueOf(dtm_book.getValueAt(selectedi, 3));
        details[4] = String.valueOf(dtm_book.getValueAt(selectedi, 4));
        details[5] = String.valueOf(dtm_book.getValueAt(selectedi, 5));
        details[6] = String.valueOf(dtm_book.getValueAt(selectedi, 6));

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
        details[0] = String.valueOf(dtm_bookOrder.getValueAt(selectedi, 0));
        details[1] = String.valueOf(dtm_bookOrder.getValueAt(selectedi, 1));//need to fix
        details[2] = String.valueOf(dtm_bookOrder.getValueAt(selectedi, 2));
        details[3] = String.valueOf(dtm_bookOrder.getValueAt(selectedi, 3));
        details[4] = String.valueOf(dtm_bookOrder.getValueAt(selectedi, 4));
        details[5] = String.valueOf(dtm_bookOrder.getValueAt(selectedi, 5));
        details[6] = String.valueOf(dtm_bookOrder.getValueAt(selectedi, 6));

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

        dtm_book.setRowCount(0);
        String[] BookItems = new String[8];
        dtm_book.setRowCount(0);

        
        System.out.println("About to start 4each");
        for (ItemClass item : Lists.items) {

            switch (item.getClass().getSimpleName().toLowerCase()) {

                case "uniforms":

                   
                   

                    break;

                case "book":
                     Lists.bk = (Book) item;
                     
                    BookItems[0] = String.valueOf(Lists.bk.getItemID());
                    BookItems[1] = String.valueOf(Lists.bk.getGenre());//need to fix
                    BookItems[2] = String.valueOf(Lists.bk.getItemDate());

                   // BookItems[3] = String.valueOf(Lists.bk.getSize());
                    BookItems[4] = String.valueOf(Lists.bk.getQuantity());
                    BookItems[5] = String.valueOf(Lists.uf.getPrice());
                    BookItems[6] = String.valueOf(Lists.bk.TotalPrice());
                    BookItems[7] = "null";
                    dtm_book.addRow(BookItems);

                    break;

            }
            System.out.println("Done building table");

        }

    }

    private static void newBuildOrders() {
        dtm_bookOrder.setRowCount(0);
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
            dtm_bookOrder.addRow(details);

        }

    }

    private static void PopLists() {

        ArrayList<ItemClass> ac = new ArrayList<>();
        Lists.items = new ArrayList<>();

        ac.add(new Book());

        BusinessClassListupdate(ac);
    }//poulates the j Table with itrm data

    public static void BusinessClassListupdate(ArrayList<? extends ItemClass> it) {

        it.stream().forEach((item) -> {
            item.GetAllItems();
        });

        System.out.println("Done populating lists");

    }//Generic method

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
            java.util.logging.Logger.getLogger(purchase_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purchase_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purchase_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purchase_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new purchase_Book().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(purchase_Book.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Cancel;
    private javax.swing.JButton btn_addToCart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tbl_Book;
    private org.jdesktop.swingx.JXTable tbl_Checkout;
    // End of variables declaration//GEN-END:variables
}