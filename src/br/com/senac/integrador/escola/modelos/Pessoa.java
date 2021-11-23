package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.auxiliares.Regex;
import br.com.senac.integrador.escola.modelos.enums.Genero;
import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.EstadoCivil;
import javax.swing.JOptionPane;

/**
 * Definicação da classe Pessoa
 * @author Felipe Godinho Dal Molin
 */
public class Pessoa {
    
    protected int idPessoa;
    protected String nome;
    protected String cpf;
    protected String rg;
    protected String telefone;
    protected String email;
    
    protected String deficiencia;
    protected String nacionalidade;
    protected EstadoCivil estadoCivil;
    protected Endereco endereco;
    protected Genero genero;
    protected CorRaca corRaca;
    
    private void regexRules(){
        if(!cpf.matches(Regex.CPF)) {
            throw new IllegalArgumentException("CPF formatado incorretamente.");
        } else if(!telefone.matches(Regex.TELEFONE)) {
            throw new IllegalArgumentException("Telefone formatado incorretamente.");
        } else if(!rg.matches(Regex.RG)) {
            throw new IllegalArgumentException("RG formatado incorretamente.");
        } else if(!(email.contains("@"))) {
            throw new IllegalArgumentException("Email formatado incorretamente.");
        }
    }
    
    /**
     * 
     * @param nome
     * @param cpf
     * @param rg
     * @param telefone
     * @param email
     * @param deficiencia
     * @param nacionalidade
     * @param estadoCivil
     * @param endereco
     * @param genero
     * @param corRaca 
     */
    public Pessoa(String nome, String cpf, String rg, String telefone, String email, String deficiencia, String nacionalidade, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca) {
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
        this.corRaca = corRaca;
        
        try{
            regexRules();
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * 
     * @param idPessoa
     * @param nome
     * @param cpf
     * @param rg
     * @param telefone
     * @param email
     * @param deficiencia
     * @param nacionalidade
     * @param estadoCivil
     * @param endereco
     * @param genero
     * @param corRaca 
     */
    public Pessoa(int idPessoa, String nome, String cpf, String rg, String telefone, String email, String deficiencia, String nacionalidade, EstadoCivil estadoCivil, Endereco endereco, Genero genero, CorRaca corRaca) {
        
        this.idPessoa = idPessoa;
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
        this.corRaca = corRaca;
        
        try{
            regexRules();
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
        
    public String getNome() {
        return nome;
    }
    public String getCPF() {
        return cpf;
    }
    public String getRG() {
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
        return corRaca;
    }
}