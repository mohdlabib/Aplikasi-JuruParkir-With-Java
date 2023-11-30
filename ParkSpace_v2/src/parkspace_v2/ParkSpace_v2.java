/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parkspace_v2;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pages.Admin;
import pages.Dashboard;
import pages.Info;
import pages.Keluar;
import pages.Login;
import pages.Parkir;
import pages.Setting;

/**
 *
 * @author cyber
 */
public class ParkSpace_v2 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );                    
            FlatCyanLightIJTheme.setup();
        } catch( UnsupportedLookAndFeelException ex ) {
            System.err.println( "Failed to initialize LaF" );
        }  
        
        int borderCompenent = 10;
        
        UIManager.put( "Button.arc", borderCompenent );
        UIManager.put( "TextComponent.arc", borderCompenent );
        UIManager.put( "Component.arc", borderCompenent );
        
        JFrame frame = new JFrame("ParkSpace");
        JPanel cardPanel = new JPanel(new CardLayout());

        PanelSwitcher panelSwitcher = new PanelSwitcher(cardPanel);

        Login login = new Login(panelSwitcher);
        Dashboard dashboard = new Dashboard(panelSwitcher);
        Parkir parkir = new Parkir(panelSwitcher);
        Keluar keluar = new Keluar(panelSwitcher);
        Setting setting = new Setting(panelSwitcher);
        Admin admin = new Admin(panelSwitcher);
        Info info = new Info(panelSwitcher);
        
        // add pages
        cardPanel.add(login, "login");
        cardPanel.add(dashboard, "dashboard");
        cardPanel.add(parkir, "Parkir");
        cardPanel.add(keluar, "Keluar");
        cardPanel.add(setting, "Setting");
        cardPanel.add(admin, "Admin");
        cardPanel.add(info, "Info");

        // Tambahkan cardPanel ke frame dengan konstraints
        frame.add(cardPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(915, 484);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
}
