package br.com.senac.integrador.escola.modelos.auxiliares;

import java.awt.Color;
import java.awt.event.ComponentEvent;
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

    public static void changeJFrame(ComponentEvent evt, JFrame destiny) {
        SwingUtilities.getWindowAncestor(evt.getComponent()).setVisible(false);
        destiny.setLocationRelativeTo(null);
        destiny.setVisible(true);
    }
    public static void sectionMouseEntered(MouseEvent evt) {
        evt.getComponent().setBackground(colorEvent);
    }
    public static void sectionMouseExited(MouseEvent evt) {
        evt.getComponent().setBackground(colorNormal);
    }
    public static void campoFocusGained(java.awt.event.FocusEvent evt, javax.swing.JTextField textField, String placeholder) {
        if(textField.getText().equals(placeholder)) {
            textField.setText("");
        }
        textField.setForeground(Color.BLACK);
    }
    public static void campoFocusLost(java.awt.event.FocusEvent evt, javax.swing.JTextField textField, String placeholder) {
        if(textField.getText().isBlank()) {
            textField.setText(placeholder);
            textField.setForeground(new Color(153,153,153));
            return;
        }
        textField.setForeground(Color.BLACK);
    }
}