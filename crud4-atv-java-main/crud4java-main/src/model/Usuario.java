package model;

import java.util.Scanner;

public class Usuario {

        private Scanner scanner = new Scanner(System.in);
        private String nome, cpf, email;
        private int id = 0;

        public void realizarCadastro() {
            System.out.print("Informe seu nome: ");
            this.nome = scanner.nextLine();
            System.out.print("Digite seu CPF: ");
            this.cpf = scanner.nextLine();
            System.out.print("Insira seu endereço de email: ");
            this.email = scanner.nextLine();

            System.out.println("✓ Cadastro realizado com sucesso!");
        }

        public String obterNome() {
            return nome;
        }

        public void definirNome(String nome) {
            this.nome = nome;
        }

        public String obterCPF() {
            return cpf;
        }

        public void definirCPF(String cpf) {
            this.cpf = cpf;
        }

        public int obterID() {
            return id;
        }

        public void definirID(int id) {
            this.id = id;
        }

        public String obterEmail() {
            return email;
        }

        public void definirEmail(String email) {
            this.email = email;
        }

        public void realizarCadastroUsuario() {
        }

    public Object getNome() {
        return null;
    }

    public Object getCpf() {
        return null;
    }

    public Object getEmail() {
        return null;
    }

    public void setId(int id) {
    }

    public void setNome(String nome) {
    }

    public void setCpf(String cpf) {
    }

    public void setEmail(String email) {
    }

    public boolean getId() {
        return false;
    }
}


