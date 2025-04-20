package com.ithema.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Druid_Demo {
    public static void main(String[] args) throws Exception {

        //导入druid的jar包
        //导入定义配置文件properties

        //加载配置文件
        Properties prop = new Properties();
        System.out.println(System.getProperty("user.dir"));
        prop.load(new FileInputStream("jdbc/jdbg-demo/src/druid.properties"));
        //配置文件的相对路径,FileInputStream用于读取文件内容
        //System.out.println(System.getProperty("user.dir"));
        //不知道错哪里开始省略然后往后写，就用上面的代码看一下省略到哪里


        //获取连接池对象,到这里相当于连接数据库了，配置文件里的（properties）就是放的位置，用户名和密码之类的
        DataSource datasource = (DataSource) DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = datasource.getConnection();

        System.out.println(conn);

        String sql = "select * from user_tb where username = ? and password = ?";
        String name = "zhangsan";
        String pwd = "123";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);


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
