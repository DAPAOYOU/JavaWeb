package com.ithema.zscg;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ithema.pojo.brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class testc {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc/jdbg-demo/src/druid.properties"));

        DataSource datasource = (DataSource) DruidDataSourceFactory.createDataSource(prop);

        Connection conn = datasource.getConnection();
        String sql = "select * from tb_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs =pstmt.executeQuery();
        List<brand> nums = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            brand t = new brand();
            t.setBrandName(brandName);
            t.setDescription(description);
            t.setId(id);
            t.setStatus(status);
            t.setOrdered(ordered);
            t.setCompanyName(companyName);
            nums.add(t);
        }
        for (brand ch : nums){
            System.out.println(ch);
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
