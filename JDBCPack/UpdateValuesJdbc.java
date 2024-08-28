package JDBCPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateValuesJdbc {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName = "root";
        String passWord = "prabhasasindran123";
        try {
            con = DriverManager.getConnection(url,userName,passWord);
            Statement stmt = con.createStatement();
            String sql = "update sample set city ='Bihar' where name ='Anju'";
            stmt.executeUpdate(sql);
            System.out.println("Upadted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
