package br.com.senac.integrador.escola.modelos;

import javax.swing.JOptionPane;

/**
 * Definição da classe Endereco
 * @author Felipe Godinho Dal Molin
 */
public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String endereco;

    @Override
    public String toString() {
        String message = String.format("[%s, %s, %s, %d, %s]",
                estado, cidade, bairro, numero, endereco);
        return message;
    }
    
    
    
    /**
     * 
     * @param estado
     * @param cidade
     * @param bairro
     * @param numero
     * @param endereco 
     */
    public Endereco(String estado, String cidade, String bairro, int numero, String endereco) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.endereco = endereco;
        
        try{
            regexRules();
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String getEstado() {
        return estado;
    }
    public String getCidade() {
        return cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public int getNumero() {
        return numero;
    }
    public String getEndereco() {
        return endereco;
    }

    private void regexRules() {
        if(!(estado.length() == 2)) {
            throw new IllegalArgumentException("Estado formatado incorretamente.");
        }
    }
}