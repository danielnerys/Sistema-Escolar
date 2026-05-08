package org.example;

import DAOImplements.AlunoDAOImplements;
import database.sqlConn;
import model.Aluno;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int opcao;

        AlunoDAOImplements alunoDAOMethods = new AlunoDAOImplements();
        do{
            System.out.println("======= Menu =========");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Buscar aluno por ID");
            System.out.println("6. Sair do programa");

            opcao = sc.nextInt();

            sc.nextLine();


            switch (opcao){
                case 1:
                    System.out.println("Cadastro de aluno");
                    break;
                case 2:
                    System.out.println("Atualizar Aluno");
                    break;
                case 3:
                    System.out.println("Excluir Alunos");
                    break;
                case 4:
                    System.out.println("Listar Alunos");
                    if(alunoDAOMethods.listarTodosAlunos().isEmpty()){
                        System.out.println("Nenhum aluno cadastrado!");
                    }else{
                        for(Aluno aluno: alunoDAOMethods.listarTodosAlunos()){
                            System.out.println(aluno);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Digite o id do aluno: ");
                    int id = sc.nextInt();

                    System.out.println(alunoDAOMethods.buscarAlunoPorID(id));


                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    opcao = 0;
                    break;
            }


        }while(opcao!=0);

        sc.close();
    }
}
