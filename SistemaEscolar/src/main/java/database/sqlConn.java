package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlConn {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/sistema_escolar";
    private static final String user = "root";
    private static final String password = "Senai@134";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

    public static void testConnection(){
        try(Connection conn = getConnection()){
            System.out.println("Success " + conn);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
