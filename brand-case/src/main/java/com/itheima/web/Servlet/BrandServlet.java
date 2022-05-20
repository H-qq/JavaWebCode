package com.itheima.web.Servlet;/**
 * @author hongtao
 * @create 2022-05-19-20:37
 */

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.Impl.BrandServiceImpl;
import com.mysql.cj.PreparedQuery;
import org.apache.ibatis.annotations.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @Description: 基础BaseServlet
 * @Author: your name
 * @Date: 2022/5/19 20:37
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private final BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void addAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1，接受数据
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();
        System.out.println(params);

        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.addAll(brand);
        //相应表示
        response.getWriter().write("success");
    }

    public void deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();
        Integer  id = JSON.parseObject(params, int.class);
        System.out.println(id);
        brandService.deleteAll(id);
        response.getWriter().write("success");
    }


    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1，接受数据

        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();
        System.out.println(params);
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);
        //相应表示
        response.getWriter().write("success");
    }
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //接收参数 当前页码 和 每页展示  url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);
        //转换json
        String jsonString = JSON.toJSONString(brandPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //接收参数 当前页码 和 每页展示  url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取查询条件对象
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);


        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);
        //转换json
        String jsonString = JSON.toJSONString(brandPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
