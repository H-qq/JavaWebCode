package com.ht.web.cookie; /**
 * @author hongtao
 * @create 2022-05-16-14:53
 */


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value  = "张三";
        // 编码
        value=URLEncoder.encode(value,"utf-8");
        //cookie.setMaxAge(0); //0 为删除  正数表示时间
        Cookie cookie = new Cookie("username", value);
        //发送
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
