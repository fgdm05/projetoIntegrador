package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.Endereco;
import br.com.senac.integrador.escola.modelos.Login;
import br.com.senac.integrador.escola.modelos.Pessoa;
import br.com.senac.integrador.escola.modelos.Titular;
import br.com.senac.integrador.escola.modelos.Turma;
import br.com.senac.integrador.escola.modelos.enums.Escolaridade;
import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.EstadoCivil;
import br.com.senac.integrador.escola.modelos.enums.Genero;
import java.time.LocalDate;

/**
 * Definição da classe Estudante
 * @author Felipe Godinho Dal Molin
 */
public class Estudante extends Pessoa {
    
    private int idEstudante = -1;
    private int idLogin = -1;
    
    private LocalDate dataInscricao;
    private String nomeResponsavel;
    private boolean trabalha;
    private Turma turma;
    private Escolaridade escolaridade;
    private Periodo periodo;
    private Login login;
    private double frequencia = 0.0;

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public Estudante(Titular titular, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca, String nomeResponsavel, boolean trabalha, Escolaridade escolaridade) {
        super(titular, endereco, estadoCivil, genero, corRaca);
        
        this.dataInscricao = LocalDate.now();
        this.nomeResponsavel = nomeResponsavel;
        this.trabalha = trabalha;
        this.escolaridade = escolaridade;
    }
    
    public Estudante(
    int idPessoa, int idEstudante, Titular titular, Endereco endereco, EstadoCivil estadoCivil, Genero genero, CorRaca corRaca, String nomeResponsavel, boolean trabalha, Escolaridade escolaridade) {
        super(idPessoa, titular, endereco, estadoCivil, genero, corRaca);
        this.idEstudante = idEstudante;
        
        this.dataInscricao = LocalDate.now();
        this.nomeResponsavel = nomeResponsavel;
        this.trabalha = trabalha;
        this.escolaridade = escolaridade;
    }
    
    public Estudante(int idPessoa, int idEstudante, Pessoa pessoa, String nomeResponsavel, boolean trabalha, Escolaridade escolaridade) {
        this(idPessoa, idEstudante, pessoa.getTitular(), pessoa.getEndereco(), pessoa.getEstadoCivil(), pessoa.getGenero(), pessoa.getCorRaca(), nomeResponsavel, trabalha, escolaridade);
    }

    @Override
    public CorRaca getCorRaca() {
        return super.getCorRaca(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Endereco getEndereco() {
        return super.getEndereco(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstadoCivil getEstadoCivil() {
        return super.getEstadoCivil(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genero getGenero() {
        return super.getGenero(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdPessoa() {
        return super.getIdPessoa(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Titular getTitular() {
        return super.getTitular(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdLogin() {
        return idLogin;
    }
    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
        public int getIdEstudante() {
        return idEstudante;
    }
    public LocalDate getDataInscricao() {
        return dataInscricao;
    }
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }
    public boolean getTrabalha() {
        return trabalha;
    }
    public Turma getTurma() {
        return turma;
    }

    /**
     *
     * @return
     */
    public Escolaridade getEscolaridade() {
        return escolaridade;
    }
    public Login getLogin() {
        return login;
    }
    public double getFrequencia() {
        return frequencia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}