package org.example;

import DAOImplements.AlunoDAOImplements;
import database.sqlConn;
//import jdk.vm.ci.meta.Local;
import model.Aluno;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        AlunoDAOImplements alunoDAOMethods = new AlunoDAOImplements();
        do {
            System.out.println("\n======= Menu =========");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Buscar aluno por ID");
            System.out.println("6. Sair do programa");

            opcao = sc.nextInt();


            sc.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de aluno");
                    System.out.println("NOME DO ALUNO: ");
                    String nome = sc.next();
                    System.out.println("cpf: ");
                    String cpf = sc.next();
                    System.out.println("email:");
                    String email = sc.next();
                    System.out.println("data de nascimento no seguinte formato: AA-MM-DD: ");
                    String dataNsc = sc.next();
                    System.out.println("Telefone: ");
                    String telefone = sc.next();
                    try {
                        Aluno AlunoNovo = new Aluno(nome, cpf, email, LocalDate.parse(dataNsc), telefone);
                        alunoDAOMethods.salvar(AlunoNovo);
                    } catch (Exception e) {
                        System.err.println("Ocorreu algum erro, tente novamente: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Atualizar Aluno");
                    System.out.println("Digite o Id do aluno que deseja atualizar: ");
                    int idAtualizar = sc.nextInt();
                    System.out.println("Escolha a opcao que deseja atualiza: ");
                    System.out.println("[1] Nome");
                    System.out.println("[2] Email ");
                    System.out.println("[3] Telefone ");
                    int opcaoAtualizar = sc.nextInt();
                    switch (opcaoAtualizar) {
                        case 1:
                            System.out.println("Digite o novo valor para NOME: ");
                            String novoNome = sc.next();
                            alunoDAOMethods.atualizarAluno("nome", novoNome, idAtualizar);
                            break;
                        case 2:
                            System.out.println("Digite o novo valor para email: ");
                            String novoEmail = sc.next();
                            alunoDAOMethods.atualizarAluno("email", novoEmail, idAtualizar);
                            break;
                        case 3:
                            System.out.println("Digite o novo valor para telefone: ");
                            String novoTelefone = sc.next();
                            alunoDAOMethods.atualizarAluno("telefone", novoTelefone, idAtualizar);
                            break;
                    }


                    break;
                case 3:
                    System.out.println("Excluir Aluno");
                    System.out.println("Digite o id do aluno que deseja excluir: ");
                    int id = sc.nextInt();
                    try {
                        alunoDAOMethods.excluirAluno(id);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Listar Alunos");
                    if (alunoDAOMethods.listarTodosAlunos().isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado!");
                    } else {
                        for (Aluno aluno : alunoDAOMethods.listarTodosAlunos()) {
                            System.out.println(aluno);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Digite o id do aluno: ");
                    int idAlunoExcluir = sc.nextInt();
                    Optional<Aluno> aluno = alunoDAOMethods.buscarAlunoPorID(idAlunoExcluir);
                    if (aluno.isPresent()) {
                        System.out.println(aluno.get());
                    } else {
                        System.out.println("Aluno nao encontrado, verifique o ID...");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    opcao = 0;
                    break;
            }


        } while (opcao != 0);

        sc.close();

    }
}
