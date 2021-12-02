/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.integrador.escola.modelos.telas.tela_aluno;

import br.com.senac.integrador.escola.modelos.auxiliares.LoginSessionAlunos;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan
 */
public class page_frequencia extends javax.swing.JInternalFrame {
    
    DefaultTableModel model_frequencia;
    
    /**
     * Creates new form Inicio
     */
    public page_frequencia() throws SQLException {
        initComponents();
        
        model_frequencia = (DefaultTableModel) table_frequencia.getModel();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
        fillFrequencia(LoginSessionAlunos.idEstudante, 1);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        table_frequencia = new javax.swing.JTable();
        combo_trimestre = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(590, 480));

        tab_inicio.setBackground(new java.awt.Color(67, 148, 222));
        tab_inicio.setPreferredSize(new java.awt.Dimension(590, 480));

        table_frequencia.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        table_frequencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_frequencia.setFocusable(false);
        table_frequencia.setGridColor(new java.awt.Color(0, 0, 0));
        table_frequencia.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_frequencia.setRowHeight(18);
        table_frequencia.setSelectionBackground(new java.awt.Color(232, 180, 88));
        table_frequencia.setShowGrid(true);
        table_frequencia.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(table_frequencia);
        table_frequencia.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table_frequencia.getTableHeader().setOpaque(false);
        table_frequencia.setRowHeight(18);

        combo_trimestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1º Tri", "2º Tri", "3º Tri"}));
        combo_trimestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_trimestreItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Faltas");

        javax.swing.GroupLayout tab_inicioLayout = new javax.swing.GroupLayout(tab_inicio);
        tab_inicio.setLayout(tab_inicioLayout);
        tab_inicioLayout.setHorizontalGroup(
            tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(tab_inicioLayout.createSequentialGroup()
                        .addComponent(combo_trimestre, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tab_inicioLayout.setVerticalGroup(
            tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_trimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
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

    private void combo_trimestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_trimestreItemStateChanged
        try {
            fillFrequencia(LoginSessionAlunos.idEstudante, combo_trimestre.getSelectedIndex() + 1);
        } catch (SQLException ex) {
            Logger.getLogger(page_frequencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_combo_trimestreItemStateChanged

        
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
     
   
    
    
    private void fillFrequencia(int idEstudante, int trimestre) throws SQLException 
    {
        connection = createConnection();
        Statement statement = connection.createStatement();
        
        ResultSet faltas = statement.executeQuery("SELECT * from faltas where idEstudante = " + idEstudante + " and trimestre = " + trimestre);

        model_frequencia.setRowCount(0);
        
        while(faltas.next())
        {
            String disciplina = faltas.getString("disciplinaFalta");
            String data = faltas.getString("dataFalta");
            
            Object dadosFalta[] = {data, disciplina};  
            
            model_frequencia.addRow(dadosFalta);
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_trimestre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tab_inicio;
    private javax.swing.JTable table_frequencia;
    // End of variables declaration//GEN-END:variables
}
