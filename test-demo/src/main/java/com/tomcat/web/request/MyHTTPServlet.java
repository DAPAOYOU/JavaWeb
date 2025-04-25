package com.tomcat.web.request;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 创建一个类，让其他的继承
 * 要不以后这5个函数每次都写一边太麻烦
 * 直接一次写好让其他的继承
 * 看demo3
 */
public class MyHTTPServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet hello");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println("Method: " + method);
        if (method.equals("GET")) {
            Doget(servletRequest,servletResponse);
        }
        else if(method.equals("POST")) {
            Dopost(servletRequest,servletResponse);
        }
    }
    //protected 便于子类继承  重写
    protected void Dopost(ServletRequest servletRequest, ServletResponse servletResponse) {
    }
    protected void Doget(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
