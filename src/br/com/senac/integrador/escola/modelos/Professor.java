package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.EstadoCivil;
import br.com.senac.integrador.escola.modelos.enums.Genero;

/**
 * Definicação da classe Professor
 * @author Felipe Godinho Dal Molin
 */
public class Professor extends Pessoa {
    
    private int idProfessor;
    protected String formacao;
    protected String historicoProfissional;

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
     * @param formacao
     * @param historicoProfissional 
     */
    public Professor(String nome, String cpf, String rg, String telefone, String email, String deficiencia, String nacionalidade, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca, String formacao, String historicoProfissional) {
        super(nome, cpf, rg, telefone, email, deficiencia, nacionalidade, endereco, estadoCivil, genero, corRaca);
        this.formacao = formacao;
        this.historicoProfissional = historicoProfissional;
    }

    public Professor(int idPessoa, int idProfessor, String nome, String cpf, String rg, String telefone, String email, String deficiencia, String nacionalidade, EstadoCivil estadoCivil, Endereco endereco, Genero genero, CorRaca corRaca, String formacao, String historicoProfissional) {
        super(idPessoa, nome, cpf, rg, telefone, email, deficiencia, nacionalidade, estadoCivil, endereco, genero, corRaca);
        this.idProfessor = idProfessor;
        this.formacao = formacao;
        this.historicoProfissional = historicoProfissional;
    }
    
    
    
    
    public String getFormacao() {
        return formacao;
    }
    public String getHistoricoProfissional() {
        return historicoProfissional;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public int getIdPessoa() {
        return idPessoa;
    }
    
}