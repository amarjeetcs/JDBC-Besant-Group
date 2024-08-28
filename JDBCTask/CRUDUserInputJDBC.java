package JDBCTask;

import java.sql.*;
import java.util.Scanner;

public class CRUDUserInputJDBC {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName ="root";
        String passWord ="prabhasasindran123";
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        try {
            con = DriverManager.getConnection(url, userName, passWord);
            stmt = con.createStatement();
            Insert(stmt,sc);
            Read(stmt,sc);
            Update(stmt,sc);
            Delete(stmt,sc);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void Insert(Statement stmt, Scanner sc)throws SQLException{
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter city");
        String city = sc.nextLine();
        String sql = "insert into sample values('"+name+"','"+city+"')";
        stmt.execute(sql);
        System.out.println("Inserted");
    }
    public static void Read(Statement stmt, Scanner sc) throws SQLException{
        ResultSet rs = null;
        System.out.println("Enter name");
        String name = sc.nextLine();
        String sql = "select * from sample where name ='"+name+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
          System.out.println("Name "+rs.getString("name")+" City "+rs.getString("city"));
        }
        System.out.println("Reading done");
    }
    public static void Update(Statement stmt, Scanner sc) throws SQLException{
        System.out.println("Enter new city");
        String city = sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        String sql = "update sample set city='"+city+"' where name ='"+name+"'";
        stmt.executeUpdate(sql);
        System.out.println("Updated");
    }
    public static void Delete(Statement stmt, Scanner sc) throws SQLException{
        System.out.println("Enter name");
        String name = sc.nextLine();
        String sql = "delete from sample where name ='"+name+"'";
        stmt.execute(sql);
        System.out.println("deleted");
    }
}
