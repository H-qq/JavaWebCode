package com.itheima.web.Servlet;/**
 * @author hongtao
 * @create 2022-05-19-20:35
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 用于替换HttpServlet
 * @Author: your name
 * @Date: 2022/5/19 20:35
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径  //brand-case/brand/selectAll
        String requestURI = req.getRequestURI();
        //2。获取最后一段路径 方法名：
        int index = requestURI.lastIndexOf('/');
        // substring 左闭右开
        String methodName = requestURI.substring(index+1);

        //3 执行方法
        //获取BrandServlet字节码对象 class对象
        //this 谁调用我 我就是谁
        Class<? extends BaseServlet> cls = this.getClass();

        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //获取method对象
    }
}
