package com.ithema.zscg;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

//需要所有要改的数据和主键
public class testg {
    public static void main(String[] args) throws Exception {
        Properties prop=new Properties();
        prop.load(new FileInputStream("jdbc/jdbg-demo/src/druid.properties"));

        DataSource datasource = (DataSource) DruidDataSourceFactory.createDataSource(prop);
        Connection conn = datasource.getConnection();

        String sql="update tb_brand set brand_name = ? where id = ?;";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1,"两只母猪");
        pstmt.setInt(2,4);

        int cnt = pstmt.executeUpdate();
        if (cnt > 0){
            System.out.println("成功");
        }
        else{
            System.out.println("失败");
        }
        pstmt.close();
        conn.close();
    }
}
