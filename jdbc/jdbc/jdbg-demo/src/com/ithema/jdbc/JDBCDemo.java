package com.ithema.jdbc;

import java.sql.DriverManager;//驱动管理类
import java.sql.Connection;//获取执行sql对象，管理事务
import java.sql.Statement;//执行sql语句
//DDL对表和库的增删改操作
//DML对数据的增删改操作
//int executeUpdate(sql)  执行DDL和DML语句

//DQL对数据的查询操作
//ResultSet executeQuery(sql) 执行DQL语句

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动   背会   ///mysql5以后可以不写这个注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //连接
        String url="jdbc:mysql:///jdbc?useSSL=false";
        //  ?useSSL=false  这个是禁用安全连接，要不有红字提示，看着烦
        //String url="jdbc:mysql://localhost:3306/jdbc";
        //url:连接路径   jdbc:mysql://ip地址:端口号/数据库名称
        //如果连接的本机的数据库，可以省略ip和端口号（端口号默认是3306的情况下）
        String username="root";
        String password="csk1507806125";
        Connection conn = DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql="update t set tsalary=1000 where tname='章云'";

        //获取statement对象
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);//这个会返回受影响的行数

        System.out.println(count);

        //释放资源
        stmt.close();
        conn.close();

    }
}
