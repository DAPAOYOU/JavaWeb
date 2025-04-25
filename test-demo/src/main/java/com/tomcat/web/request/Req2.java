package com.tomcat.web.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 通用格式 可用于get和post
 * Map<String,String[]> map = req.getParameterMap();
 * 根据key获取      （单个多个都行）  对应的参数值 getParameterValues
 * 根据key获取单个值  getParameter  //特别常用
 */

/**
 * 解决中文乱码
 * html的编码方式 : <meta charset="UTF-8">
 * 所以编码方式改成对应相同就行
 */

@WebServlet("/req2")
public class Req2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        //解决中文乱码
        //解决的post的方式的乱码 getReader()-->BufferedReader
        //设置输入流的编码
        req.setCharacterEncoding("UTF-8");

        //解决的get的方式的乱码 getQueryString()-->String
        //先编码再解码，tomcat解码urL字符集默认是ISO-8859-1
        /**
         * post就这么简单就行
         * req.setCharacterEncoding("UTF-8");
         *
         * 这两步操作即可
         * byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
         * username = new String(bytes,StandardCharsets.UTF_8);
         * 写成一行就是 username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
         *
         * 这种解决方式既能解决get也能解决post
         * tomcat8之后本事就是utf-8的版本
         */


        //ParameterMap
        Map<String,String[]> map = req.getParameterMap();
        for (String key : map.keySet()){
            System.out.print(key + ":");
            for (String value : map.get(key)){
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("----------------------");

        //Parametervalues
        String[] hobbys = req.getParameterValues("hobby");
        System.out.print("hobby:");
        for (String hobby : hobbys){
            System.out.print(hobby + " ");
        }
        System.out.println();
        System.out.println("-----------------------");

        //key
        String username = req.getParameter("username");
        System.out.println("username: " + username);
        String password = req.getParameter("password");
        System.out.println("password: " + password);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doGet(req, resp);

    }
}
