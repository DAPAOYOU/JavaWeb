package com.ithema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn_gtp {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        String url = "jdbc:mysql:///jdbc?useSSL=false";
        String username = "root";
        String password = "csk1507806125";

        try {
            // 1. 获取连接
            conn = DriverManager.getConnection(url, username, password);

            // 2. 创建Statement
            stmt = conn.createStatement();

            // 3. 开启事务
            conn.setAutoCommit(false);

            // 4. 执行SQL
            String sql1 = "update t set tsalary=1000 where tname='章云'";
            String sql2 = "update t set tsalary=2000 where tname='朱超'"; // 修正拼写错误

            int count1 = stmt.executeUpdate(sql1);
            System.out.println(count1);

            int count2 = stmt.executeUpdate(sql2);
            System.out.println(count2);

            // 5. 提交事务
            conn.commit();

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback(); // 回滚事务
                }
            } catch (SQLException ex) {
                ex.printStackTrace();//打印异常堆栈跟踪信息​​ 的标准方法，它会将异常的详细信息输出到标准错误流（通常是控制台）。
            }
            e.printStackTrace();
        } finally {
            // 6. 关闭资源
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
