package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand (id,brand_name, company_name, ordered, description, status) " +
            "values (null,#{brandName},#{companyName},#{ordered},#{description},#{status});")
    void addAll(Brand brand);

    @Select("select  *from tb_brand limit #{begin} , #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    @Delete("delete from tb_brand where id=#{id}")
    void deleteAll(Integer id);

    void deleteByIds(@Param("ids") int[] ids);

    //分页条件查询
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand")Brand brand);

    //条件总记录数
    int selectTotalCountByCondition(Brand brand);
}
