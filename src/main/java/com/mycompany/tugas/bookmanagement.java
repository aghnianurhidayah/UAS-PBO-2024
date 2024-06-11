/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tugas;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aghnia
 */
public class bookmanagement extends javax.swing.JFrame {

    public bookmanagement() {
        initComponents();
        DB();
        loadTable();
    }
    
    Connection con;
    PreparedStatement pst;
    
    public void DB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbbookmanagement", "root", "");
        } catch(Exception e){
            System.out.println(e);
        }
    }
    

    @SuppressWarnings("unchecked")
    
    private void loadTable() {
        int column;
        
        try {
            pst = con.prepareStatement("SELECT * FROM book");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = rs.getMetaData();
            column = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);
            
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for (int i = 1; i <= column; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("judul"));
                    v2.add(rs.getString("jenis"));
                    v2.add(rs.getString("genre"));
                    v2.add(rs.getString("pengarang"));
                    v2.add(rs.getString("penerbit"));
                    v2.add(rs.getString("thn_terbit"));
                    v2.add(rs.getString("jml_hal"));
                }
                DFT.addRow(v2);
            }
        } catch (SQLException ex){}
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        cbGenre = new javax.swing.JComboBox<>();
        txtPengarang = new javax.swing.JTextField();
        txtPenerbit = new javax.swing.JTextField();
        txtTahunTerbit = new javax.swing.JTextField();
        txtJmlHal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rbFiksi = new javax.swing.JRadioButton();
        rbNonFiksi = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Management");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setText("Book Management System");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Pengarang");

        jLabel4.setText("Penerbit");

        jLabel5.setText("Tahun Terbit");

        jLabel6.setText("Jumlah Halaman");

        jLabel7.setText("Genre Buku");

        jLabel2.setText("Judul Buku");

        cbGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Science Fiction", "Fantasy", "Thriller", "Historical", "Dystopia" }));

        jLabel8.setText("Jenis Buku");

        buttonGroup1.add(rbFiksi);
        rbFiksi.setText("Fiksi");
        rbFiksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFiksiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNonFiksi);
        rbNonFiksi.setText("Non Fiksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(22, 22, 22))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtJmlHal, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJudul, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTahunTerbit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPenerbit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPengarang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbGenre, javax.swing.GroupLayout.Alignment.TRAILING, 0, 206, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbFiksi)
                        .addGap(42, 42, 42)
                        .addComponent(rbNonFiksi)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rbFiksi)
                    .addComponent(rbNonFiksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtJmlHal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Judul", "Jenis", "Genre", "Pengarang", "Penerbit", "Tahun Terbit", "Jml Halaman"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Batal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String getSelectedJenis() {
        if (rbFiksi.isSelected()) {
            return "Fiksi";
        } else if (rbNonFiksi.isSelected()) {
            return "Non Fiksi";
        }
        return null;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            String judul, jenis, genre, pengarang, penerbit, thnterbit, jmlhal;
        
            judul = txtJudul.getText();
            jenis = getSelectedJenis();
            genre = cbGenre.getSelectedItem().toString();
            pengarang = txtPengarang.getText();
            penerbit = txtPenerbit.getText();
            thnterbit = txtTahunTerbit.getText();
            jmlhal = txtJmlHal.getText();

            pst = con.prepareStatement("INSERT INTO book (judul, jenis, genre, pengarang, penerbit, thn_terbit, jml_hal) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, judul);
            pst.setString(2, jenis);
            pst.setString(3, genre);
            pst.setString(4, pengarang);
            pst.setString(5, penerbit);
            pst.setString(6, thnterbit);
            pst.setString(7, jmlhal);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Buku Berhasil ditambah!");
            loadTable();

            txtJudul.setText("");
            rbFiksi.setSelected(false);
            rbNonFiksi.setSelected(false);
            cbGenre.setSelectedIndex(0);
            txtPengarang.setText("");
            txtPenerbit.setText("");
            txtTahunTerbit.setText("");
            txtJmlHal.setText("");
            txtJudul.requestFocus();
            
        } catch (SQLException ex){}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        
        String getJenis = model.getValueAt(selectedIndex, 2).toString();
        if ("Fiksi".equals(getJenis)) {
            rbFiksi.setSelected(true);
        } else if ("Non Fiksi".equals(getJenis)) {
            rbNonFiksi.setSelected(true);
        }
                
        String getItem = model.getValueAt(selectedIndex, 3).toString();
        int itemIndex = 0;
        if ("Romance".equals(getItem)) {
            itemIndex = 0;
        } else if ("Science Fiction".equals(getItem)) {
            itemIndex = 1;
        } else if ("Fantasy".equals(getItem)) {
            itemIndex = 2;
        } else if ("Thriller".equals(getItem)) {
            itemIndex = 3;
        } else if ("Historical".equals(getItem)) {
            itemIndex = 4;
        } else if ("Dystopia".equals(getItem)) {
            itemIndex = 5;
        }
        
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        txtJudul.setText(model.getValueAt(selectedIndex, 1).toString());
        cbGenre.setSelectedIndex(itemIndex);
        txtPengarang.setText(model.getValueAt(selectedIndex, 4).toString());
        txtPenerbit.setText(model.getValueAt(selectedIndex, 5).toString());
        txtTahunTerbit.setText(model.getValueAt(selectedIndex, 6).toString());
        txtJmlHal.setText(model.getValueAt(selectedIndex, 7).toString());
        txtJudul.setText(model.getValueAt(selectedIndex, 8).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();

            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        
            String judul, jenis, genre, pengarang, penerbit, thnterbit, jmlhal;
        
            judul = txtJudul.getText();
            jenis = getSelectedJenis();
            genre = cbGenre.getSelectedItem().toString();
            pengarang = txtPengarang.getText();
            penerbit = txtPenerbit.getText();
            thnterbit = txtTahunTerbit.getText();
            jmlhal = txtJmlHal.getText();

            pst = con.prepareStatement("UPDATE book SET judul=?, jenis=?, genre=?, pengarang=?, penerbit=?, thn_terbit=?, jml_hal=? WHERE id=?");
            pst.setString(1, judul);
            pst.setString(2, jenis);
            pst.setString(3, genre);
            pst.setString(4, pengarang);
            pst.setString(5, penerbit);
            pst.setString(6, thnterbit);
            pst.setString(7, jmlhal);
            pst.setInt(8, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Buku Berhasil diubah!");
            loadTable();

            txtJudul.setText("");
            rbFiksi.setSelected(false);
            rbNonFiksi.setSelected(false);
            cbGenre.setSelectedIndex(0);
            txtPengarang.setText("");
            txtPenerbit.setText("");
            txtTahunTerbit.setText("");
            txtJmlHal.setText("");
            txtJudul.requestFocus();
            
        } catch (SQLException ex){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();

            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
            
            pst = con.prepareStatement("DELETE FROM book WHERE id=?");

            pst.setInt(1, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Buku Berhasil dihapus!");
            loadTable();

            txtJudul.setText("");
            rbFiksi.setSelected(false);
            rbNonFiksi.setSelected(false);
            cbGenre.setSelectedIndex(0);
            txtPengarang.setText("");
            txtPenerbit.setText("");
            txtTahunTerbit.setText("");
            txtJmlHal.setText("");
            txtJudul.requestFocus();
            
        } catch (SQLException ex){}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        txtJudul.setText("");
        rbFiksi.setSelected(false);
            rbNonFiksi.setSelected(false);
        cbGenre.setSelectedIndex(0);
        txtPengarang.setText("");
        txtPenerbit.setText("");
        txtTahunTerbit.setText("");
        txtJmlHal.setText("");
        txtJudul.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rbFiksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFiksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFiksiActionPerformed

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
            java.util.logging.Logger.getLogger(bookmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookmanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookmanagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbGenre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbFiksi;
    private javax.swing.JRadioButton rbNonFiksi;
    private javax.swing.JTextField txtJmlHal;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtTahunTerbit;
    // End of variables declaration//GEN-END:variables
}
