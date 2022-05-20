package com.itheima.service;/**
 * @author hongtao
 * @create 2022-05-19-17:35
 */

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

/**
 * @Description:
 * @Author: your name
 * @Date: 2022/5/19 17:35
 */
public interface BrandService {
    /**
     * TODO
     * @author  hongtao
     * @date   2022/5/20 16:08
     * @Exception
     * @return null
     *
     */
    List<Brand> selectAll();

    /**
     * @author  hongtao
     * @date   2022/5/20 16:10
     * @param brand 添加数据
     */
    void addAll(Brand brand);

    void deleteAll(Integer id);

    void deleteByIds(int[] ids);

    //currentPage 当前页码   pageSize ：每页条数
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    //分页条件查询
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);


}
