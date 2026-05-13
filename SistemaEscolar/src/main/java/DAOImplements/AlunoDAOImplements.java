package DAOImplements;

import dao.IAlunoDAO;
import database.sqlConn;
import model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class AlunoDAOImplements implements IAlunoDAO {
    @Override
    public void salvar(Aluno aluno) {

        try(Connection conn = sqlConn.getConnection()){
            String sql = "INSERT INTO ALUNO (nome, cpf, email, data_nascimento, telefone) VALUES (?, ?, ? ,?, ?)";
            try(PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, aluno.getNome());
                pstmt.setString(2, aluno.getCpf());
                pstmt.setString(3, aluno.getEmail());
                pstmt.setDate(4, Date.valueOf(aluno.getData_nascimento()));
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
    public void atualizarAluno(String campo, String novoValor, Integer id) {
        String sql = "UPDATE ALUNO SET "+ campo + " = ? WHERE ID = ? ";
        try(Connection conn = sqlConn.getConnection()){
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                pstmt.setString(1, campo);
                pstmt.setString(1, novoValor);
                pstmt.setInt(2, id);
                int  rowAffected = pstmt.executeUpdate();
                System.out.printf("Atualizado %s para %s no aluno id %s" ,campo, novoValor, id);

            }catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

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
