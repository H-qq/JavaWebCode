package com.ht.web;/**
 * @author hongtao
 * @create 2022-05-14-13:42
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description: demo5
 * @Author: your name
 * @Date: 2022/5/14 13:42
 */

@WebServlet("/req1")
public class ServletDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key:parameterMap.keySet()){
            System.out.print(key+":");
            //获取值
            String[] values = parameterMap.get(key);
            for (String value:values){
                System.out.print(value+" ");
            }
            System.out.println();
        }
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby:hobbies){
            System.out.println(hobby);
        }
        String username = req.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
