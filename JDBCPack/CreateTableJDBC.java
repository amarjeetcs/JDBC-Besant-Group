package JDBCPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableJDBC {
    public static void main(String[] args){
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/scott";
            String userName = "root";
            String passWord = "prabhasasindran123";
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            String sql = "create table sample(name varchar(20), city varchar(20))";
            stmt.execute(sql);
            System.out.println("Created table");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
