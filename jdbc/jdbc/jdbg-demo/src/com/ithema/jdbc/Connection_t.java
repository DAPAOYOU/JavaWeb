package com.ithema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection_t {
    public static void main(String[] args) throws Exception{

        String url="jdbc:mysql:///jdbc?useSSL=false";
        String username="root";
        String password="csk1507806125";
        //作用一:获取conn对象
        Connection conn = DriverManager.getConnection(url,username,password);

        String sql1="update t set tsalary=1000 where tname='章云'";
        String sql2="update t set tsalary=2000 where tname='朱超'";
        Statement stmt = conn.createStatement();

        try {
            //作用2:开启事务
            conn.setAutoCommit(false);//手动

            int count1 = stmt.executeUpdate(sql1);
            System.out.println(count1);
            int count2 = stmt.executeUpdate(sql2);
            System.out.println(count2);

            conn.commit();//提交事务
        } catch (Exception e) {

            conn.rollback();//回滚事务
            throw new RuntimeException(e);
        }

        stmt.close();
        conn.close();
    }
}
