package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.enums.TipoLogin;

/**
 * Definição da classe Login
 * @author Felipe Godinho Dal Molin
 */
public class Login {
    
    private int idLogin = -1;
    private String usuario;
    private String senha;
    private TipoLogin tipo;

    public Login(String usuario, String senha, TipoLogin tipo) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    public Login(int idLogin, String usuario, String senha, TipoLogin tipo) {
        this(usuario, senha, tipo);
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }
    public String getSenha() {
        return senha;
    }
    public TipoLogin getTipo() {
        return tipo;
    }
    public int getIdLogin() {
        return idLogin;
    }
    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}