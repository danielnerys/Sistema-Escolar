package org.example;

import DAOImplements.AlunoDAOImplements;
import database.sqlConn;
import model.Aluno;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        sqlConn.testConnection();
        AlunoDAOImplements a = new AlunoDAOImplements();

        System.out.println(a.listarTodosAlunos());
        for(Aluno b: a.listarTodosAlunos()){
            System.out.println(b);
        }
    }
}
