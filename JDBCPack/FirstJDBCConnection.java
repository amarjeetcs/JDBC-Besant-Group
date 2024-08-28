package JDBCPack;

import java.sql.*;

public class FirstJDBCConnection {
    public static void main(String[] args) {
        Connection con = null;
        try {
            //Class.forName(":com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/scott";
            String userName = "root";
            String passWord = "prabhasasindran123";
            con = DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            String sql = "select * from sample";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
               // int id = rs.getInt("deptno");
//                String name = rs.getString(1);
//                String location = rs.getString(2);
                String name = rs.getString("name");
                String location = rs.getString("city");
                System.out.println("name " + name);
                //System.out.println("Department name " + name);
                System.out.println("city " + location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con!= null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
