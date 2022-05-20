package com.signin.dao;

import com.signin.beans.Record;
import java.util.List;

public interface IRecordDAO {
    public abstract int insert(Record record) throws Exception;//添加记录的方法
    public abstract int delete(Record record) throws Exception; //删除记录的方法
    public abstract Record select(Record record) throws Exception;  //查询记录的方法
    public abstract List<Record> selectAll() throws Exception;  //列出全部记录的方法
    public abstract int update(Record record) throws Exception;  //修改记录的方法
}
