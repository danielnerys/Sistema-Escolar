package DAOImplements;

import dao.ITurmaDAO;
import database.sqlConn;
import model.Aluno;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOImplements implements ITurmaDAO {

    @Override
    public List<Turma> listarTurmas() {
        List<Turma> turmas = new ArrayList<>();
        String sql = "select * from turma";
        try (Connection conn = sqlConn.getConnection()) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    turmas.add(new Turma(rs.getInt("id"),
                            rs.getInt("instituicao_id"),
                            rs.getInt("professor_id"),
                            rs.getString("nome"),
                            rs.getDate("ano_letivo").toLocalDate(),
                            rs.getString("turno"),
                            rs.getInt("vagas"),
                            rs.getDate("criado_em").toLocalDate()));


                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return turmas;
    }

    @Override
    public List<Aluno> listarAlunosTurma(int idTurma) {
        String sql = "select c.* from matricula a join turma b on a.turma_id = b.id join aluno c on a.aluno_id = c.id where b.id = ?";

        List<Aluno> alunosNaTurma = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection()) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idTurma);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    alunosNaTurma.add(new Aluno(
                            rs.getInt("id"),
                            rs.getString("nome"),
                                    rs.getString("cpf"),
                                    rs.getString("email"),
                                    rs.getDate("data_nascimento").toLocalDate(),
                                    rs.getString("telefone")));
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return alunosNaTurma;

    }

}
