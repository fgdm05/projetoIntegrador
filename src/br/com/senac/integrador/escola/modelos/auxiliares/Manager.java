package br.com.senac.integrador.escola.modelos.auxiliares;

import br.com.senac.integrador.escola.modelos.Login;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Felipe Godinho Dal Molin
 */
public abstract class Manager {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static int getIndexOfButtonSelectByList(ArrayList<AbstractButton> buttonsPeriodo) {
        for(AbstractButton button : buttonsPeriodo) {
            if(button.isSelected()){
                return buttonsPeriodo.indexOf(button);
            }
        }
        throw new RuntimeException("Nenhum botão selecionado.");
    }
    public static ArrayList<String> getListInputs(Component[] components) {
        List<Component> componentsList = Arrays.asList(components);
        ArrayList<JTextField> jTextFields = new ArrayList<>();
        componentsList.forEach((componente) -> {
            if(componente.getClass() == JTextField.class) {
                jTextFields.add((JTextField) componente);
            }
        });
        ArrayList<String> inputs = getInputs(jTextFields);
        return inputs;
    }
    private static ArrayList<String> getInputs(ArrayList<JTextField> list) {
        ArrayList<String> inputs = new ArrayList<>();
        list.forEach((textField) -> {
            inputs.add(textField.getText());
        });
        return inputs;
    }

    
    private static final File FILE = new File("loginAdministrador.csv");
    public static Login getLogin() {
        FileReader fr;
        BufferedReader br;
        
        String username = null, password = null;
        
        try {
            fr = new FileReader(FILE);
            br = new BufferedReader(fr);
            
            // linha 1 usuario
            // linha 2 senha
            
            username = br.readLine();
            password = br.readLine();
            
            br.close();
            fr.close();
            System.out.println(username);
            System.out.println(password);
        } catch(IOException e) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        Login login = new Login(username,password);
        return login;
        
    }

}