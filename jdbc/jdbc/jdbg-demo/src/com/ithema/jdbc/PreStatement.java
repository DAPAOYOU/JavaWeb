package com.ithema.jdbc;

import java.sql.*;

//preparedstatement 防止sql注入问题
public class PreStatement {
    public static void main(String[] args) throws Exception {
        //url上加上  useServerPrepStmts=true  开启预编译，，性能更高
        String url="jdbc:mysql:///jdbc?useSSL=false&useServerPrepStmts=true";
        String username="root";
        String password="csk1507806125";
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql = "select * from user_tb where username = ? and password = ?";
        String name = "zhangsan";
        String pwd = "123";
        String heke = "' or '1' = '1";
        PreparedStatement pstmt =  conn.prepareStatement(sql);

        pstmt.setString(1,name);
        pstmt.setString(2,pwd);
        //pstmt.setString(2,heke);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            System.out.println("登陆成功");
        }
        else {
            System.out.println("登陆失败");
        }

        //释放资源
        rs.close();
        pstmt.close();
        conn.close();

    }
}
