package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.auxiliares.SQLManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Definicação da classe Professor
 * @author Felipe Godinho Dal Molin
 */
public class Professor extends Pessoa {
    
    private String formacao;
    private String historicoProfissional;
    
    /**
     * Definição do construtor da classe Professor
     * @param pessoa
     * @param formacao
     * @param historicoProfissional 
     */
    public Professor(Pessoa pessoa, String formacao, String historicoProfissional) {
        super(
            pessoa.getNome(),pessoa.getCpf(), 
            pessoa.getRg(), pessoa.getTelefone(), 
            pessoa.getEmail(), pessoa.getDeficiencia(),
            pessoa.getNacionalidade(),
            pessoa.getEstadoCivil(), pessoa.getEndereco(), 
            pessoa.getGenero(), pessoa.getCorRaca());
        this.formacao = formacao;
        this.historicoProfissional = historicoProfissional;
    }

    public String getFormacao() {
        return formacao;
    }
    public String getHistoricoProfissional() {
        return historicoProfissional;
    }

    @Override
    public int getIDPessoa() {
        return super.getIDPessoa();
    }
    public int getIDProfessor() {
        try {
            return SQLManager.getIDProfessor(this);
        } catch (SQLException ex) {
            Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return -1;
        }
    }
}