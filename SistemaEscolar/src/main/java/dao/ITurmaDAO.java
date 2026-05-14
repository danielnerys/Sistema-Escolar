package dao;

import model.Aluno;
import model.Turma;

import java.util.List;

public interface ITurmaDAO {
    List<Turma> listarTurmas();

    List<Aluno> listarAlunosTurma(int id);
}
