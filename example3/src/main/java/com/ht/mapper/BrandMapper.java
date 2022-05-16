package com.ht.mapper;/**
 * @author hongtao
 * @create 2022-05-15-17:56
 */

import com.ht.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: 接口
 * @Author: your name
 * @Date: 2022/5/15 17:56
 */
public interface BrandMapper {


    @Select("select  *from tb_brand  ")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();


    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("brandResultMap")
    void addBrand(Brand brand);

    @Select("select  *from tb_brand where id =#{id} ")
    @ResultMap("brandResultMap")
     Brand selectById(int id);

    @Update("update tb_brand set brand_name =#{brandName},company_Name =#{companyName}," +
            "ordered =#{ordered},description =#{description},status =#{status} where id=#{id}")
    void update(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
     void delete(int id);
}
