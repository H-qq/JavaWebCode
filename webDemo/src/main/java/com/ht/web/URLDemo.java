package com.ht.web;/**
 * @author hongtao
 * @create 2022-05-14-14:45
 */

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Description: URLDemo
 * @Author: your name
 * @Date: 2022/5/14 14:45
 */
public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "张三";
        //1.URL编码
        String encode = URLEncoder.encode(name, "ISO-8859-1");
        System.out.println(encode);

        //2、URL解码
        String decode = URLDecoder.decode(encode);
        System.out.println(decode);

        //3、转换字节数据
        byte[] bytes = decode.getBytes("ISO_8859_1");
      /*  for (byte b : bytes){
            System.out.println(b+" ");
        }*/
        //4、将字节数组转换字符串
        String s = new String(bytes, "utf-8");
        System.out.println(s);
    }
}
