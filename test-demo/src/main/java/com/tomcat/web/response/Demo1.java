package com.tomcat.web.response;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class Demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("resp1");

        //重定向

//        //设置状态码
//        response.setStatus(302);
//        //设置响应头
//        response.setHeader("Location", "/test-demo/resp2");


//        //简化写法
//        response.sendRedirect("/test-demo/resp2");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/resp2");

    }
}
