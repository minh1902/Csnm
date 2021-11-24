/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import api.BillApi;
import api.ProductApi;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Product;
import utils.ProductsListUtils;

/**
 *
 * @author DELL
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() throws IOException {
        initComponents();
        setTable("","name");
        setCategory();
    }
    
    public void setTable(String name, String para) throws IOException{
        List<Product> lists = null;
        try {
            if(para.equals("name")){
                lists = ProductApi.getProductsByName(name);
            } else {
                if(name.equals("tất cả")){
                    name = "";
                }
                lists = ProductApi.getProductsByCategory(name);
            }
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel defaultTableModel = (DefaultTableModel) productsTb.getModel();
        defaultTableModel.setRowCount(0);
        for (int i = 0; i < lists.size(); i++) {
            defaultTableModel.addRow(new Object[]{
                lists.get(i).getName(),
                lists.get(i).getPrice().toString(),
            });
            ProductsListUtils.productsList.put(lists.get(i).getName(), lists.get(i).getId());
        }
        ProductsListUtils.productsList.entrySet().forEach(e->{
            System.out.println(e);
        });
    }
    
    private void setCategory(){
        List<Object> lists = null;
        try {
            lists = ProductApi.getCategory();
        } catch (URISyntaxException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < lists.size(); i++) {
            categoryCb.addItem(lists.get(i).toString());
            
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        searchTf = new javax.swing.JTextField();
        searchBt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        categoryCb = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTb = new javax.swing.JTable();
        addBt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        insertBt = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        updateBt = new javax.swing.JButton();
        logoutBt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cartTb = new javax.swing.JTable();
        deleteBt = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        totalMoneyLb = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        discountSp = new javax.swing.JSpinner();
        jPanel18 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        finalLb = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        payBt = new javax.swing.JButton();
        cancelBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 177));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 1000));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.X_AXIS));

        jLabel1.setText("Tìm kiếm:");
        jPanel5.add(jLabel1);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));
        jPanel9.setLayout(new java.awt.BorderLayout(20, 20));
        jPanel9.add(searchTf, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel9);

        searchBt.setText("Tìm");
        searchBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtActionPerformed(evt);
            }
        });
        jPanel5.add(searchBt);

        jLabel2.setText("            ");
        jPanel5.add(jLabel2);

        categoryCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tất cả" }));
        categoryCb.setMinimumSize(new java.awt.Dimension(80, 19));
        categoryCb.setPreferredSize(new java.awt.Dimension(80, 19));
        categoryCb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryCbItemStateChanged(evt);
            }
        });
        categoryCb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryCbMouseClicked(evt);
            }
        });
        categoryCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCbActionPerformed(evt);
            }
        });
        jPanel5.add(categoryCb);

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 1));

        productsTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giá"
            }
        ));
        jScrollPane1.setViewportView(productsTb);

        jPanel6.add(jScrollPane1);

        jPanel4.add(jPanel6);

        addBt.setText("Thêm vào giỏ hàng");
        addBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtActionPerformed(evt);
            }
        });
        jPanel4.add(addBt);

        jPanel1.add(jPanel4);

        jPanel3.setBackground(new java.awt.Color(153, 255, 102));
        jPanel3.setMaximumSize(new java.awt.Dimension(8000, 32767));
        jPanel3.setLayout(new java.awt.GridLayout(2, 2));

        insertBt.setText("Thêm");
        insertBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtActionPerformed(evt);
            }
        });
        jPanel3.add(insertBt);

        delete.setText("Xóa");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete);

        updateBt.setText("Cập nhật");
        updateBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtActionPerformed(evt);
            }
        });
        jPanel3.add(updateBt);

        logoutBt.setText("Đăng xuất");
        logoutBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtActionPerformed(evt);
            }
        });
        jPanel3.add(logoutBt);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 0));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Giỏ hàng");
        jPanel7.add(jLabel3);

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        cartTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giá", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane3.setViewportView(cartTb);

        jPanel11.add(jScrollPane3);

        jPanel7.add(jPanel11);

        deleteBt.setText("Xóa");
        deleteBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtActionPerformed(evt);
            }
        });
        jPanel7.add(deleteBt);

        jPanel2.add(jPanel7);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.Y_AXIS));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Hóa đơn");
        jPanel8.add(jLabel4);

        jPanel12.setBackground(new java.awt.Color(51, 204, 0));
        jPanel12.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setText("Tổng tiền");
        jPanel14.add(jLabel5);

        jPanel12.add(jPanel14);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        totalMoneyLb.setText("0");
        jPanel15.add(totalMoneyLb);

        jPanel12.add(jPanel15);

        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel7.setText("Giảm (%)");
        jPanel16.add(jLabel7);

        jPanel12.add(jPanel16);

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        discountSp.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));
        jPanel17.add(discountSp);

        jPanel12.add(jPanel17);

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel9.setText("Thành tiền");
        jPanel18.add(jLabel9);

        jPanel12.add(jPanel18);

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        finalLb.setText("0");
        jPanel19.add(finalLb);

        jPanel12.add(jPanel19);

        jPanel8.add(jPanel12);

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 30, 10, 30));
        jPanel13.setMaximumSize(new java.awt.Dimension(32767, 5000));
        jPanel13.setPreferredSize(new java.awt.Dimension(291, 45));
        jPanel13.setLayout(new java.awt.GridLayout(1, 2, 30, 30));

        payBt.setText("Thanh toán");
        payBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtActionPerformed(evt);
            }
        });
        jPanel13.add(payBt);

        cancelBt.setText("Hủy");
        cancelBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtActionPerformed(evt);
            }
        });
        jPanel13.add(cancelBt);

        jPanel8.add(jPanel13);

        jPanel2.add(jPanel8);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtActionPerformed
        try {
            Double totalMoney = 0.0;
            for (int i = 0; i < cartTb.getRowCount(); i++) {
                totalMoney += Double.valueOf(cartTb.getValueAt(i, 3).toString());
            }
            totalMoneyLb.setText(String.valueOf(totalMoney));
            int discount = Integer.parseInt(discountSp.getValue().toString());
            finalLb.setText(String.valueOf(totalMoney - totalMoney * discount / 100));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String  dateStr = dateFormat.format(new Date());
            
            List<Map<String, Integer>> productList = new ArrayList<>();
            Map<String,Integer> productId = ProductsListUtils.getIds();
            
            System.out.println(cartTb.getRowCount());
            for (int i = 0; i < cartTb.getRowCount(); i++) {
                Map<String, Integer> product = new TreeMap<>();
                product.put("productId",productId.get(cartTb.getModel().getValueAt(i, 0)));
                product.put("count",Integer.parseInt(cartTb.getModel().getValueAt(i, 2).toString()));
                productList.add(product);
            }
            Gson gson = new Gson();
            String productsStr = gson.toJson(productList);
            System.out.println(productsStr);
            BillApi.insertBill(Double.parseDouble(finalLb.getText()), dateStr, productsStr);
            new Bill(this, finalLb.getText(), dateStr).setVisible(true);
            this.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_payBtActionPerformed

    public void resetValue(){
        totalMoneyLb.setText("");
        discountSp.setValue(0);
        finalLb.setText("");
        DefaultTableModel defaultTableModel = (DefaultTableModel) cartTb.getModel();
        defaultTableModel.setRowCount(0);
    }
    
    private void categoryCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCbActionPerformed
        
    }//GEN-LAST:event_categoryCbActionPerformed

    private void searchBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtActionPerformed
        String name = searchTf.getText();
        try {
            setTable(name,"name");
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtActionPerformed

    private void categoryCbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryCbMouseClicked
        String category = categoryCb.getSelectedItem().toString();
        try {
            setTable(category,"category");
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_categoryCbMouseClicked

    private void categoryCbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryCbItemStateChanged
        // TODO add your handling code here:
        String category = categoryCb.getSelectedItem().toString();
        try {
            setTable(category,"category");
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_categoryCbItemStateChanged

    private void addBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtActionPerformed
        int row = productsTb.getSelectedRow();
        if(row > 0){
            String name = productsTb.getValueAt(row, 0).toString();
            String price = productsTb.getValueAt(row, 1).toString();
            DefaultTableModel defaultTableModel = (DefaultTableModel) cartTb.getModel();
            for (int i = 0; i < cartTb.getRowCount(); i++) {
                if(cartTb.getValueAt(i, 0).equals(name)){
                    int count = Integer.parseInt(cartTb.getValueAt(i, 2).toString()) + 1;
                     defaultTableModel.setValueAt(count, i, 2);
                     defaultTableModel.setValueAt(Double.valueOf(price) * count, i, 3);
                    return;
                }
            }
            defaultTableModel.addRow(new Object[]{
            name, price, 1, price
            });
        }
        
    }//GEN-LAST:event_addBtActionPerformed

    private void deleteBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtActionPerformed
        int index = cartTb.getSelectedRow();
        if(index >= 0){
            DefaultTableModel defaultTableModel = (DefaultTableModel) cartTb.getModel();
            defaultTableModel.removeRow(index);
        }
    }//GEN-LAST:event_deleteBtActionPerformed

    private void logoutBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtActionPerformed
        new LoginPage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutBtActionPerformed

    private void cancelBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtActionPerformed
        resetValue();
    }//GEN-LAST:event_cancelBtActionPerformed

    private void insertBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtActionPerformed
        this.setEnabled(false);
        new Add(this).setVisible(true);
    }//GEN-LAST:event_insertBtActionPerformed

    private void updateBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtActionPerformed
        int row = productsTb.getSelectedRow();
        String name = productsTb.getValueAt(row, 0).toString();
        String price = productsTb.getValueAt(row, 1).toString();
        Integer id = ProductsListUtils.getIds().get(name);
        this.setEnabled(false);
        new Update(this, id, name, price, "áo").setVisible(true);
        
    }//GEN-LAST:event_updateBtActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int row = productsTb.getSelectedRow();
        String name = productsTb.getValueAt(row, 0).toString();
        Integer id = ProductsListUtils.getIds().get(name);
        try {
            ProductApi.deleteProduct(id);
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setTable("", "name");
        } catch (IOException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new HomePage().setVisible(true);
//                } catch (IOException ex) {
//                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBt;
    private javax.swing.JButton cancelBt;
    private javax.swing.JTable cartTb;
    private javax.swing.JComboBox<String> categoryCb;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteBt;
    private javax.swing.JSpinner discountSp;
    private javax.swing.JLabel finalLb;
    private javax.swing.JButton insertBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logoutBt;
    private javax.swing.JButton payBt;
    private javax.swing.JTable productsTb;
    private javax.swing.JButton searchBt;
    private javax.swing.JTextField searchTf;
    private javax.swing.JLabel totalMoneyLb;
    private javax.swing.JButton updateBt;
    // End of variables declaration//GEN-END:variables
}
