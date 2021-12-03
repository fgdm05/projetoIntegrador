/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.integrador.escola.modelos.telas.tela_aluno;

import br.com.senac.integrador.escola.modelos.auxiliares.LoginSessionAlunos;
import br.com.senac.integrador.escola.modelos.auxiliares.LoginSessionProfessores;
import br.com.senac.integrador.escola.modelos.auxiliares.MySQL_Connection;
import br.com.senac.integrador.escola.modelos.telas.tela_professor.page_turmas;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan
 */
public class page_inicio extends javax.swing.JInternalFrame {
    
    DefaultTableModel model_aulas;
    DefaultTableModel model_atividades;
    /**
     * Creates new form Inicio
     */
    public page_inicio() throws SQLException {
        initComponents();
        
        model_aulas = (DefaultTableModel) table_aulas.getModel();  
        model_atividades = (DefaultTableModel) table_atividades.getModel();
        
        getAulas();
        
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
        jScrollPane5 = new javax.swing.JScrollPane();
        table_aulas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_atividades = new javax.swing.JTable();
        todas_button = new javax.swing.JRadioButton();
        aulaSelectButton = new javax.swing.JRadioButton();
        combo_disciplina = new javax.swing.JComboBox<>();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(590, 480));

        tab_inicio.setBackground(new java.awt.Color(67, 148, 222));
        tab_inicio.setPreferredSize(new java.awt.Dimension(590, 480));

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        table_aulas.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        table_aulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Disciplina", "Conteúdo", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_aulas.setToolTipText("");
        table_aulas.setFocusable(false);
        table_aulas.setGridColor(new java.awt.Color(0, 0, 0));
        table_aulas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_aulas.setPreferredSize(new java.awt.Dimension(278, 287));
        table_aulas.setRowHeight(18);
        table_aulas.setSelectionBackground(new java.awt.Color(232, 180, 88));
        table_aulas.setShowGrid(true);
        table_aulas.setShowHorizontalLines(false);
        table_aulas.getTableHeader().setReorderingAllowed(false);
        table_aulas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_aulasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_aulas);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Aulas");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Atividades");

        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        table_atividades.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        table_atividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Disciplina", "Conteúdo", "Descrição", "Data", "Prazo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_atividades.setToolTipText("");
        table_atividades.setFocusable(false);
        table_atividades.setGridColor(new java.awt.Color(0, 0, 0));
        table_atividades.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_atividades.setPreferredSize(new java.awt.Dimension(278, 287));
        table_atividades.setRowHeight(18);
        table_atividades.setSelectionBackground(new java.awt.Color(232, 180, 88));
        table_atividades.setShowGrid(true);
        table_atividades.setShowHorizontalLines(false);
        table_atividades.getTableHeader().setReorderingAllowed(false);
        table_atividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_atividadesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_atividades);

        todas_button.setBackground(new java.awt.Color(67, 148, 222));
        todas_button.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        todas_button.setForeground(new java.awt.Color(255, 255, 255));
        todas_button.setText("Todas");
        todas_button.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                todas_buttonStateChanged(evt);
            }
        });

        aulaSelectButton.setBackground(new java.awt.Color(67, 148, 222));
        aulaSelectButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        aulaSelectButton.setForeground(new java.awt.Color(255, 255, 255));
        aulaSelectButton.setSelected(true);
        aulaSelectButton.setText("Aula selecionada");
        aulaSelectButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                aulaSelectButtonStateChanged(evt);
            }
        });

        combo_disciplina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artes", "Biologia", "Ed. Física",
            "Filosofia", "Física", "Geografia", "História", "Inglês",
            "Literatura", "Mat", "Português", "Química", "Sociologia" }));
