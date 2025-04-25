package com.tomcat.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 数据共享
 * void setAttribute(String name, Object):存储数据到 request域中
 * Object getAttribute(String name):根据 key，获取值
 * void removeAttribute(String name):根据 key，删除该键值对
 */

@WebServlet("/demo5")
public class demo_5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo5");

        req.setAttribute("dapao", "xixi");
        //请求转发
        req.getRequestDispatcher("/demo4").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }
}
