package DAOImplements;

import dao.IAlunoDAO;
import database.sqlConn;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImplements implements IAlunoDAO {
    @Override
    public void salvar(Aluno aluno) {
        String sql = String.format("INSERT INTO ALUNO (nome, cpf, email, data_nascimento, telefone) VALUES (%s, %s, %s, %s, %s)", aluno.getNome(), aluno.getCpf(), aluno.getEmail(), aluno.getData_nascimento(), aluno.getTelefone());

        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Aluno>  listarTodosAlunos() {
        String sql ="SELECT * FROM aluno ORDER BY NOME ASC";
        List<Aluno> alunos = new ArrayList<>();

        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                        ));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return alunos;
    }

    @Override
    public Aluno buscarAlunoPorID(int id){
        String sql = String.format("Select * from aluno where id = %s", id);
        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                return new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    @Override
    public void atualizarAluno(Aluno aluno) {

    }

    @Override
    public void excluirAluno(int id) {

    }
}
