package com.tomcat.web;

import com.tomcat.mapper.UserMapper;
import com.tomcat.pojo.User;
import com.tomcat.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u =new User();
        u.setUsername(username);
        u.setPassword(password);

//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //写静态工具类，减少占用
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectByUsername(username);

        res.setContentType("text/html;charset=utf-8");
        PrintWriter writer = res.getWriter();
        if (user == null){
            userMapper.add(u);
            sqlSession.commit();
            sqlSession.close();
        }
        else{
            writer.write("该用户名已被注册");
        }


        sqlSession.close();


    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.doGet(req, res);
    }
}
