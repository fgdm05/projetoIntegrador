package br.com.senac.integrador.escola.modelos.auxiliares;

import br.com.senac.integrador.escola.modelos.Login;
import br.com.senac.integrador.escola.modelos.Endereco;
import br.com.senac.integrador.escola.modelos.Estudante;
import br.com.senac.integrador.escola.modelos.Pessoa;
import br.com.senac.integrador.escola.modelos.Professor;
import br.com.senac.integrador.escola.modelos.Titular;
import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.Escolaridade;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Definição da classe auxiliar abstrata SQLManager para manuseamentos no banco de dados.
 * @author Felipe Godinho Dal Molin
 */
public abstract class SQLManager {
    private static Connection connection;
    private static final File FILE = new File("databaseConfig.csv");
    
    public static void cadastrar(Endereco endereco) throws SQLException {
        Statement statement = connection.createStatement();
        
        String sqlStatement = String.format(
            "INSERT INTO endereco " + 
            "(endereco, estado, bairro, cidade, numero) VALUES " +
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
        
        Titular titular = pessoa.getTitular();
        
        String sqlstate = String.format(
                "INSERT INTO pessoa " +
                "(idEndereco, nome, cpf, rg, telefone, email, deficiencia, nacionalidade, genero, estadoCivil, cor, dataNascimento) VALUES " +
                "(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                idEndereco, titular.getNome(), titular.getCPF(), titular.getRG(), titular.getTelefone(), titular.getEmail(), titular.getDeficiencia(),
                titular.getNacionalidade(),
                pessoa.getGenero().name(), pessoa.getEstadoCivil().name(), pessoa.getCorRaca().name(), titular.getDataNascimento()
        );
        statement.execute(sqlstate);
        
        String sql = "SELECT idPessoa FROM pessoa";
        ResultSet resultId = statement.executeQuery(sql);
        int idPessoa = -1;
        while(resultId.next()) {
            idPessoa = resultId.getInt(Tags.idPessoa.name());
        }
        pessoa.setIdPessoa(idPessoa);
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
        
        ResultSet result = statement.executeQuery("SELECT idLogin FROM login");
        int idLogin = -1;
        while(result.next()) {
            idLogin = result.getInt(Tags.idLogin.name());
        }
        login.setIdLogin(idLogin);
        
        JOptionPane.showMessageDialog(null, "O código do login é: " + idLogin);
    }
    public static void cadastrar(Professor professor) throws SQLException {
        SQLManager.cadastrar((Pessoa) professor);
        Statement statement = connection.createStatement();
        
        int idPessoa = -1;
        
        ResultSet resultPessoa = statement.executeQuery("SELECT idPessoa FROM pessoa");
        while(resultPessoa.next()){
            idPessoa = resultPessoa.getInt(Tags.idPessoa.name());
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
                "(idLogin, idPessoa, formacao, historicoProfissional) VALUES " +
                "(%d, %d, '%s', '%s')",
                professor.getIdLogin(), idPessoa, professor.getFormacao(), professor.getHistoricoProfissional());
        statement.execute(sqlState);
    }
    public static void cadastrar(Estudante estudante) throws SQLException {
        SQLManager.cadastrar((Pessoa) estudante);
        Statement statement = connection.createStatement();
        
        int trabalha = 0;
        if(estudante.getTrabalha()) {
            trabalha = 1;
        }
        
        String sqlState = String.format("INSERT INTO estudante " +
                "(idPessoa, dataInscricao, nomeResponsavel, trabalha, idLogin) VALUES " +
                "(%d, '%s', '%s', '%s', %d)", 
                estudante.getIdPessoa(), estudante.getDataInscricao(), estudante.getNomeResponsavel(), trabalha, estudante.getIdLogin());
        statement.execute(sqlState);
        
    }
    
    /**
     * Inicialização da tabela de professores
     * @param tabelaGeral
     * @throws SQLException 
     */
    public static void initTableProfessoresCadastrados(JTable tabelaGeral) throws SQLException {
        Statement statement = connection.createStatement();
        
        ResultSet result = statement.executeQuery(
                "SELECT DISTINCT pr.idPessoa, pr.idProfessor, pe.nome, pe.cpf, pe.rg, pe.telefone, pe.email, e.estado " +
                "FROM pessoa pe, professor pr, endereco e " +
                "WHERE pe.idPessoa=pr.idPessoa");
        
        var professores = new ArrayList<Professor>();
        
        while(result.next()) {
            int idPessoa = result.getInt(Tags.idPessoa.name());
            int idProfessor = result.getInt(Tags.idProfessor.name());
            String nome = result.getString(Tags.NOME.name());
            String cpf = result.getString(Tags.CPF.name());
            String rg = result.getString(Tags.RG.name());
            String telefone = result.getString(Tags.TELEFONE.name());
            String email = result.getString(Tags.EMAIL.name());
            
            String estado = result.getString(Tags.ESTADO.name());
            
            Endereco endereco = new Endereco(estado, null, null, -1, null);
            Titular titular = new Titular(nome, cpf, rg, telefone, email, nome, email, null);
            Professor p = new Professor(idPessoa, idProfessor, titular, endereco, null, null, null, null, null);
            
            professores.add(p);
        }
        
        DefaultTableModel model = (DefaultTableModel) tabelaGeral.getModel();
        model.setNumRows(0);
             
        professores.forEach(professor -> {
            Titular titular = professor.getTitular();
            model.addRow(new Object[] {
                professor.getIdPessoa(),
                titular.getNome(),
                titular.getEmail(),
                titular.getCPF(),
                titular.getRG(),
                titular.getTelefone()
            });
        });
    }
    /**
     * Inicialização da tabela dos estudantes
     * @param tabelaGeral
     * @throws SQLException 
     */
    public static void initTableEstudantes(JTable tabelaGeral) throws SQLException {
        Statement statement = connection.createStatement();
        
        ResultSet result = statement.executeQuery(
                "SELECT DISTINCT pe.idPessoa, pe.nome, pe.cpf, pe.rg, pe.telefone, pe.email " +
                "FROM pessoa pe, estudante est, endereco e " +
                "WHERE pe.idPessoa=est.idPessoa");
        
        DefaultTableModel model = (DefaultTableModel) tabelaGeral.getModel();
        model.setNumRows(0);
        
        
        while(result.next()) {
            int idPessoa = result.getInt(Tags.idPessoa.name());
            String nome = result.getString(Tags.NOME.name());
            String cpf = result.getString(Tags.CPF.name());
            String rg = result.getString(Tags.RG.name());
            String telefone = result.getString(Tags.TELEFONE.name());
            String email = result.getString(Tags.EMAIL.name());
            Object[] instancia = new Object[]{
                idPessoa, nome, cpf, rg, telefone, email
            };
            model.addRow(instancia);
        }
    }
        
    
        
        
        
        
        
    
    
    /**
     * Configura a conexão com base no arquivo databaseConfig.csv
     * Necessário ser executado em todo construtor de cada tela
     */
    public static void initConnection() {
        FileReader fr;
        BufferedReader br;
        Properties properties;
        String url = null, username = null, password = null;
        try {
            fr = new FileReader(FILE);
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
    
    /**
     * Reescreve o arquivo databeseConfig.csv
     * Usar createPropetiesInterface() para passar as informações
     * @param properties
     * @param file 
     */
    private static void writeFileProperties(Properties properties) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(FILE, false);
            bw = new BufferedWriter(fw);
            bw.write("URL: " + properties.getProperty(Tags.URL.name()));
            bw.newLine();
            bw.write("USERNAME: " + properties.getProperty(Tags.USERNAME.name()));
            bw.newLine();
            bw.write("PASSWORD: " + properties.getProperty(Tags.PASSWORD.name()));
            bw.close();
            fw.close();
        } catch(IOException e) {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * 
     * @return 
     */
    private static Properties createPropertiesInterface() {
        Properties properties = new Properties();
        properties.setProperty(Tags.URL.name(), "jdbc:mysql://localhost/appescola");
        properties.setProperty(Tags.USERNAME.name(), JOptionPane.showInputDialog("Insira o usuário do banco de dados."));
        properties.setProperty(Tags.PASSWORD.name(), JOptionPane.showInputDialog("Insira a senha do banco de dados."));
        return properties;
    }
    
    public static Pessoa buscarPessoa(Fator fator, String valor) throws SQLException {
        System.out.println("buscarPessoa()");
        Endereco endereco = buscarEndereco(fator, valor);
        
        String sql = 
            "SELECT * FROM pessoa pe "
          + "WHERE ";
        // Qual classe????? nenhuma? é só pessoa
        
        if(fator.equals(Fator.IDPESSOA)) {
            sql+= String.format("pe.%s=%d",fator.name(), Integer.parseInt(valor));
            // Deu nenhum resultado
        } else {
            sql+= String.format("pe.%s='%s'", fator.name(), valor);
        }
        
        Statement s = connection.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        Pessoa pessoa = null;
        
        while(r.next()) {
            
            String nome = r.getString(Tags.NOME.name());
            String cpf = r.getString(Tags.CPF.name());
            String rg = r.getString(Tags.RG.name());
            String telefone = r.getString(Tags.TELEFONE.name());
            String email = r.getString(Tags.EMAIL.name());
            
            String nomeEstadoCivil = r.getString(Tags.ESTADOCIVIL.name());
            String nomeGenero = r.getString(Tags.GENERO.name());
            String nomeCorRaca = r.getString(Tags.COR.name());
                      
            EstadoCivil estadoCivil = Enum.valueOf(EstadoCivil.class, nomeEstadoCivil);
            Genero genero = Enum.valueOf(Genero.class, nomeGenero);
            CorRaca corRaca = Enum.valueOf(CorRaca.class, nomeCorRaca);
            
            String deficiencia = r.getString(Tags.DEFICIENCIA.name());
            String nacionalidade = r.getString(Tags.NACIONALIDADE.name());
            java.sql.Date date = r.getDate(Tags.DATANASCIMENTO.name());
            System.out.println(date);
            LocalDate localDate = date.toLocalDate();
            
            Titular titular = new Titular(nome, cpf, rg, telefone, email, nacionalidade, deficiencia, localDate);
            
            pessoa = new Pessoa(titular, endereco, estadoCivil, genero, corRaca);
        }
        if(pessoa == null) {
            throw new NullPointerException("pessoa=null");
        }
        return pessoa;
    }
    public static Endereco buscarEndereco(Fator fator, String valor) throws SQLException {
        System.out.println(
                "Método buscarEndereco()" + System.lineSeparator() +
                "Fator: " + fator.name() + System.lineSeparator() +
                "Valor: " + valor);
        String sql = String.format(
                "SELECT e.estado, e.cidade, e.bairro, e.numero, e.endereco " +
                "FROM endereco e, pessoa p " +
                "WHERE e.idEndereco=p.idEndereco AND ");
        
        if(fator.equals(Fator.IDPESSOA)) {
            sql+= String.format("p.%s=%d", fator.name(), Integer.parseInt(valor));
        } else {
            sql+= String.format("p.%s='%s'", fator.name(), valor);
        }
        
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
        if(endereco == null) {
            throw new NullPointerException("Fator de busca inválido ou inexistente.");
        }
        return endereco;
    }
    /**
     * 
     * @param fator
     * @param valor
     * @return
     * @throws SQLException 
     */
    public static Professor buscarProfessor(Fator fator, String valor) throws SQLException {
        System.out.println("buscarProfessor()");
        
        Pessoa pessoa = buscarPessoa(fator, valor);
        
        String sql = String.format(
                "SELECT * " +
                "FROM pessoa pe, professor pr " +
                "WHERE pe.idPessoa=pr.idPessoa " +
                "AND pe.%s='%s'", fator.name(), valor
        );
        
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        
        Professor professor = null;
        while(result.next()) {
            int idPessoa = result.getInt(Tags.idPessoa.name());
            int idProfessor = result.getInt(Tags.idProfessor.name());
            
            String formacao = result.getString(Tags.FORMACAO.name());
            String historicoProfissional = result.getString(Tags.HISTORICOPROFISSIONAL.name());
            
            
            professor = new Professor(idPessoa, idProfessor, pessoa, formacao, historicoProfissional);
        }
        if(professor == null) {
            throw new NullPointerException("professor=null");
        } 
        return professor;
    }
    public static Estudante buscarEstudante(Fator fator, String valor) throws SQLException {
        
        Pessoa pessoa = buscarPessoa(fator, valor);
        String sql = String.format(
                "SELECT * " +
                "FROM pessoa pe JOIN estudante pr " +
                "ON pe.idPessoa=pr.idPessoa " +
                "WHERE pe.%s='%s'", fator.name(), valor
        );
        
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        Estudante estudante = null;
        while(result.next()) {
            int idPessoa = result.getInt(Tags.idPessoa.name());
            int idEstudante = result.getInt(Tags.idEstudante.name());
            
            String nomeResponsavel = result.getString(Tags.NOMERESPONSAVEL.name());
            String nomeEscolaridade = result.getString(Tags.ESCOLARIDADE.name());
            
            Escolaridade escolaridade = Enum.valueOf(Escolaridade.class, nomeEscolaridade);
            
            int trabalhaNum = result.getInt(Tags.trabalha.name());
            boolean trabalha = false;
            if(trabalhaNum == 1) {
                trabalha = true;
            }
            
            estudante = new Estudante(idPessoa, idEstudante, pessoa, nomeResponsavel, trabalha, escolaridade);
        }
        if(estudante == null) {
            throw new NullPointerException("Busca não encontrada");
        } 
        return estudante;
    }
}