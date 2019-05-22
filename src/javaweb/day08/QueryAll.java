package javaweb.day08;


import org.junit.Test;

import java.sql.*;

public class QueryAll {

    @Test
    public void testQueryAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/score?characterEncoding=utf8&useSSL=false";
            String username = "root";
            String password = "wxs123lxd";
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql = "select * from student";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("学号："+rs.getString("No"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
