package com.ht.web; /**
 * @author hongtao
 * @create 2022-05-16-16:36
 */


import com.ht.pojo.User;
import com.ht.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = new String(request.getParameter("username").getBytes(StandardCharsets.ISO_8859_1),(StandardCharsets.UTF_8));
        String password = request.getParameter("password");

        //获取复选框数据
        String remember = request.getParameter("remember");


        User user = userService.login(username, password);

        if (user!=null){
            //判断用户是否勾选 记住我
            if ("1".equals(remember)){
                String userNameValue = username;
                String passWordValue = password;
                Cookie cookieUsername = new Cookie("username",userNameValue);
                Cookie cookiePassword = new Cookie("password",passWordValue);

                //设置存活时间
                cookiePassword.setMaxAge(60*60*24*7);
                cookieUsername.setMaxAge(60*60*24*7);
                //发送
                response.addCookie(cookiePassword);
                response.addCookie(cookieUsername);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //登入成功  跳转到所有的BrandServlet ,使用重定向 因为没有数据需要进行共享
            //request.getRequestDispatcher("selectAllServlet").forward(request,response);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else {
            //登入失败
            // 存储错误信息到request
            request.setAttribute("log_msg","用户名或密码错误");
            //跳转 login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
