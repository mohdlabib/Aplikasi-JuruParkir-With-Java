/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pages;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import parkspace_v2.Func;
import parkspace_v2.Koneksi;
import parkspace_v2.PanelSwitcher;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;
import java.sql.PreparedStatement;
import panel.AddSetting;
import panel.UpdateSetting;

/**
 *
 * @author cyber
 */
public final class Setting extends javax.swing.JPanel {
    private PanelSwitcher panelSwitcher = null;

    /**
     * Creates new form Setting
     * @param panelSwitcher
     */
    public Setting(PanelSwitcher panelSwitcher) throws SQLException {
        this.panelSwitcher = panelSwitcher;
        initComponents();
        
        table(null);
        fieldSearch();
    
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int id = (int) table.getModel().getValueAt(row, 3);
                UpdateSetting panelUpdate = new UpdateSetting(id);
                panelUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                panelUpdate.setVisible(true);
                try {
                    table(null);
                } catch (SQLException ex) {
                    Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
            int id = (int) table.getModel().getValueAt(row, 3);

            int choice = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                try {
                    Connection c = Koneksi.getKoneksi();
                    Statement s = c.createStatement();

                    String sql = "DELETE FROM vehicle WHERE id =" + id;
                    int rowsDeleted = s.executeUpdate(sql);

                    if (rowsDeleted > 0) {
                        String sql2 = "DELETE FROM space WHERE type =" + id;
                        s.executeUpdate(sql2);
                    
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(row);
                        
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (SQLException e) {
                    e.printStackTrace(); 
                }
            }
            
            try {
                table(null);
            } catch (SQLException ex) {
                Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
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
        table.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
        
        Font fontPoppins4 = new Font("Poppins", Font.PLAIN, 12);
        jLabel2.setFont(fontPoppins4);
        jButton2.setFont(fontPoppins4);
        table.setFont(fontPoppins4);

    }
    
    public static void table(String query) throws SQLException {
        try {
            Connection c = Koneksi.getKoneksi();
            String sql;

            if (query == null) {
                sql = "SELECT id, nama, harga, slot FROM vehicle";
            } else {
                sql = "SELECT id, nama, harga, slot FROM vehicle WHERE nama LIKE ?";
            }

            PreparedStatement preparedStatement = c.prepareStatement(sql);

            if (query != null) {
                preparedStatement.setString(1, "%" + query + "%");
            }

            ResultSet rs = preparedStatement.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                String nama = rs.getString("nama");
                double harga = rs.getDouble("harga");
                int slot = rs.getInt("slot");
                int id = rs.getInt("id");

                // Tambahkan data ke model tabel
                model.addRow(new Object[]{nama, harga, slot, id});
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Tangani eksepsi jika terjadi kesalahan saat mengakses database.
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

        panelRound3 = new panel.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        jButton2 = new javax.swing.JButton();
        searchTable = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new panel.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        fotoP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setBackground(new java.awt.Color(246, 127, 6));
        panelRound3.setRoundBottomLeft(10);
        panelRound3.setRoundBottomRight(10);
        panelRound3.setRoundTopLeft(10);
        panelRound3.setRoundTopRight(10);

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Harga", "Slot ", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setShowGrid(false);
        jScrollPane1.setViewportView(table);

        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(searchTable, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(searchTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 590, 400));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 40, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AddSetting panelAdd = new AddSetting();
        panelAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelAdd.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        panelSwitcher.switchToPanel("dashboard");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldSearch() {
        searchTable.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    updateTextFieldText();
                } catch (SQLException ex) {
                    Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    updateTextFieldText();
                } catch (SQLException ex) {
                    Logger.getLogger(Setting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak digunakan dalam JTextField biasa
            }

            private void updateTextFieldText() throws SQLException {
                String text = searchTable.getText();
                table(text);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    public static javax.swing.JLabel fotoP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private panel.PanelRound panelRound1;
    private panel.PanelRound panelRound3;
    private javax.swing.JTextField searchTable;
    public static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
