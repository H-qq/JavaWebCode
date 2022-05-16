package com.ht.web.response; /**
 * @author hongtao
 * @create 2022-05-14-15:31
 */


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class Respondemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1..");
        //重定向
    /*    //1.设置响应状态吗
        response.setStatus(302);
        //2、设置响应头
        response.setHeader("location","/webDemo/resp2");*/

        //简化方式 完成重定向
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/resp2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
