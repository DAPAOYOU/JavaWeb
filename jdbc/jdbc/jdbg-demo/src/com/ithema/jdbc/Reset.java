package com.ithema.jdbc;

import com.ithema.pojo.T;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义实体类
 * 查询数据，封装到类中
 * 将封装好的数据存到集合中
 */

public class Reset {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql:///jdbc?useSSL=false";

        String username="root";
        String password="csk1507806125";
        Connection conn = DriverManager.getConnection(url,username,password);

        Statement stmt = conn.createStatement();
        String sql = "select * from t where tsalary=5000 limit 10";

        ResultSet rs = stmt.executeQuery(sql);

        //stl存数据
        List<T> list=new ArrayList<T>();
        //遍历数据
        while (rs.next()){ //光标移动到下一行，并判断是否有数据

            T t =  new T();

            //获取数据  getXxx.(第几列)  或者 getXxx.(列名)
            String name = rs.getString(2);//参数是表中第几列
            String num = rs.getString("tnum");
            //System.out.println(name+ " " +num);

            t.setName(name);
            t.setTnum(num);

            list.add(t);
        }

        System.out.println(list);

        rs.close();
        stmt.close();
        conn.close();
    }
}
