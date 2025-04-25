package com.tomcat.web.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class Request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        //http://localhost:8080/test-demo/req1?username=lisi&password=123456


        ////////////////
        //获取请求行

        //请求方式 get/post
        String method = req.getMethod();
        System.out.println(method);
        //Get

        //统一资源定位符 ?之前的
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        //http://localhost:8080/test-demo/req1

        //统一资源标识符  localhost之后, ?之前的
        String uri = req.getRequestURI();
        System.out.println(uri);
        // /test-demo/req1

        //虚拟目录 @WebServlet
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // /test-demo

        //? 后面的请求参数，比如username,password....
        String queryString = req.getQueryString();
        System.out.println(queryString);
        // username=lisi&password=123456


        ///////////////
        //获取请求头
        String agent =req.getHeader("User-Agent");
        System.out.println(agent);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ///////////////
        //获取请求体  只有post才有

        this.doGet(req, resp);

        //获取字符输入流
        BufferedReader br = req.getReader();
        //读取数据
        String line = br.readLine();
        System.out.println(line);
    }

}
