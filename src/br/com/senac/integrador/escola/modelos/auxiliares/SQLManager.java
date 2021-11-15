package br.com.senac.integrador.escola.modelos.auxiliares;

import br.com.senac.integrador.escola.modelos.Login;
import br.com.senac.integrador.escola.modelos.Aluno;
import br.com.senac.integrador.escola.modelos.Endereco;
import br.com.senac.integrador.escola.modelos.Pessoa;
import br.com.senac.integrador.escola.modelos.Professor;
import br.com.senac.integrador.escola.modelos.Identificador;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Definição da classe auxiliar abstrata SQLManager para manuseamentos no banco de dados.
 * @author Felipe Godinho Dal Molin
 */
public abstract class SQLManager {
    private static boolean isSQLSet = false;
    private static Connection connection;
    
    public static void cadastrarAluno(Aluno aluno) throws SQLException {
        connection = createConnection();
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
                "INSERT INTO alunos " +
                "(nome, cpf, periodo) VALUES " +
                "('%s', '%s', '%s')",
                aluno.getNome(), aluno.getCpf(), aluno.getPeriodo());
        
        statement.execute(sqlStatement);
    };
    public static void cadastrarEndereco(Endereco endereco) throws SQLException {
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
            "INSERT INTO endereco " + 
            "(endereco, estado, bairro, cidade, numero) VALUES" +
            "('%s','%s','%s','%s',%d)",
            endereco.getEndereco(), endereco.getEstado(), endereco.getBairro(),
            endereco.getCidade(), endereco.getNumero());
        
        statement.execute(sqlStatement);
    }
    public static void cadastrarPessoa(Pessoa p) throws SQLException {
        SQLManager.cadastrarEndereco(p.getEndereco());
        
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT idEndereco FROM endereco");
        
        int idEndereco = -1;
        
        while(result.next()) {
            idEndereco = result.getInt(Tags.idEndereco.name());
        }
        if(idEndereco == -1) {
            throw new RuntimeException("idEndereco = -1");
        }
        
        String sqlstate = String.format(
                "INSERT INTO pessoa " +
                "(idEndereco, nome, cpf, rg, telefone, email, deficiencia, nacionalidade, genero, estadoCivil, cor) VALUES " +
                "(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                idEndereco, p.getNome(), p.getCpf(), p.getRg(), p.getTelefone(), p.getEmail(), p.getDeficiencia(),
                p.getNacionalidade(),
                p.getGenero().name(), p.getEstadoCivil().name(), p.getCorRaca().name()
        );
        statement.execute(sqlstate);
        System.out.println("Pessoa cadastrada.");
    }
    public static void cadastrarLogin(Login login) throws SQLException {
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        
        String sqlState = String.format(
                "INSERT INTO login " +
                "(tipoLogin, usuario, senha) VALUES " +
                "('%s', '%s', '%s')",
                login.getTipo(), login.getUsuario(), login.getSenha()
        );
        statement.execute(sqlState);
    }
    public static void cadastrarProfessor(Professor professor) throws SQLException {
        SQLManager.cadastrarPessoa(professor);
        connection = SQLManager.createConnection();
        Statement statement = connection.createStatement();
        
        int idPessoa = -1, idLogin = 999;
        
        ResultSet resultPessoa = statement.executeQuery("SELECT idPessoa FROM pessoa");
        while(resultPessoa.next()){
            idPessoa = resultPessoa.getInt(Tags.idPessoa.name());
        }
        ResultSet resultLogin = statement.executeQuery("SELECT idLogin FROM login WHERE tipoLogin='PROFESSOR'");
        while(resultLogin.next()) {
            idLogin = resultLogin.getInt(Tags.idLogin.name());
        }
        
        try {
            if(idPessoa == -1) {
                throw new RuntimeException("Nenhuma pessoa cadastrada.");
            }
        } catch(RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        String sqlState = String.format(
                "INSERT INTO professor " +
                "(idPessoa, formacao, historicoProfissional) VALUES " +
                "(%d, '%s', '%s')",
                idPessoa, professor.getFormacao(), professor.getHistoricoProfissional());
        statement.execute(sqlState);
    }
    private static Connection createConnection() throws SQLException {
        if(isSQLSet) {
            return connection;
        }
        String username = JOptionPane.showInputDialog("Insira o usuário do banco de dados.");
        String password = JOptionPane.showInputDialog("Insira a senha do banco de dados.");
        
        String url = "jdbc:mysql://localhost/appescola";
        isSQLSet = true;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static Professor buscarProfessor(String fator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int getIDPessoa(Pessoa p) throws SQLException {
        connection = createConnection();
        Statement statement = connection.createStatement();
        
        String sqlState = String.format(
                "SELECT idPessoa FROM pessoa WHERE " +
                "nome='%s' AND cpf='%s' AND email='%s' AND rg='%s' AND telefone='%s'",
                p.getNome(), p.getCpf(), p.getEmail(), p.getRg(), p.getTelefone());
        ResultSet result = statement.executeQuery(sqlState);
        int id = -1;
        while(result.next()) {
            id = result.getInt(Tags.idPessoa.name());
        }
        return id;
    }

    public static int getIDProfessor(Professor p) throws SQLException {
        connection = createConnection();
        Statement statement = connection.createStatement();
        
        int idPessoa = getIDPessoa(p);
        String sqlState = String.format(
                "SELECT idProfessor FROM professor WHERE idPessoa=%d",
                idPessoa
        );
        ResultSet result = statement.executeQuery(sqlState);
        int idProfessor = -1;
        while(result.next()) {
            idProfessor = result.getInt(Tags.idProfessor.name());
        }
        return idProfessor;
    }

    public static void initTable(JTable tabelaGeral) throws SQLException {
        connection = createConnection();
        Statement statement = connection.createStatement();
        
        ResultSet resultIdPessoa = statement.executeQuery("SELECT idPessoa FROM pessoa");
        ArrayList<Integer> listIdPessoa = new ArrayList<>();
        while(resultIdPessoa.next()) {
            listIdPessoa.add(resultIdPessoa.getInt(Tags.idPessoa.name()));
        }
        // converter idPessoa -> Pessoa
        // pegar informações da Pessoa
        
        ResultSet informacoesPessoa = statement.executeQuery(
                "SELECT nome, email, cpf, rg, telefone FROM pessoa, professor WHERE pessoa.idPessoa=professor.idPessoa");

        var identificadores = new ArrayList<Identificador>();
        while(informacoesPessoa.next()) {
            String nome = informacoesPessoa.getString(Tags.Nome.name());
            String email = informacoesPessoa.getString(Tags.Email.name());
            String cpf = informacoesPessoa.getString(Tags.CPF.name());
            String rg = informacoesPessoa.getString(Tags.RG.name());
            String telefone = informacoesPessoa.getString(Tags.Telefone.name());
            identificadores.add(new Identificador(nome, email, cpf, rg, telefone));
        }
        
        DefaultTableModel model = (DefaultTableModel) tabelaGeral.getModel();
        model.setNumRows(0);
        
        identificadores.forEach((identificador) -> {
            model.addRow(new Object[] {
                identificador.getNome(),
                identificador.getEmail(),
                identificador.getCpf(),
                identificador.getRg(),
                identificador.getTelefone()
            });
        });
    }
}