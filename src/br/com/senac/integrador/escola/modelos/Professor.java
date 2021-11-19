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
    
    protected String formacao;
    protected String historicoProfissional;
    
    
    public Professor(Pessoa pessoa, String formacao, String historicoProfissional) {
        super(pessoa.getIdentificador(), pessoa.getDeficiencia(), pessoa.getNacionalidade(), pessoa.getEstadoCivil(), pessoa.getEndereco(), pessoa.getGenero(), pessoa.getCorRaca());
        
        this.identificador = pessoa.getIdentificador();
        
        deficiencia = pessoa.getDeficiencia();
        nacionalidade = pessoa.getNacionalidade();
        estadoCivil = pessoa.getEstadoCivil();
        
        this.endereco = pessoa.getEndereco();
        genero = pessoa.getGenero();
        this.corRaca = pessoa.getCorRaca();
        this.deficiencia = pessoa.getDeficiencia();
        
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