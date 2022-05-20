package com.itheima.web; /**
 * @author hongtao
 * @create 2022-05-18-20:27
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //不能接受json数据
        //获取请求体
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();

        //将JSON转化java
        Brand brand = JSON.parseObject(params, Brand.class);

        //2调用serveice
        brandService.add(brand);

        //
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
