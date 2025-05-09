package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String remember = request.getParameter("remember");

        User user = service.login(username,password);

        if (user != null ){
            if ("1".equals(remember)){
                Cookie cookie = new Cookie("username",username);
                Cookie cookie2 = new Cookie("password",password);

                cookie.setMaxAge(7*24*60*60);
                cookie2.setMaxAge(7*24*60*60);

                response.addCookie(cookie);
                response.addCookie(cookie2);

            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }
        else{
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}