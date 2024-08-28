package JDBCPack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WithCallableStatementUpdateJDBC {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName = "root";
        String passWord = "prabhasasindran123";
        try {
            con = DriverManager.getConnection(url, userName, passWord);
            String sql = "{call updateOperation(?,?)}";
            CallableStatement stmt = con.prepareCall(sql);
            stmt.setString(1,"Anju");
            stmt.setString(2,"Bihar");
            stmt.executeUpdate();
            System.out.println("updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
