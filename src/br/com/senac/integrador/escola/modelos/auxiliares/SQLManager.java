package br.com.senac.integrador.escola.modelos.auxiliares;

import br.com.senac.integrador.escola.modelos.Login;
import br.com.senac.integrador.escola.modelos.Aluno;
import br.com.senac.integrador.escola.modelos.Endereco;
import br.com.senac.integrador.escola.modelos.Pessoa;
import br.com.senac.integrador.escola.modelos.Professor;
import br.com.senac.integrador.escola.modelos.Identificador;
import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.Fator;
import br.com.senac.integrador.escola.modelos.enums.Genero;
import br.com.senac.integrador.escola.modelos.enums.EstadoCivil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static void cadastrar(Aluno aluno) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
                "INSERT INTO alunos " +
                "(nome, cpf, periodo) VALUES " +
                "('%s', '%s', '%s')",
                aluno.getNome(), aluno.getCpf(), aluno.getPeriodo());
        
        statement.execute(sqlStatement);
    };
    public static void cadastrar(Endereco endereco) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
            "INSERT INTO endereco " + 
            "(endereco, estado, bairro, cidade, numero) VALUES" +
            "('%s','%s','%s','%s',%d)",
            endereco.getEndereco(), endereco.getEstado(), endereco.getBairro(),
            endereco.getCidade(), endereco.getNumero());
        
        statement.execute(sqlStatement);
    }
    public static void cadastrar(Pessoa pessoa) throws SQLException {
        SQLManager.cadastrar(pessoa.getEndereco());
        
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
                idEndereco, pessoa.getNome(), pessoa.getCpf(), pessoa.getRg(), pessoa.getTelefone(), pessoa.getEmail(), pessoa.getDeficiencia(),
                pessoa.getNacionalidade(),
                pessoa.getGenero().name(), pessoa.getEstadoCivil().name(), pessoa.getCorRaca().name()
        );
        statement.execute(sqlstate);
        System.out.println("Pessoa cadastrada.");
    }
    public static void cadastrar(Login login) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sqlState = String.format(
                "INSERT INTO login " +
                "(tipoLogin, usuario, senha) VALUES " +
                "('%s', '%s', '%s')",
                login.getTipo(), login.getUsuario(), login.getSenha()
        );
        statement.execute(sqlState);
    }
    public static void cadastrar(Professor professor) throws SQLException {
        SQLManager.cadastrar(professor);
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

    public static int getIDPessoa(Pessoa p) throws SQLException {
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
        Statement statement = connection.createStatement();
        
        ResultSet resultIdPessoa = statement.executeQuery("SELECT idPessoa FROM pessoa");
        ArrayList<Integer> listIdPessoa = new ArrayList<>();
        while(resultIdPessoa.next()) {
            listIdPessoa.add(resultIdPessoa.getInt(Tags.idPessoa.name()));
        }
        // converter idPessoa -> Pessoa
        // pegar informações da Pessoa
        
        ResultSet informacoesPessoa = statement.executeQuery(
                "SELECT nome, email, cpf, rg, telefone " +
                "FROM pessoa, professor " +
                "WHERE pessoa.idPessoa=professor.idPessoa");

        var identificadores = new ArrayList<Identificador>();
        while(informacoesPessoa.next()) {
            String nome = informacoesPessoa.getString(Tags.Nome.name());
            String email = informacoesPessoa.getString(Tags.Email.name());
            String cpf = informacoesPessoa.getString(Tags.CPF.name());
            String rg = informacoesPessoa.getString(Tags.RG.name());
            String telefone = informacoesPessoa.getString(Tags.Telefone.name());
            identificadores.add(new Identificador(nome, cpf, rg, telefone, email));
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
    
    public static void initConnection() {
        File file = new File("databaseConfig.csv");
        FileReader fr;
        BufferedReader br;
        Properties properties;
        String url = null, username = null, password = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            url = br.readLine().substring(5);
            username = br.readLine().substring(10);
            password = br.readLine().substring(10);
        } catch (IOException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
            
        properties = new Properties();
        properties.setProperty(Tags.URL.name(), url);
        properties.setProperty(Tags.USERNAME.name(), username);
        properties.setProperty(Tags.PASSWORD.name(), password);
        try {
            connection = DriverManager.getConnection(
                    properties.getProperty(Tags.URL.name()),
                    properties.getProperty(Tags.USERNAME.name()),
                    properties.getProperty(Tags.PASSWORD.name()));
        } catch (SQLException ex) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private static void writeFileProperties(Properties properties, File file) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            bw.write("URL: " + properties.getProperty("URL"));
            bw.newLine();
            bw.write("USERNAME: " + properties.getProperty("USERNAME"));
            bw.newLine();
            bw.write("PASSWORD: " + properties.getProperty("PASSWORD"));
            bw.close();
            fw.close();
        } catch(IOException e) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private static Properties createPropertiesInterface() {
        Properties properties = new Properties();
        properties.setProperty(Tags.URL.name(), "jdbc:mysql://localhost/appescola");
        properties.setProperty(Tags.USERNAME.name(), JOptionPane.showInputDialog("Insira o usuário do banco de dados."));
        properties.setProperty(Tags.PASSWORD.name(), JOptionPane.showInputDialog("Insira a senha do banco de dados."));
        return properties;
    }
    
    public static Pessoa buscarPessoa(Fator fator, String valor) throws SQLException {
        Identificador identificador = buscarIdentificador(fator, valor);
        Endereco endereco = buscarEndereco(fator, valor);
        
        String sql = String.format(
            "SELECT * FROM pessoa WHERE %s='%s'", fator.name(), valor);
        
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        Pessoa pessoa = null;
        EstadoCivil estado; Genero genero; CorRaca corRaca;
        while(r.next()) {
            String nomeEstadoCivil = r.getString(Tags.ESTADOCIVIL.name());
            String nomeGenero = r.getString(Tags.GENERO.name());
            String nomeCorRaca = r.getString(Tags.COR.name());
            
            estado = EstadoCivil.getByName(nomeEstadoCivil);
            genero = Genero.getByName(nomeGenero);
            corRaca = CorRaca.getByName(nomeCorRaca);
            
            String deficiencia = r.getString(Tags.DEFICIENCIA.name());
            String nacionalidade = r.getString(Tags.NACIONALIDADE.name());
            
            pessoa = new Pessoa(identificador, deficiencia, nacionalidade, estado, endereco, genero, corRaca);
        }
        return pessoa;
    }
    public static Identificador buscarIdentificador(Fator fator, String valor) throws SQLException {
        String sql = String.format(
                "SELECT nome, cpf, rg, telefone, email FROM pessoa " +
                "WHERE %s='%s'", fator.name(), valor);
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        Identificador identificador = null;
        while(r.next()) {
            identificador = new Identificador(
                    r.getString(Tags.NOME.name()), 
                    r.getString(Tags.CPF.name()), 
                    r.getString(Tags.RG.name()), 
                    r.getString(Tags.TELEFONE.name()), 
                    r.getString(Tags.EMAIL.name()));
        }
        return identificador;
    }
    public static Endereco buscarEndereco(Fator fator, String valor) throws SQLException {
        String sql = String.format(
            "SELECT "+
            "e.estado, e.cidade, e.bairro, e.numero, e.endereco "+
            "FROM endereco e, pessoa p " +
            "WHERE e.idEndereco=p.idEndereco AND " +
            "%s='%s'", fator.name(), valor);

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        Endereco endereco = null;
        while(result.next()) {
            endereco = new Endereco(
                    result.getString(Tags.ESTADO.name()), 
                    result.getString(Tags.CIDADE.name()), 
                    result.getString(Tags.BAIRRO.name()), 
                    result.getInt(Tags.NUMERO.name()), 
                    result.getString(Tags.ENDERECO.name()));
        }
        return endereco;
    }
    public static Professor buscarProfessor(Fator fator, String valor) throws SQLException {
        Pessoa pessoa = buscarPessoa(fator, valor);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}