package JDBCPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValuesIntoTable {
    public static void main(String[] args){
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/scott";
            String userName = "root";
            String passWord = "prabhasasindran123";
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            String sql = "insert into sample values('Anju','Bangalore')";
           // String sql = "insert into sample(name,city) values(Prabha,Kerala)";
            stmt.execute(sql);
            System.out.println("Inserted data");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
