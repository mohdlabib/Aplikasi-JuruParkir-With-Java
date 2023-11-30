/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages;

import com.formdev.flatlaf.FlatClientProperties;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import panel.AddAdmin;
import panel.UpdateAdmin;
import parkspace_v2.Func;
import parkspace_v2.Koneksi;
import parkspace_v2.PanelSwitcher;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

/**
 *
 * @author cyber
 */
public class Admin extends javax.swing.JPanel {
    private PanelSwitcher panelSwitcher = null;

    private static String userName;
    private static Socket s;
    
    /**
     * Creates new form Admin
     * @param panelSwitcher
     */
    public Admin(PanelSwitcher panelSwitcher) throws SQLException {
        this.panelSwitcher = panelSwitcher;
        initComponents();
        init();
        chatServer();
        tables(null);
        fieldSearch();
        
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int id = (int) table.getModel().getValueAt(row, 1);
                UpdateAdmin panelUpdate = new UpdateAdmin(id);
                panelUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                panelUpdate.setVisible(true);
                try {
                    tables(null);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
            int id = (int) table.getModel().getValueAt(row, 1);

            int choice = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                try {
                    Connection c = Koneksi.getKoneksi();
                    Statement s = c.createStatement();

                    String sql = "DELETE FROM admin WHERE id =" + id;
                    int rowsDeleted = s.executeUpdate(sql);
                    
                    if (rowsDeleted > 0) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(row);

                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                } catch (SQLException e) {
                    e.printStackTrace(); 
                }
                
                try {
                    tables(null);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            
        }; 
        
        int columnCount = table.getColumnCount();
        for (int e = 0; e < columnCount; e++) {
            table.getColumnModel().getColumn(e).setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
                }
            });
        }
        table.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditor(event));
    }
    
    public static void tables(String query) throws SQLException {
        try {
            Connection c = Koneksi.getKoneksi();
            String sql;

            if (query == null) {
                sql = "SELECT id, username FROM admin ORDER BY id DESC";
            } else {
                sql = "SELECT id, username FROM admin WHERE username LIKE ?";
            }

            PreparedStatement preparedStatement = c.prepareStatement(sql);

            if (query != null) {
                preparedStatement.setString(1, "%" + query + "%");
            }

            ResultSet rs = preparedStatement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String nama = rs.getString("username");
                int id = rs.getInt("id");

                model.addRow(new Object[]{nama, id});
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void fieldSearch() {
        searchTable.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    updateTextFieldText();
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    updateTextFieldText();
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}

            private void updateTextFieldText() throws SQLException {
                String text = searchTable.getText();
                tables(text);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound3 = new panel.PanelRound();
        panelRound5 = new panel.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        panelRound6 = new panel.PanelRound();
        lbStatus = new javax.swing.JLabel();
        textChat = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMS = new javax.swing.JTextArea();
        panelRound2 = new panel.PanelRound();
        tambahData = new javax.swing.JButton();
        searchTable = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panelRound4 = new panel.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new panel.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        fotoP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setRoundBottomLeft(10);
        panelRound3.setRoundBottomRight(10);
        panelRound3.setRoundTopLeft(10);
        panelRound3.setRoundTopRight(10);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setBackground(new java.awt.Color(246, 127, 6));
        panelRound5.setRoundTopLeft(10);
        panelRound5.setRoundTopRight(10);

        jLabel1.setText("Chat Admin");

        panelRound6.setRoundBottomLeft(13);
        panelRound6.setRoundBottomRight(13);
        panelRound6.setRoundTopLeft(13);
        panelRound6.setRoundTopRight(13);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbStatus.setBackground(new java.awt.Color(153, 255, 153));
        lbStatus.setForeground(new java.awt.Color(196, 57, 57));
        lbStatus.setText("    Offline");
        panelRound6.add(lbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelRound3.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 40));
        panelRound3.add(textChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 30));

        jButton2.setText("Kirim");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelRound3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 340, 70, 30));

        txtMS.setColumns(20);
        txtMS.setRows(5);
        jScrollPane2.setViewportView(txtMS);

        panelRound3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, 280));

        add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 310, 380));

        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambahData.setText("Tambah Admin");
        tambahData.setPreferredSize(new java.awt.Dimension(112, 30));
        tambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahDataActionPerformed(evt);
            }
        });
        panelRound2.add(tambahData, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 121, -1));

        searchTable.setPreferredSize(new java.awt.Dimension(64, 30));
        panelRound2.add(searchTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 6, 165, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setPreferredSize(new java.awt.Dimension(310, 210));
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(table);

        panelRound2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 460, 320));

        panelRound4.setBackground(new java.awt.Color(246, 127, 6));
        panelRound4.setPreferredSize(new java.awt.Dimension(480, 42));
        panelRound4.setRoundTopLeft(10);
        panelRound4.setRoundTopRight(10);

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelRound2.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 40));

        add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 480, 380));

        jPanel1.setBackground(new java.awt.Color(255, 146, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 181));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);

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

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 120, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 40, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        s.emit("message", userName + " : " + textChat.getText().trim());
        textChat.setText("");
        textChat.grabFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahDataActionPerformed
        AddAdmin panelAdd = new AddAdmin();
        panelAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelAdd.setVisible(true);
    }//GEN-LAST:event_tambahDataActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        panelSwitcher.switchToPanel("dashboard");
    }//GEN-LAST:event_jButton1ActionPerformed
  
    public static void chatServer(){
        try {
            Connection c = Koneksi.getKoneksi();
            Statement sl = c.createStatement();
            String userId = Func.getData();

            String sqlCheck = "SELECT * FROM admin WHERE id = " + userId;
            ResultSet rs = sl.executeQuery(sqlCheck);

            if (rs.next()) {
                userName = rs.getString("username");

                s = IO.socket("http://localhost:3000/");
                s.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                    @Override
                    public void call(Object... arg0) {
                        lbStatus.setText("    Online");
                        lbStatus.setForeground(new Color(22, 139, 47));
                    }
                });
                s.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                    @Override
                    public void call(Object... arg0) {
                        lbStatus.setText("    Offline");
                        lbStatus.setForeground(new Color(196, 57, 57));
                    }
                });
                s.on("message", new Emitter.Listener() {
                    @Override
                    public void call(Object... arg0) {
                        txtMS.append(arg0[0].toString() + "\n");
                    }
                });
                s.open();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        searchTable.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        textChat.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Pesan...");
        tambahData.putClientProperty( "JComponent.roundRect", true );
        
        Font fontPoppins4 = new Font("Poppins", Font.PLAIN, 12);
        jLabel2.setFont(fontPoppins4);
        tambahData.setFont(fontPoppins4);
        lbStatus.setFont(fontPoppins4);
        jLabel1.setFont(fontPoppins4);
        jButton2.setFont(fontPoppins4);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel fotoP;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lbStatus;
    private panel.PanelRound panelRound1;
    private panel.PanelRound panelRound2;
    private panel.PanelRound panelRound3;
    private panel.PanelRound panelRound4;
    private panel.PanelRound panelRound5;
    private panel.PanelRound panelRound6;
    private javax.swing.JTextField searchTable;
    private static javax.swing.JTable table;
    private javax.swing.JButton tambahData;
    private javax.swing.JTextField textChat;
    public static javax.swing.JTextArea txtMS;
    // End of variables declaration//GEN-END:variables
}
