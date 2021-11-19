package br.com.senac.integrador.escola.modelos.enums;

/**
 * Definição do enum EstadoCivil
 * Valores possíveis: SOLTEIRO, CASADO, DIVORCIADO, VIUVO
 * @author Felipe Godinho Dal Molin
 */
public enum EstadoCivil {
    SOLTEIRO, CASADO, DIVORCIADO, VIUVO;

    public static EstadoCivil getByName(String nome) {
        if(SOLTEIRO.nomeEquals(nome)) {
            return SOLTEIRO;
        } else if(CASADO.nomeEquals(nome)) {
            return CASADO;
        } else if (DIVORCIADO.nomeEquals(nome)) {
            return DIVORCIADO;
        } else if (VIUVO.nomeEquals(nome)) {
            return VIUVO;
        } else {
            throw new IllegalArgumentException("Valor não registrado.");
        }
    }
    private boolean nomeEquals(String nome) {
        return this.name().equals(nome);
    }
}