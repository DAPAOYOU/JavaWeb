package com.tomcat.web.jstl;

import com.tomcat.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jstl1")
public class Demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));

        //设置
        request.setAttribute("status",0);
        request.setAttribute("brands",brands);
        //转发
        //request.getRequestDispatcher("/jstl-if.jsp").forward(request,response);
        request.getRequestDispatcher("/jstl-foreach.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}