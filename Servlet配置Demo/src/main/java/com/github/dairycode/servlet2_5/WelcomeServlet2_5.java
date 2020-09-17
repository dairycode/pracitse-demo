package com.github.dairycode.servlet2_5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet类规范:
 *   1.必须继承javax.servlet.http.HttpServlet
 *   2.重写其中的doGet()或doPost()方法
 *
 *   doGet(): 接收并处理所以get提交方式的请求
 *   doPost(): 接收并处理所以Post提交方式的请求
 *
 *   Servlet要想使用,必须配置:
 *   Servlet2.5: web.xml
 *   Servlet3.0: @WebServlet
 *
 * Servlet生命周期: 加载,初始化,服务,销毁,卸载
 * Servlet API: 由两个软件包组成,对应于HTTP协议的软件包,对应于其他协议的软件包,即适用于任何通讯协议
 */
public class WelcomeServlet2_5 extends HttpServlet {

    // 初始化(可配置自启动)
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet2.5初始化...");
    }

    // 销毁
    @Override
    public void destroy() {
        System.out.println("Servlet2.5销毁...");
    }

    // 服务
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("doGet...");
        System.out.println("Servlet2.5的get或post请求执行!");
    }

    // 服务
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("doPost...");
        this.doGet(req, resp);
    }
}