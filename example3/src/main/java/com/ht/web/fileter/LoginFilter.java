package com.ht.web.fileter; /**
 * @author hongtao
 * @create 2022-05-17-15:01
 */


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //判断访问资源路径是否与登入注册相关
        String[] urls = {"/register.html","/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        //获取访问当前路径

        String url = req.getRequestURL().toString();

        //循环判断
        for (String u : urls){
            if (url.contains(u)){
                //找到了

                //放行
                chain.doFilter(request,response);

                return;

            }
        }

        //1、判断session是否有User
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2.判断User 是否为null
        if (user!=null){
            //登入过了
            chain.doFilter(request, response);

        }else {
            req.setAttribute("log_msg","您尚未登入");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
