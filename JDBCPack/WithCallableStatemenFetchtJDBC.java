package JDBCPack;

import java.sql.*;
import java.util.Scanner;

public class WithCallableStatemenFetchtJDBC {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName = "root";
        String passWord = "prabhasasindran123";
        try {
            con = DriverManager.getConnection(url, userName, passWord);
            String sql = "{call getUsers()}";
            CallableStatement stmt = con.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               System.out.println("Name "+rs.getString(1)+" City "+rs.getString(2));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
