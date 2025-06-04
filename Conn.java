import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            String dbUrl = "jdbc:mysql:///Bankmanagementsystem";
            String username = "root";
            String password = "@9920600274";
            c = DriverManager.getConnection(dbUrl, username, password);
            s = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
