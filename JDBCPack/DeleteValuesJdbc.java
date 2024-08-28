package JDBCPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteValuesJdbc {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName = "root";
        String passWord = "prabhasasindran123";
        try {
            con = DriverManager.getConnection(url,userName,passWord);
            Statement stmt = con.createStatement();
            String sql = "delete from sample where city ='Bangalore'";
            stmt.execute(sql);
            System.out.println("Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
