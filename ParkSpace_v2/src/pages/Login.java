/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import parkspace_v2.PanelSwitcher;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import parkspace_v2.Func;
import parkspace_v2.Koneksi;

/**
 *
 * @author cyber
 */
public class Login extends javax.swing.JPanel {
    private final PanelSwitcher panelSwitcher;

    /**
     * Creates new form Login
     * @param panelSwitcher
     */
    public Login(PanelSwitcher panelSwitcher) {
        this.panelSwitcher = panelSwitcher;
        initComponents();
        
        init();
        
        Font fontPoppins3 = new Font("Poppins", Font.BOLD, 13);
        jButton1.setFont(fontPoppins3);
        
        Font fontPoppins = new Font("Poppins", Font.BOLD, 18);
        jLabel1.setFont(fontPoppins);
        
        Font fontPoppins2 = new Font("Poppins", Font.PLAIN, 13);
        jLabel2.setFont(fontPoppins2);
        jLabel3.setFont(fontPoppins2);
        
        Font fontPoppins5 = new Font("Poppins", Font.PLAIN, 11);
        jLabel4.setFont(fontPoppins5);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        InputPassword = new javax.swing.JTextField();
        InputUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 146, 35));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(181, 181, 181))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel3.setText("Password");

        jButton1.setBackground(new java.awt.Color(255, 146, 35));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel4.setText("Lupa Password?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3)
                            .addComponent(InputUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(InputPassword)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String data = InputUsername.getText();
                
        if(data.length() > 0){
            try {
                Connection c = Koneksi.getKoneksi();
                String sql = "SELECT * FROM admin WHERE username = ?";

                PreparedStatement preparedStatement = c.prepareStatement(sql);
                preparedStatement.setString(1, InputUsername.getText());

                ResultSet r = preparedStatement.executeQuery();

                if (r.next()) {
                    int userId = r.getInt("id");
                    
                        String noWa = r.getString("noWa");
                        String newPassword = generateNewPassword(5);
                        
                        String updateSql = "UPDATE admin SET password = ? WHERE id = ?";
                        PreparedStatement updateStatement = c.prepareStatement(updateSql);
                        updateStatement.setString(1, newPassword);
                        updateStatement.setInt(2, userId);
                        updateStatement.executeUpdate();
                        
                        String apiUrl = "http://23.95.48.230:4060/send-img";
                        String session = "";
                        String text = "*Kang Parkir* - Kami telah mereset password Anda. Password baru Anda adalah: *" + newPassword + "* Terima kasih telah menggunakan *Kang Parkir!*";
                        
                        String whatsappUrl = apiUrl + "?session=" + session + "&to=" + noWa + "&text=" + text + "&media=https://labibweb.my.id/appsLb/bg-juruparkir.png";
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(whatsappUrl).get().build();
                        Response response = client.newCall(request).execute();
                        
                        if (response.isSuccessful()) {
                            JOptionPane.showMessageDialog(null, "Password Telah Di Reset.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Gagal mengirim pesan WhatsApp.");
                        }

                } else {
                    JOptionPane.showMessageDialog(null, "Username tidak terdaftar.");
                }
                
                
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam mengakses database.");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mohon Isi Username.");
            InputUsername.requestFocus();
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM admin WHERE username='" + InputUsername.getText()
            +"' and password='"+ InputPassword.getText() + "'";
            ResultSet r = s.executeQuery(sql);

            if (r.next()){
                String userId = r.getString("id");
                Func.setData(userId);

                Dashboard.setId();
                panelSwitcher.switchToPanel("dashboard");

                InputPassword.setText("");
                InputUsername.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Username or Password");
                InputPassword.requestFocus();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void init() {
        InputUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Burham");
        InputPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "******");
    }
    
    public String generateNewPassword(int length) {
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        SecureRandom random = new SecureRandom();
        StringBuilder newPassword = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            newPassword.append(allowedCharacters.charAt(randomIndex));
        }

        return newPassword.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputPassword;
    private javax.swing.JTextField InputUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
