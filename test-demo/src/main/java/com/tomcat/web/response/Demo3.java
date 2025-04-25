package com.tomcat.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp3")
public class Demo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("resp3");
        PrintWriter writer = response.getWriter();
        writer.println("resp333");
        //设置writer的格式  设置字符集
        response.setContentType("text/html;charset=utf-8");

        writer.write("你好");
        writer.write("<h1>aaaaa</h1>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}