package com.itheima.service.Impl;/**
 * @author hongtao
 * @create 2022-05-19-17:36
 */

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Description:
 * @Author: your name
 * @Date: 2022/5/19 17:36
 */
public class BrandServiceImpl implements BrandService {
    //1.创建工厂
    SqlSessionFactory sqlSessionFactory =
            SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    @Override
    public void addAll(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.addAll(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteAll(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteAll(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //计算开始类型
        int begin = (currentPage-1)*pageSize;
        //计算查询条目数
        int size = pageSize;
        //查询当前页数据
        List<Brand> rows = brandMapper.selectByPage(begin, size);

        //查询总记录
        int totalCount = brandMapper.selectTotalCount();
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRow(rows);
        brandPageBean.setTotalCount(totalCount);
        return brandPageBean;

    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage-1)*pageSize;
        int size =  pageSize;
        //处理模糊查询 +%
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() >0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if ( companyName!= null && companyName.length() >0){
            brand.setCompanyName("%"+companyName+"%");
        }
        List<Brand> rows = brandMapper.selectByPageAndCondition(begin, size, brand);

        int totalCountByCondition = brandMapper.selectTotalCountByCondition(brand);

        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRow(rows);
        brandPageBean.setTotalCount(totalCountByCondition);

        sqlSession.close();
        return brandPageBean;
    }

}
