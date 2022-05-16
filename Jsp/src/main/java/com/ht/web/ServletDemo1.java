package com.ht.web; /**
 * @author hongtao
 * @create 2022-05-15-16:04
 */


import com.ht.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1准备数据
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));


        //存储request 中
        request.setAttribute("brands",brands);

        request.setAttribute("status",1);

        //3.转发到el-demo。jsp
       // request.getRequestDispatcher("el-demo.jsp").forward(request,response);
    //    request.getRequestDispatcher("jstl.jsp").forward(request,response);
        request.getRequestDispatcher("jstl-foreach.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
