package com.tomcat.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resp2")
public class Demo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("resp2");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}