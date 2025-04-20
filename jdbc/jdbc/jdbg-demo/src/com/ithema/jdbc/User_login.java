package com.ithema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 用户登陆
*/

public class User_login {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql:///jdbc?useSSL=false";
        String username="root";
        String password="csk1507806125";
        Connection conn = DriverManager.getConnection(url,username,password);

        String name = "";
        String pwd = "";

        String sql = "select * from tb_user where username == '"+ name +"' and password == '" + pwd + "'";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        //判断登陆是否成功
        if (rs.next()){  //只要有结果就代表登陆成功了
            System.out.println("登陆成功");
        }
        else{
            System.out.println("登陆失败");
        }
    }
}
