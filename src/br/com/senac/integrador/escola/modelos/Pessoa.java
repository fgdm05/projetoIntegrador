package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.auxiliares.SQLManager;
import br.com.senac.integrador.escola.modelos.enums.Genero;
import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.EstadoCivil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Definicação da classe Pessoa
 * @author Felipe Godinho Dal Molin
 */
public class Pessoa implements SQLInfo {
    
    protected Identificador identificador;
    
    protected String deficiencia;
    protected String nacionalidade;
    protected EstadoCivil estadoCivil;
    protected Endereco endereco;
    protected Genero genero;
    protected CorRaca corRaca;
    
    /**
     * 
     * @param identificador
     * @param deficiencia
     * @param nacionalidade
     * @param estadoCivil
     * @param endereco
     * @param genero
     * @param corRaca 
     */
    public Pessoa(Identificador identificador, String deficiencia, String nacionalidade, EstadoCivil estadoCivil, Endereco endereco, Genero genero, CorRaca corRaca) {
        this.identificador = identificador;
        this.deficiencia = deficiencia;
        this.nacionalidade = nacionalidade;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.genero = genero;
        this.corRaca = corRaca;
    }
        
    public String getNome() {
        return identificador.getNome();
    }
    public String getCPF() {
        return identificador.getCpf();
    }
    public String getRG() {
        return identificador.getRg();
    }
    public String getTelefone() {
        return identificador.getTelefone();
    }
    public String getEmail() {
        return identificador.getEmail();
    }
    
    public String getDeficiencia() {
        return deficiencia;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public Endereco getEndereco() {
        return endereco;
    }  
    public Genero getGenero() {
        return genero;
    }
    public CorRaca getCorRaca() {
        return corRaca;
    }
    public Identificador getIdentificador() {
        return identificador;
    }
    

    @Override
    public int getIDPessoa() {
        try {
            return SQLManager.getIDPessoa(this);
        } catch (SQLException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return -1;
        }
    }
}