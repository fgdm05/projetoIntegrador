package br.com.senac.integrador.escola.modelos;

import java.time.LocalDate;

/**
 *
 * @author Felipe Godinho Dal Molin
 */
public class Titular {
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String nacionalidade;
    private String deficiencia;
    private LocalDate dataNascimento;

    public Titular(String nome, String cpf, String rg, String telefone, String email, String nacionalidade, String deficiencia, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.nacionalidade = nacionalidade;
        this.deficiencia = deficiencia;
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public String getNome() {
        return nome;
    }
    public String getRG() {
        return rg;
    }
    public String getTelefone() {
        return telefone;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public String getDeficiencia() {
        return deficiencia;
    }
    
}
