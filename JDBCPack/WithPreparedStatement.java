package JDBCPack;


import java.sql.*;
import java.util.Scanner;

public class WithPreparedStatement {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/scott";
        String userName = "root";
        String passWord = "prabhasasindran123";
        try {
            Scanner sc = new Scanner(System.in);
            boolean lol = true;
            con = DriverManager.getConnection(url, userName, passWord);
            while (lol) {
                System.out.println("Press 1 for Update");
                System.out.println("Press 2 for Delete");
                System.out.println("Press 3 for Insert");
                System.out.println("Press 4 for Cancel");
                System.out.println("Press 5 for Reading Data");
                System.out.println();
                System.out.println("++++++++++++++++++++++ +++++++++++++++++++++++++++");
                System.out.println();
                System.out.println("Please Enter your choice");
                int a = sc.nextInt();
                sc.nextLine();
                switch (a) {
                    case 1:
                        update(con, sc);
                        break;

                    case 2:
                        delete(con, sc);
                        break;

                    case 3:
                        insert(con, sc);
                        break;

                    case 4:
                        lol = false;
                        break;

                    case 5:
                        read(con, sc);
                        break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insert(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the name to be inserted:");
        String name = sc.nextLine();
        System.out.println("Enter the city to be inserted:");
        String city = sc.nextLine();

        String sql = "INSERT INTO sample (name, city) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        }
    }

    public static void update(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the name to update:");
        String name = sc.nextLine();
        System.out.println("Enter the new name:");
        String newName = sc.nextLine();

        String sql = "UPDATE sample SET name = ? WHERE name = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Record updated successfully.");
        }
    }

    public static void delete(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the name to be deleted:");
        String name = sc.nextLine();

        String sql = "DELETE FROM sample WHERE name = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Record deleted successfully.");
        }
    }

    public static void read(Connection con, Scanner sc) throws SQLException {
        System.out.println("Enter the name:");
        String name = sc.nextLine();

        String sql = "SELECT * FROM sample WHERE name = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("City: " + rs.getString("city"));
            }
        }
    }
}

