/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkspace_v2;

/**
 *
 * @author cyber
 */
import java.awt.CardLayout;
import javax.swing.JPanel;

public class PanelSwitcher {
    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    public PanelSwitcher(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        this.cardLayout = (CardLayout) cardPanel.getLayout();
    }

    public void switchToPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }
}
