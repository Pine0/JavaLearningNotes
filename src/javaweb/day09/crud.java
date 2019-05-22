package javaweb.day09;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class crud {

    /**
     * 更新密码
     */
    @Test
    public void testUpdateById() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUnits_v3.getConnection();
            String sql = "update tbl_user set upassword=? where uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"123456");
            pstmt.setInt(2,1);
            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("更新成功");
            }
            else {
                System.out.println("更新失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据uid删除记录
     * @param uid
     */
    public void testDeleteById(int uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUnits_v3.getConnection();
            String sql = "delect from tbl_user where uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uid);
            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("删除成功");
            }
            else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加操作
     * @param uid
     * @param uname
     * @param upassword
     */
    public void testAdd(int uid, String uname, String upassword) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUnits_v3.getConnection();
            String sql = "insert into tbl_user values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uid);
            pstmt.setString(2, uname);
            pstmt.setString(3, upassword);
            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("添加成功");
            }
            else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据uid查询信息
     * @param uid
     */
    public void testQuery(int uid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUnits_v3.getConnection();
            String sql = "select * from tbl_user where uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uid);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println("用户ID：" + rs.getString("uid") +
                        "，用户名：" + rs.getString("uname") + "，密码："
                        + rs.getString("upassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
