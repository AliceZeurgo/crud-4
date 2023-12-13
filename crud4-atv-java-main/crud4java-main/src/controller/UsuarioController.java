package controller;

import model.Conexao;
import model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private final Conexao conexao;
    private final Connection connection;

    public UsuarioController() throws SQLException {
        this.conexao = new Conexao();
        this.connection = this.conexao.getConnection();

        if (this.connection == null) {
            System.out.println("Erro: Não foi possível obter a conexão com o banco de dados.");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        try (Statement statement = connection.createStatement()) {
            String queryCadastro = String.format("INSERT INTO usuarios(nome, cpf, email) VALUES ('%s', '%s', '%s')",
                    usuario.getNome(), usuario.getCpf(), usuario.getEmail());

            statement.executeUpdate(queryCadastro);
            System.out.println("Usuário cadastrado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void pesquisarUsuario(String cpf) throws SQLException {

        Statement statement = connection.createStatement();

        String queryPesquisa = String.format("SELECT * FROM usuarios WHERE cpf='%s'", cpf);

        ResultSet resultSet = statement.executeQuery(queryPesquisa);
        List<Usuario> usuarioList = new ArrayList<>();


        while (resultSet.next()) {
            Usuario usuario = new Usuario();

            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setEmail(resultSet.getString("email"));

            usuarioList.add(usuario);
        }

        if (usuarioList.isEmpty()) {
            System.out.println("Nenhum usuário encontrado com o CPF: " + cpf);
        } else {
            for (Usuario usuario : usuarioList) {
                exibirUsuario(usuario);
            }
        }
    }

    public void deletarUsuario(String cpf) {
        try (Statement statement = connection.createStatement()) {
            String queryDelete = String.format("DELETE FROM usuarios WHERE cpf='%s'", cpf);
            int rowsAffected = statement.executeUpdate(queryDelete);

            if (rowsAffected > 0) {
                System.out.println("Usuário " + cpf + " deletado com sucesso.");
            } else {
                System.out.println("Nenhum usuário encontrado com o CPF: " + cpf);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
    }

    public void listarUsuarios(String nomePesquisa) {
        try (Statement statement = connection.createStatement()) {
            String queryConsulta = "SELECT * FROM usuarios";

            ResultSet resultSet = statement.executeQuery(queryConsulta);

            while (resultSet.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setEmail(resultSet.getString("email"));

                exibirUsuario(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

    private void exibirUsuario(Usuario usuario) {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("--------");
    }
}
