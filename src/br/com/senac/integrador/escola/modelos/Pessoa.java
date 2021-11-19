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
    
    private Identificador identificador;
    
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    
    private String deficiencia;
    private String nacionalidade;
    private EstadoCivil estadoCivil;
    private Endereco endereco;
    private Genero genero;
    private CorRaca cor;
    
    public Pessoa
        (String nome, String cpf, String rg, String telefone, String email, String deficiencia, String nacionalidade, EstadoCivil estadoCivil, Endereco endereco, Genero genero, CorRaca cor) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.deficiencia = deficiencia;
        this.nacionalidade = nacionalidade;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.genero = genero;
        this.cor = cor;
    }
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
        this.cor = corRaca;
    }
        
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getRg() {
        return rg;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
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
        return cor;
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