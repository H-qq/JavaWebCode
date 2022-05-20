package com.ht.web.fileter;/**
 * @author hongtao
 * @create 2022-05-17-14:36
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.xml.ws.WebFault;
import java.io.IOException;

/**
 * @Description:
 * @Author: your name
 * @Date: 2022/5/17 14:36
 */
//@WebFilter("/*")
public class FileterDemo  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo.");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
