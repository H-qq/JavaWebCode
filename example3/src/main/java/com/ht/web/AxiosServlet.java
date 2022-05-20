package com.ht.web; /**
 * @author hongtao
 * @create 2022-05-17-17:00
 */


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/axiosServlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        String username = request.getParameter("username");
        System.out.println(username);


        response.getWriter().write("hello Axios");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        this.doGet(request, response);
    }
}
