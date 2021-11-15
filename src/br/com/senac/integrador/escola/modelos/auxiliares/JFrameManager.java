package br.com.senac.integrador.escola.modelos.auxiliares;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Definição da classe auxiliar abstrata JFrameManager
 * @author Felipe Godinho Dal Molin
 */
public abstract class JFrameManager {
    private static final Color colorNormal = new Color(19,16,89);
    private static final Color colorEvent = new Color(15,34,61);
    public static void changeJFrame(JFrame origin, JFrame target) {
        origin.setVisible(false);
        target.setVisible(true);
    }
    public static void sectionMouseEntered(MouseEvent evt, JPanel panel) {
        panel.setBackground(colorEvent);
    }
    public static void sectionMouseExited(MouseEvent evt, JPanel panel) {
        panel.setBackground(colorNormal);
    }
}