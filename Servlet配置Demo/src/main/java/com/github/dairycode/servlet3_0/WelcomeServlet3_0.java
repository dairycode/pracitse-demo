package com.github.dairycode.servlet3_0;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/WelcomeServlet3.0", loadOnStartup = 2)
public class WelcomeServlet3_0 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet3.0初始化...");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet3.0销毁...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet3.0的get或post请求执行!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
