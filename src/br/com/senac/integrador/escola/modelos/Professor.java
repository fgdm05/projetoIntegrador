package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.EstadoCivil;
import br.com.senac.integrador.escola.modelos.enums.Genero;

/**
 * Definicação da classe Professor
 * @author Felipe Godinho Dal Molin
 */
public class Professor extends Pessoa {
    
    private int idProfessor = -1;
    private int idLogin = -1;
    protected String formacao;
    protected String historicoProfissional;

    /**
     * Construção de criação
     * @param titular
     * @param estadoCivil
     * @param endereco
     * @param genero
     * @param corRaca
     * @param formacao
     * @param historicoProfissional 
     */
    public Professor(Titular titular, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca, String formacao, String historicoProfissional) {
        super(titular, endereco, estadoCivil, genero, corRaca);
        this.formacao = formacao;
        this.historicoProfissional = historicoProfissional;
    }

    /**
     * Construtor de preenchimento
     * @param idPessoa
     * @param idProfessor
     * @param titular
     * @param estadoCivil
     * @param endereco
     * @param genero
     * @param corRaca
     * @param formacao
     * @param historicoProfissional 
     */
    public Professor(int idPessoa, int idProfessor, Titular titular, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca, String formacao, String historicoProfissional) {
        super(idPessoa, titular, endereco, estadoCivil, genero, corRaca);
        this.idProfessor = idProfessor;
        this.formacao = formacao;
        this.historicoProfissional = historicoProfissional;
    }
    public Professor(int idPessoa, int idProfessor, Pessoa pessoa, String formacao, String historicoProfissional){
        this(idPessoa, idProfessor, pessoa.getTitular(), pessoa.getEndereco(), pessoa.getEstadoCivil(), pessoa.getGenero(), pessoa.getCorRaca(), formacao, historicoProfissional);
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

    public int getIdLogin() {
        return idLogin;
    }
    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}