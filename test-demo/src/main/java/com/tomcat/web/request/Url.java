package com.tomcat.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * urlPatterns匹配
 * 看 img.png
 * 精确匹配
 * 目录匹配
 * 扩展名匹配
 * 任意匹配符匹配
 * 不要任意匹配，很危险的两个行为"/"  "/*"
 */

@WebServlet( urlPatterns = {"/url1","/url2"})
public class Url implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}