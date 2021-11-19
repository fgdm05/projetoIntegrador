package br.com.senac.integrador.escola.modelos;

/**
 *
 * @author Felipe Godinho Dal Molin
 */
public class Identificador {
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;

    /**
     * 
     * @param nome
     * @param cpf
     * @param rg
     * @param telefone
     * @param email 
     */
    public Identificador(String nome, String cpf, String rg, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
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
    
}