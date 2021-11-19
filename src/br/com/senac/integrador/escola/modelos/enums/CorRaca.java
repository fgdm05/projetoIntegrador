package br.com.senac.integrador.escola.modelos.enums;

/**
 * Definição do enum CorRaca
 * Valores possíveis: BRANCO, PARDO, NEGRO, AMARELO e INDIGENA.
 * @author Felipe Godinho Dal Molin
 */
public enum CorRaca {
    BRANCO, PARDO, NEGRO, AMARELO, INDIGENA;

    public static CorRaca getByName(String nome) {
        if(BRANCO.nomeEquals(nome)) {
            return BRANCO;
        } else if(PARDO.nomeEquals(nome)) {
            return PARDO;
        } else if (NEGRO.nomeEquals(nome)) {
            return NEGRO;
        } else if (AMARELO.nomeEquals(nome)) {
            return AMARELO;
        } else if (INDIGENA.nomeEquals(nome)) {
            return INDIGENA;
        } else {
            throw new IllegalArgumentException("Valor não registrado.");
        }
    }
    private boolean nomeEquals(String nome) {
        return this.name().equals(nome);
    }
}