package com.tomcat.web.request;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * init只会在第一次访问的时候调用一次
 * 访问一次就会调用一次servlet方法
 * loadOnStartup  负整数：第一次被访问时创建servlet对象
 *                0或正整数 服务器启动时创建，数字越小，优先级越高
 *                不写默认-1
 */

@WebServlet( urlPatterns = "/demo1" , loadOnStartup = 1 )
public class ServletDemo1 implements Servlet{

    ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
    }
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    /**
     * 根据请求方式不同，进行不同的处理（get  post）
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet hello");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println("Method: " + method);
        if (method.equals("GET")) {

        }
        else if(method.equals("POST")) {

        }
    }
    @Override
    public String getServletInfo() {
        return "";
    }
    @Override
    public void destroy() {
        System.out.println("Servlet destroy");
    }
}