combo_disciplina.addItemListener(new java.awt.event.ItemListener() {
    public void itemStateChanged(java.awt.event.ItemEvent evt) {
        combo_disciplinaItemStateChanged(evt);
    }
    });

    javax.swing.GroupLayout tab_inicioLayout = new javax.swing.GroupLayout(tab_inicio);
    tab_inicio.setLayout(tab_inicioLayout);
    tab_inicioLayout.setHorizontalGroup(
        tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(tab_inicioLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tab_inicioLayout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(todas_button)
                    .addGap(18, 18, 18)
                    .addComponent(aulaSelectButton))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addComponent(jScrollPane6)
                .addGroup(tab_inicioLayout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    tab_inicioLayout.setVerticalGroup(
        tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab_inicioLayout.createSequentialGroup()
            .addGap(13, 13, 13)
            .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(combo_disciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(tab_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(aulaSelectButton)
                .addComponent(todas_button)
                .addComponent(jLabel5))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(tab_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tab_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_aulasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_aulasMouseClicked
        if(table_aulas.getSelectionModel().isSelectionEmpty()) {
            return;
        } else {
            try {
                getAtividades((String) model_aulas.getValueAt(table_aulas.getSelectedRow(), 0), false);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(page_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_table_aulasMouseClicked

    private void table_atividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_atividadesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_atividadesMouseClicked

    private void todas_buttonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_todas_buttonStateChanged
        if (todas_button.isSelected() == true) {
                aulaSelectButton.setSelected(false);
                if(table_aulas.getSelectionModel().isSelectionEmpty()) {
                    return;
                } else {
                    try {
                        getAtividades((String) model_aulas.getValueAt(table_aulas.getSelectedRow(), 0), true);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(page_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }

        } else if (todas_button.isSelected() == false) {
            aulaSelectButton.setSelected(true);
        }
    }//GEN-LAST:event_todas_buttonStateChanged

    private void aulaSelectButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_aulaSelectButtonStateChanged
        if (aulaSelectButton.isSelected() == true) {
                todas_button.setSelected(false);
                if(table_aulas.getSelectionModel().isSelectionEmpty()) {
                    return;
                } else {
                    try {
                        getAtividades((String) model_aulas.getValueAt(table_aulas.getSelectedRow(), 0), false);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(page_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }

        } else if (aulaSelectButton.isSelected() == false) {
            todas_button.setSelected(true);
        }
    }//GEN-LAST:event_aulaSelectButtonStateChanged

    private void combo_disciplinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_disciplinaItemStateChanged
        try {
            getAulas();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(page_inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_combo_disciplinaItemStateChanged

    
    private void getAulas() throws SQLException 
    {
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        Statement statement = myConn.createStatement();
        Statement getSala = myConn.createStatement();
        ResultSet rs_sala = getSala.executeQuery("SELECT salaTurma FROM estudante where idEstudante = " + LoginSessionAlunos.idEstudante);  
        rs_sala.next();
        String sala = rs_sala.getString("salaTurma");
        
        model_aulas.setRowCount(0);
        
        ResultSet aulas = statement.executeQuery("SELECT * from aulas where salaTurma = '" + sala + "' and disciplinaAula = '" + combo_disciplina.getSelectedItem() + "' ORDER BY dataAula desc");
        
        while(aulas.next())
        {
            String id = aulas.getString("idAula");
            String disciplina = (String) combo_disciplina.getSelectedItem();
            String conteudo = aulas.getString("conteudo");
            String data = aulas.getString("dataAula");
            Object dadosAula[] = {id, disciplina, conteudo, data};  
            
            model_aulas.addRow(dadosAula);
        } 
    }  

    private void getAtividades(String idAula, boolean option) throws SQLException 
    {
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        Statement statement = myConn.createStatement();
        
        Statement getSala = myConn.createStatement();
        ResultSet rs_sala = getSala.executeQuery("SELECT salaTurma FROM estudante where idEstudante = " + LoginSessionAlunos.idEstudante);  
        rs_sala.next();
        String sala = rs_sala.getString("salaTurma");
        
        String selected = ("SELECT * FROM atividades WHERE disciplinaAtividade = '" + combo_disciplina.getSelectedItem() + "' AND salaTurma = '" + sala + "' AND idAula = " + idAula + " ORDER BY dataAtividade desc");
        String every = ("SELECT * FROM atividades WHERE disciplinaAtividade = '" + combo_disciplina.getSelectedItem() + "' AND salaTurma = '" + sala + "' ORDER BY dataAtividade desc");
        
        if(option) {
            ResultSet atividades = statement.executeQuery(every);

            model_atividades.setRowCount(0);

            while(atividades.next())
            {
                String id = atividades.getString("idAtividade");
                String disciplina = (String) combo_disciplina.getSelectedItem();
                String conteudo = atividades.getString("conteudo");
                String descricao = atividades.getString("descricao");
                String data = atividades.getString("dataAtividade");
                String prazo = atividades.getString("prazoAtividade");

                Object dadosAtividade[] = {id, disciplina, conteudo, descricao, data, prazo};  

                model_atividades.addRow(dadosAtividade);
            }             
        } else {
            ResultSet atividades = statement.executeQuery(selected);

            model_atividades.setRowCount(0);

            while(atividades.next())
            {
                String id = atividades.getString("idAtividade");
                String disciplina = LoginSessionProfessores.disciplina;
                String conteudo = atividades.getString("conteudo");
                String descricao = atividades.getString("descricao");
                String data = atividades.getString("dataAtividade");
                String prazo = atividades.getString("prazoAtividade");

                Object dadosAtividade[] = {id, disciplina, conteudo, descricao, data, prazo};  

                model_atividades.addRow(dadosAtividade);
            }            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aulaSelectButton;
    private javax.swing.JComboBox<String> combo_disciplina;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel tab_inicio;
    private javax.swing.JTable table_atividades;
    private javax.swing.JTable table_aulas;
    private javax.swing.JRadioButton todas_button;
    // End of variables declaration//GEN-END:variables
}
