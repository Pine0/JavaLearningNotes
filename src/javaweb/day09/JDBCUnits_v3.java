package javaweb.day09;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUnits_v3 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            //1、获取当前类的加载器
            ClassLoader classLoader = JDBCUnits_v3.class.getClassLoader();
            //2、通过类加载器获得输入流
            InputStream is = classLoader.getResourceAsStream("javaweb/day09/db.properties");
            //3、创建一个properties对象
            Properties props = new Properties();
            //4、加载输入流
            props.load(is);
            //5、获取参数
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
