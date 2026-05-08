package dao;

import model.Aluno;

import java.util.List;

public interface IAlunoDAO {
    //CRUD
    //C -> CREATE

    void salvar(Aluno aluno);


    //R -> read
    List<Aluno> listarTodosAlunos();




    Aluno buscarAlunoPorID(int id);

    //U -> update
    void atualizarAluno(Aluno aluno);

    //D -> delete
    void excluirAluno(int id);
}