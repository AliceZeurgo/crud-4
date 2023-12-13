package model;

import java.util.Scanner;

public class Produtos {

    private Scanner scanner = new Scanner(System.in);
    private String nome, descricao, caracteristica;
    private int id, quantidade;
    private double preco;

    public Produtos() {
    }

    public Produtos(String nome, String descricao, String caracteristica, int id, int quantidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.caracteristica = caracteristica;
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void realizarCadastroProdutos() {
        try {
            System.out.print("Qual o nome do item: ");
            this.nome = scanner.nextLine();
            System.out.print("Adicione uma descrição ao item: ");
            this.descricao = scanner.nextLine();
            System.out.print("Adicione uma característica do item: ");
            this.caracteristica = scanner.nextLine();
            System.out.print("Quantidade disponível: ");
            this.quantidade = scanner.nextInt();
            System.out.print("Preço do item: ");
            this.preco = Double.parseDouble(scanner.next());

            System.out.println("Cadastro do produto realizado com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler o preço. Certifique-se de digitar um número válido.");
            scanner.nextLine();
        }
    }

    public String obterNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String obterDescricao() {
        return descricao;
    }

    public void definirDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String obterCaracteristica() {
        return caracteristica;
    }

    public void definirCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public int obterId() {
        return id;
    }

    public void definirId(int id) {
        this.id = id;
    }

    public int obterQuantidade() {
        return quantidade;
    }

    public void definirQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double obterPreco() {
        return preco;
    }

    public void definirPreco(double preco) {
        this.preco = preco;
    }
}
