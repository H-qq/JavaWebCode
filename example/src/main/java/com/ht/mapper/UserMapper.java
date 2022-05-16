package com.ht.mapper;/**
 * @author hongtao
 * @create 2022-05-14-16:27
 */

import com.ht.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: mapper
 * @Author: your name
 * @Date: 2022/5/14 16:27
 */
public interface UserMapper {
    @Select("select  *from tb_user where username=#{username} and password=#{password}")
    User selectAll(@Param("username") String username,@Param("password") String password);

    @Select("select *from tb_user where username=#{username}")
    User selectByUsername(String username);

    @Insert("insert into tb_user values (null,#{username},#{password})")
    int add(User user);
}
