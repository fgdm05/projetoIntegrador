package br.com.senac.integrador.escola.modelos.auxiliares;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Definição da classe auxiliar abstrata JFrameManager
 * @author Felipe Godinho Dal Molin
 */
public abstract class JFrameManager {
    private static final Color colorNormal = new Color(19,16,89);
    private static final Color colorEvent = new Color(15,34,61);

    public static void changeJFrame(MouseEvent evt, JFrame destiny) {
        SwingUtilities.getWindowAncestor(evt.getComponent()).setVisible(false);
        destiny.setVisible(true);
    }
    public static void sectionMouseEntered(MouseEvent evt) {
        evt.getComponent().setBackground(colorEvent);
    }
    public static void sectionMouseExited(MouseEvent evt) {
        evt.getComponent().setBackground(colorNormal);
    }
}