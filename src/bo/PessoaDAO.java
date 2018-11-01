package bo;

import database.JDBCConnection;
import poco.Pessoa;

import java.awt.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PessoaDAO {

    private Connection conn;

    public PessoaDAO() {
        try {
            this.conn = JDBCConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Pessoa> getPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pessoa";
            Statement stm = this.conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                Pessoa cli = new Pessoa();
                cli.cpf = result.getLong(1);
                cli.nome = result.getString(2);
                cli.sexo = result.getString(3).charAt(0);
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date date = df.parse(result.getString(4));
                cli.dataNascimento = date;
                cli.numero_cep = result.getInt(5);
                pessoas.add(cli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public boolean insert(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa (cpf, nome, sexo, datanasc, id_end) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, pessoa.cpf);
        statement.setString(2, pessoa.nome);
        statement.setString(3, pessoa.sexo + "");
        statement.setDate(4, new java.sql.Date(pessoa.dataNascimento.getTime()));
        statement.setInt(5, pessoa.numero_cep);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0)
            return true;
        else
            return false;
    }

    public void delete(Pessoa pessoa) {
        try {
            PreparedStatement stmt = conn.prepareStatement("delete " +
                    "from pessoa where cpf=?");
            stmt.setLong(1, pessoa.cpf);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Pessoa find(long input) throws SQLException {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pessoa where cpf=" + input;
            Statement stm = this.conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                Pessoa cli = new Pessoa();
                cli.cpf = result.getLong(1);
                cli.nome = result.getString(2);
                cli.sexo = result.getString(3).charAt(0);
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date date = df.parse(result.getString(4));
                cli.dataNascimento = date;
                cli.numero_cep = result.getInt(5);
                pessoas.add(cli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(pessoas.size() == 1)
            return pessoas.get(0);
        else if (pessoas.size()>1)
            throw new SQLException("To many results!");
        else
            throw new SQLException("No data found!");
    }
}
