package com.ht.web.response; /**
 * @author hongtao
 * @create 2022-05-14-15:31
 */



import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp4")
public class Respondemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp4..");
       //1、读取文件
        FileInputStream fileInputStream = new FileInputStream("d://1.png");

        //2、获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();

      /*  //3、完成流的copy
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buff))!= -1){
            outputStream.write(buff,0,len);
        }*/
        IOUtils.copy(fileInputStream,outputStream);
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
