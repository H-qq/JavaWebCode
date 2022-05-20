package com.ht.service;/**
 * @author hongtao
 * @create 2022-05-16-16:24
 */

import com.ht.mapper.UserMapper;
import com.ht.pojo.User;
import com.ht.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Description:
 * @Author: your name
 * @Date: 2022/5/16 16:24
 */
public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username,String password){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.select(username, password);
        sqlSession.close();
        return user;
    }
    public boolean register(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User u = userMapper.selectByUsername(user.getUsername());

        if (u == null){
            //用户名不存在可以注册
            userMapper.add(user);
            sqlSession.commit();

        }
        sqlSession.close();
        return u==null;
    }
    public boolean selectByName(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u = userMapper.selectByUsername(username);
        return u != null;
    }
}
