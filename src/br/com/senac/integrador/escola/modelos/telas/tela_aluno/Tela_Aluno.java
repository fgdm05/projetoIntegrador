/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.integrador.escola.modelos.telas.tela_aluno;

import br.com.senac.integrador.escola.modelos.auxiliares.LoginSessionAlunos;
import br.com.senac.integrador.escola.modelos.auxiliares.Logout;
import br.com.senac.integrador.escola.modelos.auxiliares.MySQL_Connection;
import br.com.senac.integrador.escola.modelos.auxiliares.SQLManager;
import br.com.senac.integrador.escola.login.Main_Login;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Jonathan
 */
public class Tela_Aluno extends javax.swing.JFrame {
    
    /**
     * Creates new form Tela_Aluno
     */
    public Tela_Aluno() throws SQLException {
        initComponents();
        open_page(inicio);
        getTopBarData(LoginSessionAlunos.idPessoa, LoginSessionAlunos.idEstudante);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navbar = new javax.swing.JPanel();
        nav_desempenho = new javax.swing.JPanel();
        label_desempenho = new javax.swing.JLabel();
        nav_frequencia = new javax.swing.JPanel();
        label_frequencia = new javax.swing.JLabel();
        nav_perfil = new javax.swing.JPanel();
        label_perfil = new javax.swing.JLabel();
        nav_material = new javax.swing.JPanel();
        label_ocorrencias4 = new javax.swing.JLabel();
        nav_carteira = new javax.swing.JPanel();
        label_carteira = new javax.swing.JLabel();
        nav_inicio = new javax.swing.JPanel();
        label_perfil1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        renderer = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        topBar_perfil = new javax.swing.JLabel();
        topBar_nome = new javax.swing.JLabel();
        topBar_curso = new javax.swing.JLabel();
        topBar_turma = new javax.swing.JLabel();
        button_close = new javax.swing.JLabel();
        button_logout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        navbar.setBackground(new java.awt.Color(54, 164, 255));

        nav_desempenho.setBackground(new java.awt.Color(54, 164, 255));
        nav_desempenho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_desempenho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_desempenhoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav_desempenhoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav_desempenhoMouseExited(evt);
            }
        });

        label_desempenho.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_desempenho.setForeground(new java.awt.Color(255, 255, 255));
        label_desempenho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_desempenho.setText("Ver estudantes");

        javax.swing.GroupLayout nav_desempenhoLayout = new javax.swing.GroupLayout(nav_desempenho);
        nav_desempenho.setLayout(nav_desempenhoLayout);
        nav_desempenhoLayout.setHorizontalGroup(
            nav_desempenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nav_desempenhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_desempenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        nav_desempenhoLayout.setVerticalGroup(
            nav_desempenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_desempenhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_desempenho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nav_frequencia.setBackground(new java.awt.Color(54, 164, 255));
        nav_frequencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_frequencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_frequenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav_frequenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav_frequenciaMouseExited(evt);
            }
        });

        label_frequencia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_frequencia.setForeground(new java.awt.Color(255, 255, 255));
        label_frequencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_frequencia.setText("Ver professores");

        javax.swing.GroupLayout nav_frequenciaLayout = new javax.swing.GroupLayout(nav_frequencia);
        nav_frequencia.setLayout(nav_frequenciaLayout);
        nav_frequenciaLayout.setHorizontalGroup(
            nav_frequenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_frequenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_frequencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        nav_frequenciaLayout.setVerticalGroup(
            nav_frequenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_frequenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_frequencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nav_perfil.setBackground(new java.awt.Color(54, 164, 255));
        nav_perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_perfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav_perfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav_perfilMouseExited(evt);
            }
        });

        label_perfil.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_perfil.setForeground(new java.awt.Color(255, 255, 255));
        label_perfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_perfil.setText("Cadastrar estudante");

        javax.swing.GroupLayout nav_perfilLayout = new javax.swing.GroupLayout(nav_perfil);
        nav_perfil.setLayout(nav_perfilLayout);
        nav_perfilLayout.setHorizontalGroup(
            nav_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nav_perfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        nav_perfilLayout.setVerticalGroup(
            nav_perfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_perfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_perfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nav_material.setBackground(new java.awt.Color(54, 164, 255));
        nav_material.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_material.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_materialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav_materialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav_materialMouseExited(evt);
            }
        });

        label_ocorrencias4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_ocorrencias4.setForeground(new java.awt.Color(255, 255, 255));
        label_ocorrencias4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/senac/integrador/escola/modelos/telas/tela_aluno/images/icon_material.png"))); // NOI18N
        label_ocorrencias4.setText("Material");

        javax.swing.GroupLayout nav_materialLayout = new javax.swing.GroupLayout(nav_material);
        nav_material.setLayout(nav_materialLayout);
        nav_materialLayout.setHorizontalGroup(
            nav_materialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_materialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_ocorrencias4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        nav_materialLayout.setVerticalGroup(
            nav_materialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_materialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_ocorrencias4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nav_carteira.setBackground(new java.awt.Color(54, 164, 255));
        nav_carteira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_carteira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_carteiraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav_carteiraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav_carteiraMouseExited(evt);
            }
        });

        label_carteira.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_carteira.setForeground(new java.awt.Color(255, 255, 255));
        label_carteira.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_carteira.setText("Carteira professor");

        javax.swing.GroupLayout nav_carteiraLayout = new javax.swing.GroupLayout(nav_carteira);
        nav_carteira.setLayout(nav_carteiraLayout);
        nav_carteiraLayout.setHorizontalGroup(
            nav_carteiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nav_carteiraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_carteira, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        nav_carteiraLayout.setVerticalGroup(
            nav_carteiraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_carteiraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_carteira)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nav_inicio.setBackground(new java.awt.Color(54, 164, 255));
        nav_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nav_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_inicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nav_inicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nav_inicioMouseExited(evt);
            }
        });

        label_perfil1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        label_perfil1.setForeground(new java.awt.Color(255, 255, 255));
        label_perfil1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_perfil1.setText("Cadastrar login");

        javax.swing.GroupLayout nav_inicioLayout = new javax.swing.GroupLayout(nav_inicio);
        nav_inicio.setLayout(nav_inicioLayout);
        nav_inicioLayout.setHorizontalGroup(
            nav_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_perfil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        nav_inicioLayout.setVerticalGroup(
            nav_inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nav_inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_perfil1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/senac/integrador/escola/images/LogoPequeno.png"))); // NOI18N
        jLabel1.setText("Serasse");

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nav_frequencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_desempenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_material, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_carteira, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(nav_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nav_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nav_carteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nav_desempenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nav_frequencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(nav_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(navbar);
        navbar.setBounds(0, 0, 140, 650);

        javax.swing.GroupLayout rendererLayout = new javax.swing.GroupLayout(renderer);
        renderer.setLayout(rendererLayout);
        rendererLayout.setHorizontalGroup(
            rendererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        rendererLayout.setVerticalGroup(
            rendererLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(renderer);
        renderer.setBounds(140, 90, 590, 480);

        jPanel1.setBackground(new java.awt.Color(232, 180, 88));

        topBar_perfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topBar_perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/senac/integrador/escola/modelos/telas/tela_aluno/images/icon_person.png"))); // NOI18N
        topBar_perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topBar_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topBar_perfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topBar_perfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topBar_perfilMouseExited(evt);
            }
        });

        topBar_nome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        topBar_nome.setForeground(new java.awt.Color(255, 255, 255));
        topBar_nome.setText(" ");

        topBar_curso.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        topBar_curso.setForeground(new java.awt.Color(255, 255, 255));
        topBar_curso.setText(" ");

        topBar_turma.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        topBar_turma.setForeground(new java.awt.Color(255, 255, 255));
        topBar_turma.setText(" ");

        button_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/senac/integrador/escola/modelos/telas/tela_aluno/images/icon_close.png"))); // NOI18N
        button_close.setText("jLabel1");
        button_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_closeMouseClicked(evt);
            }
        });

        button_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/senac/integrador/escola/modelos/telas/tela_aluno/images/icon_logout.png"))); // NOI18N
        button_logout.setText("jLabel2");
        button_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topBar_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topBar_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topBar_curso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(topBar_turma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_close, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topBar_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(topBar_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topBar_curso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(topBar_turma))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(button_close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(140, 0, 590, 90);

        setSize(new java.awt.Dimension(728, 565));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getTopBarData(int idPessoa, int idEstudante) throws SQLException {        
        Connection myConn = (Connection) MySQL_Connection.createConnection();
        String mySqlQuery1 = ("SELECT nome from pessoa where idPessoa = " + idPessoa);
        String mySqlQuery2 = ("SELECT escolaridade from estudante where idEstudante = " + idEstudante);
        String mySqlQuery3 = ("SELECT idTurma from estudante where idEstudante = " + idEstudante);
        Statement statement_pes = myConn.createStatement();
        Statement statement_est = myConn.createStatement();
        Statement statement_tur = myConn.createStatement();
        
        ResultSet dados_pes = statement_pes.executeQuery(mySqlQuery1);    
        ResultSet dados_est = statement_est.executeQuery(mySqlQuery2);    
        ResultSet dados_tur = statement_tur.executeQuery(mySqlQuery3);    
        
        dados_pes.next();
        dados_est.next();
        dados_tur.next();
        
        topBar_nome.setText(dados_pes.getString("nome"));
        topBar_curso.setText(dados_est.getString("escolaridade"));
        topBar_turma.setText("Turma " + (dados_tur.getString("idTurma")));
    }
    
    public void setNavColor (JPanel p)
    {
        p.setBackground(new Color(232,180,88));
    }

    public void resetNavColor (JPanel p)
    {
        p.setBackground(new Color(54,164,255));
    }
    
    
    private void nav_desempenhoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_desempenhoMouseEntered
        setNavColor(nav_desempenho);
    }//GEN-LAST:event_nav_desempenhoMouseEntered

    private void nav_desempenhoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_desempenhoMouseExited
        resetNavColor(nav_desempenho);
    }//GEN-LAST:event_nav_desempenhoMouseExited

    
    private void nav_frequenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_frequenciaMouseEntered
        setNavColor(nav_frequencia);
    }//GEN-LAST:event_nav_frequenciaMouseEntered

    private void nav_frequenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_frequenciaMouseExited
        resetNavColor(nav_frequencia);
    }//GEN-LAST:event_nav_frequenciaMouseExited

    
    
    
    private void nav_perfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_perfilMouseEntered
        setNavColor(nav_perfil);
    }//GEN-LAST:event_nav_perfilMouseEntered

    private void nav_perfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_perfilMouseExited
        resetNavColor(nav_perfil);
    }//GEN-LAST:event_nav_perfilMouseExited

       
    private void button_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_closeMouseClicked
        int opt = JOptionPane.showConfirmDialog(rootPane, "Deseja sair do aplicativo?", "Sair", 0);
        if (opt == 0) 
        {
            System.exit(0);
        }
    }//GEN-LAST:event_button_closeMouseClicked

    page_perfil perfil = new page_perfil();
    page_inicio inicio = new page_inicio();
    page_turma turma = new page_turma();
    page_carteira carteira = new page_carteira();
    page_desempenho desempenho = new page_desempenho();
    page_frequencia frequencia = new page_frequencia();
    
    private void open_page(Component comp) {
        renderer.removeAll();
        renderer.add(comp).setVisible(true);
    }
        
    private void nav_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_perfilMouseClicked
        open_page(perfil);
        
    }//GEN-LAST:event_nav_perfilMouseClicked

    private void nav_desempenhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_desempenhoMouseClicked
        open_page(desempenho);
    }//GEN-LAST:event_nav_desempenhoMouseClicked

    private void nav_frequenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_frequenciaMouseClicked
        open_page(frequencia);
    }//GEN-LAST:event_nav_frequenciaMouseClicked

    private void nav_materialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_materialMouseClicked

    }//GEN-LAST:event_nav_materialMouseClicked

    private void nav_materialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_materialMouseEntered
        setNavColor(nav_material);
    }//GEN-LAST:event_nav_materialMouseEntered

    private void nav_materialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_materialMouseExited
        resetNavColor(nav_material);
    }//GEN-LAST:event_nav_materialMouseExited

    private void topBar_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBar_perfilMouseClicked
        open_page(perfil);
    }//GEN-LAST:event_topBar_perfilMouseClicked

    private void topBar_perfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBar_perfilMouseEntered
        topBar_perfil.setBorder(BorderFactory.createLineBorder(Color.white));
    }//GEN-LAST:event_topBar_perfilMouseEntered

    private void topBar_perfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBar_perfilMouseExited
        topBar_perfil.setBorder(null);
    }//GEN-LAST:event_topBar_perfilMouseExited

    private void nav_carteiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_carteiraMouseClicked
        open_page(carteira);
    }//GEN-LAST:event_nav_carteiraMouseClicked

    private void nav_carteiraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_carteiraMouseEntered
        setNavColor(nav_carteira);
    }//GEN-LAST:event_nav_carteiraMouseEntered

    private void nav_carteiraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_carteiraMouseExited
        resetNavColor(nav_carteira);
    }//GEN-LAST:event_nav_carteiraMouseExited

    private void button_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_logoutMouseClicked
        try {
            Main_Login telaLogin = new Main_Login();
            Logout.Logout(this, telaLogin);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_button_logoutMouseClicked

    private void nav_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_inicioMouseClicked
        open_page(inicio);
    }//GEN-LAST:event_nav_inicioMouseClicked

    private void nav_inicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_inicioMouseEntered
        setNavColor(nav_inicio);
    }//GEN-LAST:event_nav_inicioMouseEntered

    private void nav_inicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_inicioMouseExited
        resetNavColor(nav_inicio);
    }//GEN-LAST:event_nav_inicioMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Aluno().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Aluno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel button_close;
    private javax.swing.JLabel button_logout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_carteira;
    private javax.swing.JLabel label_desempenho;
    private javax.swing.JLabel label_frequencia;
    private javax.swing.JLabel label_ocorrencias4;
    private javax.swing.JLabel label_perfil;
    private javax.swing.JLabel label_perfil1;
    private javax.swing.JPanel nav_carteira;
    private javax.swing.JPanel nav_desempenho;
    private javax.swing.JPanel nav_frequencia;
    private javax.swing.JPanel nav_inicio;
    private javax.swing.JPanel nav_material;
    private javax.swing.JPanel nav_perfil;
    private javax.swing.JPanel navbar;
    private javax.swing.JDesktopPane renderer;
    private javax.swing.JLabel topBar_curso;
    private javax.swing.JLabel topBar_nome;
    private javax.swing.JLabel topBar_perfil;
    private javax.swing.JLabel topBar_turma;
    // End of variables declaration//GEN-END:variables
}
