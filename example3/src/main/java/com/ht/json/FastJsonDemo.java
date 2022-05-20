package com.ht.json;/**
 * @author hongtao
 * @create 2022-05-18-0:51
 */

import com.alibaba.fastjson.JSON;

/**
 * @Description:
 * @Author: your name
 * @Date: 2022/5/18 0:51
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        //将java对象转换json
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123123");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        //将json 转换 java对象
        User u = JSON.parseObject("{\"id\":1,\"password\":\"123123\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(u);
    }
}
