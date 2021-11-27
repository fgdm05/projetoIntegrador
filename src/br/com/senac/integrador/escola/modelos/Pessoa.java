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
    
    protected int idPessoa = -1;
    protected Titular titular;
    protected Endereco endereco;
    
    protected EstadoCivil estadoCivil;
    protected Genero genero;
    protected CorRaca corRaca;

    @Override
    public String toString() {
        String retorno = String.format(
                "[%s, %s, %s, %s, %s]",
                titular.getNome(), titular.getCPF(), titular.getRG(), titular.getTelefone(), titular.getEmail());
        return retorno;
    }
    
    
    
    
    private void regexRules(){
        if(!titular.getCPF().matches(Regex.CPF)) {
            throw new IllegalArgumentException("CPF formatado incorretamente.");
        } else if(!titular.getTelefone().matches(Regex.TELEFONE)) {
            throw new IllegalArgumentException("Telefone formatado incorretamente.");
        } else if(!titular.getRG().matches(Regex.RG)) {
            throw new IllegalArgumentException("RG formatado incorretamente.");
        } else if(!(titular.getEmail().contains("@"))) {
            System.out.println(titular.getEmail());
            throw new IllegalArgumentException("Email formatado incorretamente.");
        }
    }
    
    /**
     * 
     * @param titular
     * @param estadoCivil
     * @param endereco
     * @param genero
     * @param corRaca 
     */
    public Pessoa(Titular titular, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca) {
        this.titular = titular;
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
     * @param titular
     * @param estadoCivil
     * @param endereco
     * @param genero
     * @param corRaca 
     */
    public Pessoa(int idPessoa, Titular titular, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca) {
        this(titular, endereco, estadoCivil, genero, corRaca);
        this.idPessoa = idPessoa;
    }

    public Titular getTitular() {
        return titular;
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
    public int getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
}