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

    @Override
    public String toString() {
        return String.format("[Usuario: %s, Senha: %s]", usuario, senha); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        Login outro = (Login) obj;
        
        boolean usuarioIgual = outro.usuario.equals(this.usuario) ;
        boolean senhaIgual = outro.senha.equals(this.senha);
        
        System.out.println(usuarioIgual);
        System.out.println(senhaIgual);
        return usuarioIgual && senhaIgual;
    }
    
    
    
    public Login(String usuario, String senha) {
        this.usuario=usuario;
        this.senha=senha;
    }
    
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
    public void setTipo(TipoLogin tipo) {
        this.tipo = tipo;
    }
    
}