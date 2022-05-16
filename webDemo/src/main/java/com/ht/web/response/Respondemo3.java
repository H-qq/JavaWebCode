package com.ht.web.response; /**
 * @author hongtao
 * @create 2022-05-14-15:31
 */



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp3")
public class Respondemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp3..");
        //获取字符输出流
            //流不需要关闭
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // response.setHeader("content-type","text/html");
        writer.write("<h1>aaa</h1>");
        writer.write("你好！");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
