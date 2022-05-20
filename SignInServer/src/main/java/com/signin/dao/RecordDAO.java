package com.signin.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.signin.db.DbConnect;
import com.signin.beans.Record;

public class RecordDAO implements IRecordDAO {
    protected static String TBALE_NAME = "signin_table";
    protected static final String FIELDS_INSERT = "date_time, name, temp, location";
    protected static String INSERT_SQL = "insert into "+ TBALE_NAME + "(" + FIELDS_INSERT + ") values(?, ?, ?, ?, ?, ?)";
    protected static String SELECT_SQL="select " + FIELDS_INSERT + " from "+ TBALE_NAME + " where name = ? and date_time = ?";
    protected static String UPDATE_SQL="update "+ TBALE_NAME + " set date_time = ?, name = ?, temp = ?, location = ?";
    protected static String DELETE_SQL ="delete from "+ TBALE_NAME + " where name = ? and date_time = ?";

    //实现向数据库中添加记录的方法
    public int insert(Record record) throws Exception{
        int result = 0;
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs = null;
        try{
            con=DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(INSERT_SQL);
            prepStmt.setString(1, record.getDate_time());
            prepStmt.setString(2, record.getName());
            prepStmt.setString(3, record.getTemp());
            prepStmt.setString(4, record.getLocation());
            result = prepStmt.executeUpdate();
        } catch(Exception e){
        } finally{
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return result;
    }

    //实现查询数据库中对指定的记录是否存在的方法
    public Record select(Record record) throws Exception {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        Record record2 = null;
        try {
            con = DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(SELECT_SQL);
            prepStmt.setString(1, record.getName());
            prepStmt.setString(2, record.getDate_time());
            rs = prepStmt.executeQuery();
            if (rs.next()){
                record2 = new Record();
                record2.setDate_time(rs.getString(1));
                record2.setName(rs.getString(2));
                record2.setTemp(rs.getString(3));
                record2.setLocation(rs.getString(4));
            }
        } catch (Exception e) {
            // handle exception
        } finally {
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return record2;
    }

    //实现列出数据库全部记录的方法
    public List<Record> selectAll() throws Exception {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        List<Record> recordList = new ArrayList<Record>();
        con = DbConnect.getDBconnection();
        prepStmt = con.prepareStatement("select * from " + TBALE_NAME + " order by date_time desc");
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            Record record2 = new Record();
            record2.setDate_time(rs.getString(1));
            record2.setName(rs.getString(2));
            record2.setTemp(rs.getString(3));
            record2.setLocation(rs.getString(4));
            recordList.add(record2);
        }
        DbConnect.closeDB(con, prepStmt, rs);
        return recordList;
    }

    //实现删除数据库中指定的记录方法
    public int delete(Record record) throws Exception {
        int result = 0;
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            con = DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(DELETE_SQL);
            prepStmt.setString(1, record.getDate_time());
            prepStmt.setString(2, record.getName());
            prepStmt.executeUpdate();
        }catch(Exception e) {
            //
        } finally{
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return result;
    }

    //实现用指定的对象修改数据库中记录的方法
    public int update(Record record) throws Exception {
        int result = 0;
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        try {
            con=DbConnect.getDBconnection();
            prepStmt = con.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1, record.getDate_time());
            prepStmt.setString(2, record.getName());
            prepStmt.setString(3, record.getTemp());
            prepStmt.setString(4, record.getLocation());
            result = prepStmt.executeUpdate();
        } catch (Exception e) {
            // handle exception
        } finally {
            DbConnect.closeDB(con, prepStmt, rs);
        }
        return result;
    }
}
