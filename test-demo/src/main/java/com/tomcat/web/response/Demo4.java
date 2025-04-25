package com.tomcat.web.response;


import org.apache.commons.io.IOUtils;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/resp4")
public class Demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("resp4");
        FileInputStream fis = new FileInputStream("D://javatest/javaweb/test-demo/src/main/java/com/tomcat/web/img.png");
        ServletOutputStream os = response.getOutputStream();

        IOUtils.copy(fis,os);

        fis.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}