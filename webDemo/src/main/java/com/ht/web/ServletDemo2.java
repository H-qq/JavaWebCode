package com.ht.web;/**
 * @author hongtao
 * @create 2022-05-14-0:38
 */



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Description: demo2
 * @Author: hong tao
 * @Date: 2022/5/14 0:38
 */
@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
/**
  初始化方法
  *1、调用时机，默认情况下，Servlet被第一次访问 调用
 *      loadOnStartup
 * 2、调用次数：1次
 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init..");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /**
     * TODO
     * @author  hongtao
     * @date   2022/5/14 0:43 
     * @param  
     * @return     1 
     * @Exception   
 * @return 只调用一次
     *
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("hello servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }
/**
 * TODO
 * @author  hongtao
 * @date   2022/5/14 0:44 
 * @param
 * @return   销毁方法
 * @Exception   
 * @return  调用时机 内存释放或者服务器关闭的时候，Servlet被销毁 调用
 * 调用次数 1
 *
 */

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
