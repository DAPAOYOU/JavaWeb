package com.ithema.zscg;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class testz {
    public static void main(String[] args) throws Exception {
        //登陆连接数据库
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc/jdbg-demo/src/druid.properties"));

        //获取数据源
        DataSource datasource = (DataSource) DruidDataSourceFactory.createDataSource(prop);

        //获取连接池对象
        Connection conn = datasource.getConnection();

        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) value(?,?,?,?,?);";

        //添加操作不需要传入主键************************
        //导入sql语句并传参
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"两只老虎");
        pstmt.setString(2,"两只老虎有限公司");
        pstmt.setInt(3,80);
        pstmt.setString(4,"包你满意");
        pstmt.setInt(5,0);

        int cnt = pstmt.executeUpdate();

        if (cnt > 0){
            System.out.println("添加成功");
        }
        else{
            System.out.println("添加失败");
        }
        pstmt.close();
        conn.close();
    }
}
