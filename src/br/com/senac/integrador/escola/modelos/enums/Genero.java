package br.com.senac.integrador.escola.modelos.enums;

/**
 * Definição do enum Genero
 * Valores Possíveis: MASCULINO, FEMININO, OUTRO.
 * @author Felipe Godinho Dal Molin
 */
public enum Genero {
    MASCULINO, FEMININO, OUTRO;


    public static Genero getByName(String nome) {
        if(MASCULINO.nomeEquals(nome)) {
            return MASCULINO;
        } else if(FEMININO.nomeEquals(nome)) {
            return FEMININO;
        } else if (OUTRO.nomeEquals(nome)) {
            return OUTRO;
        } else {
            throw new IllegalArgumentException("Valor não registrado.");
        }
    }
    private boolean nomeEquals(String nome) {
        return this.name().equals(nome);
    }
}