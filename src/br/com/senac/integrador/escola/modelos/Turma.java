package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.Professor;
import br.com.senac.integrador.escola.modelos.enums.Periodo;
import java.util.ArrayList;

/**
 *
 * @author Felipe Godinho Dal Molin
 */
public class Turma {
    private int idTurma;
    private Periodo periodo;
    private ArrayList<Estudante> estudantes;
    private Professor professor;

    /**
     * 
     * @param estudantes
     * @param professor
     * @param periodo 
     */
    public Turma(ArrayList<Estudante> estudantes, Professor professor, Periodo periodo) {
        this.estudantes = estudantes;
        this.professor = professor;
        this.periodo = periodo;
    }
    /**
     * 
     * @param idTurma
     * @param estudantes
     * @param professor
     * @param periodo 
     */
    public Turma(int idTurma, ArrayList<Estudante> estudantes, Professor professor, Periodo periodo) {
        this(estudantes, professor, periodo);
        this.idTurma = idTurma;
    }

    public int getIdTurma() {
        return idTurma;
    }
    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }
    public Periodo getPeriodo() {
        return periodo;
    }
    public Professor getProfessor() {
        return professor;
    }
}