package com.tomcat.web.request;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/demo3")
public class Demo3 extends MyHTTPServlet {
    @Override
    protected void Dopost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("dopost");
    }

    @Override
    protected void Doget(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("doget");
    }
}
