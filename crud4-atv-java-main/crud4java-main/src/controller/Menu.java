package controller;

import model.Produtos;
import model.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void executarMenu() throws SQLException {
        boolean continuar = true;

        Usuario usuario = new Usuario();
        Produtos produtos = new Produtos();
        UsuarioController usuarioController = new UsuarioController();
        ProdutosController produtoController = new ProdutosController();

        try (Scanner scanner = new Scanner(System.in)) {
            while (continuar) {
                System.out.println("| Gerenciamento de Produtos em Estoque |");
                System.out.println(" |1| - Cadastrar produto");
                System.out.println(" |2| - Cadastrar usuário");
                System.out.println(" |3| - Pesquisar produto");
                System.out.println(" |4| - Pesquisar Usuário");
                System.out.println(" Outras funcionalidades:");
                System.out.println(" |5| - Deletar Usuário");
                System.out.println(" |6| - Deletar Produto");
                System.out.println(" |7| - Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    produtos.realizarCadastroProdutos();
                    produtoController.cadastrarProdutos(produtos);

                } else if (opcao == 2) {
                    usuario.realizarCadastroUsuario();
                    usuarioController.cadastrarUsuario(usuario);

                } else if (opcao == 3) {
                    System.out.println("Informe o Id do produto");
                    int idProduto = scanner.nextInt();
                    produtoController.pesquisarProdutos(idProduto);

                } else if (opcao == 4) {
                    System.out.print("Informe o CPF do usuário: ");
                    String cpfPesquisa = scanner.nextLine();
                    usuarioController.pesquisarUsuario(cpfPesquisa);

                } else if (opcao == 5) {
                    System.out.print("Informe o CPF do usuário:");
                    String cpfDeletar = scanner.nextLine();
                    usuarioController.deletarUsuario(cpfDeletar);

                } else if (opcao == 6) {
                    System.out.print("Informe o Id do produto:");
                    int idDeletar = scanner.nextInt();
                    produtoController.deletarProdutos(idDeletar);

                } else if (opcao == 7) {
                    continuar = false;

                } else {
                    System.out.println("Opção inválida");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
