package br.com.senac.integrador.escola.modelos.auxiliares;

/**
 * Definição do enum auxiliar Tags
 * @author Felipe Godinho Dal Molin
 */
public enum Tags {
    idPessoa, idProfessor, idEndereco, idLogin, 
    NOME, EMAIL, CPF, RG, TELEFONE, ID, Nome, Telefone, Email,
    URL, USERNAME, PASSWORD, DEFICIENCIA, NACIONALIDADE,
    
    ESTADO, CIDADE, BAIRRO, NUMERO, ENDERECO,
    ESTADOCIVIL, GENERO, COR,
    FORMACAO, HISTORICOPROFISSIONAL, DATANASCIMENTO, idEstudante, NOMERESPONSAVEL, trabalha, ESCOLARIDADE, USUARIO, SENHA, TIPOLOGIN;

    @Override
    public String toString() {
        return this.name();
    }
}