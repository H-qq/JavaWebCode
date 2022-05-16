package com.ht.web; /**
 * @author hongtao
 * @create 2022-05-16-17:24
 */


import com.ht.pojo.User;
import com.ht.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String checkCode = request.getParameter("checkCode");

        //获取程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen =(String) session.getAttribute("checkCodeGen");


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (!checkCodeGen.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        boolean flag = userService.register(user);
        if (flag){
            request.setAttribute("register_msg","注册成功，请登入");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
