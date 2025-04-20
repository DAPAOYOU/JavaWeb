package com.ithema.zscg;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class tests {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc/jdbg-demo/src/druid.properties"));

        DataSource datasource = (DataSource) DruidDataSourceFactory.createDataSource(prop);

        Connection conn = datasource.getConnection();

        String sql = "delete from tb_brand where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,4);
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
