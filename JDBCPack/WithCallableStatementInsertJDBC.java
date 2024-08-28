package JDBCPack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WithCallableStatementInsertJDBC {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName = "root";
        String passWord = "prabhasasindran123";
        try {
            con = DriverManager.getConnection(url, userName, passWord);
            String sql = "{call insertData(?,?)}";
            CallableStatement stmt = con.prepareCall(sql);
            stmt.setString(1,"Tina");
            stmt.setString(2,"Bangalore");
            stmt.execute();
            System.out.println("inserted");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
