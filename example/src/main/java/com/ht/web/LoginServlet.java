package com.ht.web; /**
 * @author hongtao
 * @create 2022-05-14-16:37
 */


import com.ht.mapper.UserMapper;
import com.ht.pojo.User;
import com.ht.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、接受用户 名 和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2、调用 mybatis 进行查询
        //2.1、获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //2.2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3、获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //2.4、调用方法
        User user = userMapper.selectAll(username, password);
        //2.5、释放资源
        sqlSession.close();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //3、判断user 是否为null
        if (user != null) {
            writer.write("登入成功！");
            System.out.println("登入成功！");
        } else {
            writer.write("登入失败！");
            System.out.println("登入失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
