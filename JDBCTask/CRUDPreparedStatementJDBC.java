package JDBCTask;

import JDBCPack.UpdateValuesJdbc;

import java.sql.*;
import java.util.Scanner;

public class CRUDPreparedStatementJDBC {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName ="root";
        String passWord ="prabhasasindran123";
        Scanner sc = new Scanner(System.in);
        try {
            con = DriverManager.getConnection(url,userName,passWord);
            Insert(con,sc);
            Read(con,sc);
            Update(con,sc);
            Delete(con,sc);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Insert(Connection con,Scanner sc) throws SQLException{
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter city");
        String city = sc.nextLine();
        String sql = "insert into sample values (?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,name);
        stmt.setString(2,city);
        stmt.execute();
        System.out.println("Inserted using preparedstatement");
    }
    public static void Read(Connection con,Scanner sc) throws SQLException {
        ResultSet rs = null;
        System.out.println("Enter name");
        String name = sc.nextLine();
        String sql = "select * from sample where name = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,name);
        rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println("Name "+rs.getString(1)+" City "+rs.getString(2));
        }
        System.out.println("Reading done using preparedstatement");
    }
    public static void Update(Connection con,Scanner sc) throws SQLException {
        System.out.println("Enter new city");
        String city = sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        String sql = "update sample set city =? where name =?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,city);
        stmt.setString(2,name);
        stmt.executeUpdate();
        System.out.println("Updated using preparedstatement");
    }
    public static void Delete(Connection con,Scanner sc) throws SQLException {
        System.out.println("Enter name");
        String name = sc.nextLine();
        String sql = "delete from sample where name =?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,name);
        stmt.execute();
        System.out.println("Deleted using preparedstatement");
    }

}
