package JDBCTask;

import java.sql.*;

public class CRUDOperationStatementJDBC {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName ="root";
        String passWord ="prabhasasindran123";
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(url, userName, passWord);
            stmt = con.createStatement();
            Insert(stmt);
            Read(stmt);
            Update(stmt);
            Delete(stmt);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void Insert(Statement stmt) throws SQLException{
       String sql = "Insert into sample values('Nina', 'Mumbai')";
       stmt.execute(sql);
       System.out.println("Inserted");
    }
    public static void Read(Statement stmt) throws SQLException{
        ResultSet rs = null;
        String sql = "Select * from sample";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
         System.out.println("Name "+rs.getString(1)+" City "+rs.getString(2));
        }
    }
    public static void Update(Statement stmt) throws SQLException{
        String sql = "update sample set city ='Delhi' where name = 'Nina'";
        stmt.executeUpdate(sql);
        System.out.println("updated");
    }
    public static void Delete(Statement stmt) throws SQLException{
        String sql = "delete from sample where name ='Prakash'";
        stmt.execute(sql);
        System.out.println("Deleted");
    }
}
