/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.integrador.escola.modelos.telas.tela_aluno;

import br.com.senac.integrador.escola.modelos.auxiliares.LoginSessionAlunos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Jonathan
 */
public class page_ocorrencias extends javax.swing.JInternalFrame {

    /**
     * Creates new form Inicio
     */
    public page_ocorrencias() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab_inicio = new javax.swing.JPanel();
        label_tipoOcorrencia = new javax.swing.JLabel();
        label_dataOc = new javax.swing.JLabel();
        label_localOc = new javax.swing.JLabel();
        label_autorOc = new javax.swing.JLabel();
        label_vitimaOc = new javax.swing.JLabel();
        label_tipoOcorrencia5 = new javax.swing.JLabel();
        label_tipoOcorrencia6 = new javax.swing.JLabel();
        combo_tipoOcor = new javax.swing.JComboBox<>();
        field_dataOc = new javax.swing.JTextField();
        field_localOc = new javax.swing.JTextField();
        field_autorOc = new javax.swing.JTextField();
        field_vitimaOc = new javax.swing.JTextField();
        radio_SimOc = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_descricao = new javax.swing.JTextArea();
        button_enviar_ocorrencia = new javax.swing.JButton();
        label_charCounter = new javax.swing.JLabel();
        charCount = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(590, 480));

        tab_inicio.setBackground(new java.awt.Color(67, 148, 222));
        tab_inicio.setPreferredSize(new java.awt.Dimension(590, 480));

        label_tipoOcorrencia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_tipoOcorrencia.setForeground(new java.awt.Color(255, 255, 255));
        label_tipoOcorrencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_tipoOcorrencia.setText("Tipo de ocorrência:");

        label_dataOc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_dataOc.setForeground(new java.awt.Color(255, 255, 255));
        label_dataOc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_dataOc.setText("Quando ocorreu:");

        label_localOc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_localOc.setForeground(new java.awt.Color(255, 255, 255));
        label_localOc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_localOc.setText("Onde ocorreu:");

        label_autorOc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_autorOc.setForeground(new java.awt.Color(255, 255, 255));
        label_autorOc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_autorOc.setText("Autor(es):");

        label_vitimaOc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_vitimaOc.setForeground(new java.awt.Color(255, 255, 255));
        label_vitimaOc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_vitimaOc.setText("Vítima(s):");

        label_tipoOcorrencia5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_tipoOcorrencia5.setForeground(new java.awt.Color(255, 255, 255));
        label_tipoOcorrencia5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_tipoOcorrencia5.setText("Manter anonimato:");

        label_tipoOcorrencia6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_tipoOcorrencia6.setForeground(new java.awt.Color(255, 255, 255));
        label_tipoOcorrencia6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_tipoOcorrencia6.setText("Descrição do ocorrido:");

        combo_tipoOcor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agressão Física", "Agressão Verbal", "Ameaça", "Bullying/Perseguição", "Infraestrutura escolar", "Notas erradas", "Preconceito", "Roubo/Furto", "Vandalismo", "Violência Sexual" }));
        combo_tipoOcor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        field_dataOc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        field_dataOc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        field_localOc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        field_localOc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        field_autorOc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        field_autorOc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        field_vitimaOc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        field_vitimaOc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        radio_SimOc.setText("Sim");
        radio_SimOc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        field_descricao.setColumns(20);
        field_descricao.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        field_descricao.setLineWrap(true);
        field_descricao.setRows(5);
        field_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_descricaoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(field_descricao);

        button_enviar_ocorrencia.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        button_enviar_ocorrencia.setText("Enviar");
        button_enviar_ocorrencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_enviar_ocorrencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_enviar_ocorrenciaMouseClicked(evt);
            }
        });

        label_charCounter.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_charCounter.setForeground(new java.awt.Color(255, 255, 255));
        label_charCounter.setText("Caracteres:");

        charCount.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        charCount.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tab_inicioLayout = new javax.swing.GroupLayout(tab_inicio);
        tab_inicio.setLayout(tab_inicioLayout);
        tab_inicioLayout.setHorizontalGroup(
            tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_inicioLayout.createSequentialGroup()
                        .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tipoOcorrencia)
                            .addComponent(label_dataOc)
                            .addComponent(label_localOc)
                            .addComponent(label_autorOc)
                            .addComponent(label_vitimaOc)
                            .addComponent(label_tipoOcorrencia5))
                        .addGap(45, 45, 45)
                        .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_tipoOcor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(field_dataOc)
                            .addComponent(field_localOc)
                            .addComponent(field_autorOc)
                            .addComponent(field_vitimaOc)
                            .addGroup(tab_inicioLayout.createSequentialGroup()
                                .addComponent(radio_SimOc)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(tab_inicioLayout.createSequentialGroup()
                        .addComponent(label_tipoOcorrencia6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(tab_inicioLayout.createSequentialGroup()
                        .addComponent(button_enviar_ocorrencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_charCounter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(charCount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tab_inicioLayout.setVerticalGroup(
            tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tipoOcorrencia)
                    .addComponent(combo_tipoOcor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dataOc)
                    .addComponent(field_dataOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_localOc)
                    .addComponent(field_localOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_autorOc)
                    .addComponent(field_autorOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_vitimaOc)
                    .addComponent(field_vitimaOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tipoOcorrencia5)
                    .addComponent(radio_SimOc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_tipoOcorrencia6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_charCounter)
                        .addComponent(charCount))
                    .addComponent(button_enviar_ocorrencia))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private static boolean isSQLSet = false;
    private static Connection connection;
    
    private static Connection createConnection() throws SQLException {
        if(isSQLSet) {
            return connection;
        }
        //String username = JOptionPane.showInputDialog("Insira o usuário do banco de dados.");
        //String password = JOptionPane.showInputDialog("Insira a senha do banco de dados.");
        
        String username = "root";
        String password = "inserida";
        
        String url = "jdbc:mysql://localhost/appescola";
        isSQLSet = true;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }    
    
    private void field_descricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_descricaoKeyTyped
        String charNum = String.valueOf(field_descricao.getText().length());

        charCount.setText(charNum);
            
        if (field_descricao.getText().length() > 512)
        {
            charCount.setForeground(Color.red);
        }
        
        else
        {
            charCount.setForeground(Color.white);
        }
    }//GEN-LAST:event_field_descricaoKeyTyped

    private void submitOcorrencia(int idPessoa) throws SQLException {
        connection = createConnection();
        Statement enviar = connection.createStatement();
        
        boolean mostrar_nome;
        
        LocalDate date = LocalDate.now();
 
	Date currentDate = new Date();		
	SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");		
	String currenttime = formatter.format(currentDate);
        
        if(radio_SimOc.isSelected()) {
            mostrar_nome = false;
        }
        else {
            mostrar_nome = true;
        }
        
        enviar.executeUpdate("INSERT INTO ocorrencia (tipoOcorrencia, idPessoa, mostrarNome, dataBO, horaBO, dataOcorrencia, localOcorrencia, autorOcorrencia, vitimaOcorrencia, descricao) VALUES('" 
            + combo_tipoOcor.getSelectedItem().toString() 
            + "', " 
            + idPessoa 
            + ", "
            + mostrar_nome 
            + ", '"
            + date
            + "', '"
            + currenttime
            + "', '"
            + field_dataOc.getText()
            + "', '"
            + field_localOc.getText()
            + "', '"
            + field_autorOc.getText()
            + "', '"
            + field_vitimaOc.getText()
            + "', '"
            + field_descricao.getText()
            + "');"
        );
    }
    
    private void button_enviar_ocorrenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_enviar_ocorrenciaMouseClicked
        try {
            submitOcorrencia(LoginSessionAlunos.idPessoa);
        } catch (SQLException ex) {
            Logger.getLogger(page_ocorrencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_enviar_ocorrenciaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_enviar_ocorrencia;
    private javax.swing.JLabel charCount;
    private javax.swing.JComboBox<String> combo_tipoOcor;
    private javax.swing.JTextField field_autorOc;
    private javax.swing.JTextField field_dataOc;
    private javax.swing.JTextArea field_descricao;
    private javax.swing.JTextField field_localOc;
    private javax.swing.JTextField field_vitimaOc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_autorOc;
    private javax.swing.JLabel label_charCounter;
    private javax.swing.JLabel label_dataOc;
    private javax.swing.JLabel label_localOc;
    private javax.swing.JLabel label_tipoOcorrencia;
    private javax.swing.JLabel label_tipoOcorrencia5;
    private javax.swing.JLabel label_tipoOcorrencia6;
    private javax.swing.JLabel label_vitimaOc;
    private javax.swing.JRadioButton radio_SimOc;
    private javax.swing.JPanel tab_inicio;
    // End of variables declaration//GEN-END:variables
}