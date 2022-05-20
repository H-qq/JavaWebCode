package com.itheima.web.Servlet; /**
 * @author hongtao
 * @create 2022-05-19-19:20
 */


import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.Impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addAllServlet")
public class AddAllServlet extends HttpServlet {
    private final BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1，接受数据
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.addAll(brand);
        //相应表示
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
