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
import java.util.Optional;

public class AlunoDAOImplements implements IAlunoDAO {
    @Override
    public void salvar(Aluno aluno) {

        try(Connection conn = sqlConn.getConnection()){
            String sql = "INSERT INTO ALUNO (nome, cpf, email, data_nascimento, telefone) VALUES (?, ?, ? ,?, ?)";
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, aluno.getNome());
                pstmt.setString(2, aluno.getCpf());
                pstmt.setString(3, aluno.getEmail());
                pstmt.setObject(4, aluno.getData_nascimento());
                pstmt.setString(5, aluno.getTelefone());

                int rowAffected = pstmt.executeUpdate();
                System.out.println("Atualizacoes realizadas " + rowAffected );
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }


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
    public Optional<Aluno> buscarAlunoPorID(int id){
        String sql = String.format("Select * from aluno where id = %s", id);
        try(Connection conn = sqlConn.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Aluno aluno =  new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone"));
                return Optional.of(aluno);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }


    @Override
    public void atualizarAluno(Aluno aluno) {


    }

    @Override
    public void excluirAluno(int id) {
        try(Connection conn = sqlConn.getConnection()){
            String sql = "DELETE FROM ALUNO WHERE ID = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setInt(1, id);

                int rowsAffected = stmt.executeUpdate();
                System.out.println("Aluno exlcuido com sucesso" + rowsAffected);

            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
