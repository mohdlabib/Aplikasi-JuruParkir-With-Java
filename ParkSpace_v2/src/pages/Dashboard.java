/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import parkspace_v2.Func;
import parkspace_v2.Koneksi;
import parkspace_v2.PanelSwitcher;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import static pages.Admin.tables;


/**
 *
 * @author cyber
 */
public class Dashboard extends javax.swing.JPanel {
    private PanelSwitcher panelSwitcher = null;
    
    /**
     * Creates new form Dashboard
     * @param panelSwitcher
     * @throws java.sql.SQLException
     */
    public Dashboard(PanelSwitcher panelSwitcher) throws SQLException {
        this.panelSwitcher = panelSwitcher;
        initComponents();
                
        ActionListener updateClock = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date now = new Date();
                String time = sdf.format(now);
                jLabel9.setText(time);
                
                SimpleDateFormat dateSdf = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                String date = dateSdf.format(now);
                jLabel3.setText(date);
            }
        };

        // Set interval waktu untuk pembaruan jam (dalam milidetik)
        int delay = 1000; // 1 detik

        // Buat Timer untuk memperbarui jam
        Timer timer = new Timer(delay, updateClock);
        timer.start();
        
        //font
        Font fontPoppins3 = new Font("Poppins", Font.BOLD, 14);
        jLabel4.setFont(fontPoppins3);
        jLabel6.setFont(fontPoppins3);
        jLabel10.setFont(fontPoppins3);
        
        Font fontPoppins4 = new Font("Poppins", Font.PLAIN, 12);
        jLabel2.setFont(fontPoppins4);
        jLabel9.setFont(fontPoppins4);
        jLabel1.setFont(fontPoppins4);
        
        //button
        jLabel11.setFont(fontPoppins4);
        jLabel12.setFont(fontPoppins4);
        jLabel13.setFont(fontPoppins4);
        jLabel14.setFont(fontPoppins4);
        jLabel15.setFont(fontPoppins4);
        
        Font fontPoppins2 = new Font("Poppins", Font.BOLD, 13);
        jLabel3.setFont(fontPoppins2);
        
        Font fontPoppins9 = new Font("Poppins", Font.PLAIN, 13);
        jLabel5.setFont(fontPoppins9);
        jLabel7.setFont(fontPoppins9);
        jLabel8.setFont(fontPoppins9);
        
        startTimer();
    }
    
    public static void setId() throws SQLException {
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String userId = Func.getData();

            String sqlCheck = "SELECT * FROM admin WHERE id = " + userId;
            ResultSet rs = s.executeQuery(sqlCheck);

            if (rs.next()) { 
                String imageUrl2 = "https://api.multiavatar.com/" + rs.getString("username") + ".png";
                URL imageUrl = new URL(imageUrl2);
                BufferedImage originalImage = ImageIO.read(imageUrl);

                int newWidth = 30;
                int newHeight = 30;
                Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = resizedImage.createGraphics();
                g2d.drawImage(scaledImage, 0, 0, null);
                g2d.dispose();

                //page dashboard
                fotoP.setIcon(new ImageIcon(resizedImage));
                jLabel2.setText(rs.getString("username"));
                
                //page keluar
                Keluar.fotoP.setIcon(new ImageIcon(resizedImage));
                Keluar.jLabel2.setText(rs.getString("username"));
                
                //page admin
                Admin.fotoP.setIcon(new ImageIcon(resizedImage));
                Admin.jLabel2.setText(rs.getString("username"));
                
                //page info
                Info.fotoP.setIcon(new ImageIcon(resizedImage));
                Info.jLabel2.setText(rs.getString("username"));
                
                //page parkir
                Parkir.fotoP.setIcon(new ImageIcon(resizedImage));
                Parkir.jLabel2.setText(rs.getString("username"));
                
                //page setting
                Setting.fotoP.setIcon(new ImageIcon(resizedImage));
                Setting.jLabel2.setText(rs.getString("username"));
            } 
            
        } catch (IOException e) {
            e.printStackTrace(); // Tangani eksepsi jika terjadi kesalahan saat mengambil gambar dari URL.
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

        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelRound2 = new panel.PanelRound();
        panelRound3 = new panel.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new panel.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        fotoP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setText("     Admin");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 70, -1));

        jLabel11.setText("   Info");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 50, -1));

        jLabel12.setText("  Parkir");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 60, -1));

        jLabel13.setText(" Keluar");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 50, -1));

        jLabel15.setText("    Setting");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 70, -1));

        panelRound2.setBackground(new java.awt.Color(246, 127, 6));
        panelRound2.setRoundBottomLeft(15);
        panelRound2.setRoundBottomRight(15);
        panelRound2.setRoundTopLeft(15);
        panelRound2.setRoundTopRight(15);

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("11:40:43");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Senin, 21-10-2023");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Parkiran");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mobil");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("0");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("0");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Motor");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(116, 116, 116)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(83, 83, 83)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(panelRound2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 660, -1));

        jPanel2.setBackground(new java.awt.Color(255, 146, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);
        panelRound1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound1MouseClicked(evt);
            }
        });

        jLabel2.setText("Udin");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fotoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 120, 50));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 150));

        jLabel1.setText("Menu");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 100, 90));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/in.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 100, 90));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/out.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 100, 90));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/info.png"))); // NOI18N
        jButton4.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 100, 90));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/setting.png"))); // NOI18N
        jButton5.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 100, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Keluar.setId();
        } catch (SQLException ex) {
            
        }
        panelSwitcher.switchToPanel("Keluar");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Parkir.addModelComboBox();
        panelSwitcher.switchToPanel("Parkir");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Info.table(null);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelSwitcher.switchToPanel("Info");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Setting.table(null);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelSwitcher.switchToPanel("Setting");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Admin.chatServer();
        try {
            Admin.tables(null);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelSwitcher.switchToPanel("Admin");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void panelRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseClicked
        panelSwitcher.switchToPanel("login");
    }//GEN-LAST:event_panelRound1MouseClicked

    private void startTimer() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJLabel5();
                updateDainlain();
            }
        });
        timer.start();
    }
    
    private void updateJLabel5() {
        try {
            Connection conn = Koneksi.getKoneksi();
            Statement stmt = conn.createStatement();

            String sql = "SELECT COUNT(*) AS jumlah FROM space WHERE status = 0";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int jumlahSpaceKosong = rs.getInt("jumlah");
                jLabel5.setText("" + jumlahSpaceKosong);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateDainlain() {
        try {
            Connection conn = Koneksi.getKoneksi();
            Statement stmt = conn.createStatement();

            String sql = "SELECT COUNT(*) AS jumlah FROM parkir WHERE status = 1 AND IdVehicle = 14";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int jumlahSpaceKosong = rs.getInt("jumlah");
                jLabel7.setText("" + jumlahSpaceKosong);
            }
            
            String sql2 = "SELECT COUNT(*) AS jumlah FROM parkir WHERE status = 1 AND IdVehicle = 15";
            ResultSet rs2 = stmt.executeQuery(sql2);

            if (rs2.next()) {
                int jumlahSpaceKosong = rs2.getInt("jumlah");
                jLabel8.setText("" + jumlahSpaceKosong);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel fotoP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private panel.PanelRound panelRound1;
    private panel.PanelRound panelRound2;
    private panel.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
