package javaweb.day08;

import org.junit.Test;

import java.sql.*;

public class Login {
    @Test
    public void testLogin() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/user";
            String username = "root";
            String password = "wxs123lxd";

            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from tbl_user where uname='" + "soon" + "'and upassword='" + "123456" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("恭喜你，" + username + "登陆成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
