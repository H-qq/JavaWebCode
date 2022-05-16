package com.ht.web;/**
 * @author hongtao
 * @create 2022-05-14-13:16
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Description: demo4
 * @Author: your name
 * @Date: 2022/5/14 13:16
 */
@WebServlet("/req")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String getMethod :获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //getContextPath  :获取虚拟目录  /webDemo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //getRequestURL()：获取同意资源入径  http://localhost:8080/webDemo/req
        StringBuffer URL = req.getRequestURL();
        System.out.println(URL.toString());
        //getRequestURI :统一资源标识符 /webDemo/req
        String URI = req.getRequestURI();
        System.out.println(URI);
        //获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //获取请求头  user-agent:浏览器版本信息
        String reqHeader = req.getHeader("user-agent");
        System.out.println(reqHeader);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取字符输入流
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        System.out.println(readLine);
    }
}
