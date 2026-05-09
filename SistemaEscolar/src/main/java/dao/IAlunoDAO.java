package dao;

import model.Aluno;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {
    //CRUD
    //C -> CREATE

    void salvar(Aluno aluno);


    //R -> read
    List<Aluno> listarTodosAlunos();




    Optional<Aluno> buscarAlunoPorID(int id);

    //U -> update
    void atualizarAluno(Aluno aluno);

    //D -> delete
    void excluirAluno(int id);
}