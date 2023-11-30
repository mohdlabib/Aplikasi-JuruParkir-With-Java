/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package panel;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Component;
import java.awt.Window;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import pages.Admin;
import static pages.Admin.tables;
import parkspace_v2.Koneksi;

/**
 *
 * @author cyber
 */
public class AddAdmin extends javax.swing.JFrame {

    /**
     * Creates new form AddSetting
     */
    public AddAdmin() {
        initComponents();
        init();
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
        jLabel1 = new javax.swing.JLabel();
        namaV = new javax.swing.JTextField();
        Iemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Ipassword1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tambah Admin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(namaV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 350, 40));
        jPanel1.add(Iemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 350, 40));

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 120, 30));

        Ipassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ipassword1ActionPerformed(evt);
            }
        });
        jPanel1.add(Ipassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 350, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String pesan = "";
        String username = namaV.getText();

        try {
            Connection c = Koneksi.getKoneksi();

            String checkUsernameSQL = "SELECT COUNT(*) FROM admin WHERE username = ?";
            PreparedStatement checkUsernameStatement = c.prepareStatement(checkUsernameSQL);
            checkUsernameStatement.setString(1, username);
            ResultSet result = checkUsernameStatement.executeQuery();
            result.next();
            int count = result.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Username sudah ada di database.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String insertSQL = "INSERT INTO admin (username, password, noWa) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = c.prepareStatement(insertSQL);

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, Ipassword1.getText());
                preparedStatement.setString(3, Iemail.getText());
                preparedStatement.executeUpdate();

                Window window = SwingUtilities.getWindowAncestor((Component) evt.getSource());
                if (window instanceof JFrame) {
                    ((JFrame) window).dispose();
                }
                
                try {
                    tables(null);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Berhasil Menambah Data.", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Ipassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ipassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ipassword1ActionPerformed

    
    public void init() {
        namaV.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukan nama..");
        Iemail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukan Email..");
        Ipassword1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Masukan password..");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Iemail;
    private javax.swing.JTextField Ipassword1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField namaV;
    // End of variables declaration//GEN-END:variables

}
