package com.itheima.pojo;/**
    @author hongtao
    @create 2022-05-20-15:56
*/

import java.util.List;

/**
 * @Description: 定义分页查询
 * @Author: your name
 * @Date: 2022/5/20 15:56
 */
public class PageBean<T> {
    //总记录数
    private int totalCount;
    //当前页数据
    private List<T> row;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRow() {
        return row;
    }

    public void setRow(List<T> row) {
        this.row = row;
    }
}
