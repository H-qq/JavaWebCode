package com.signin.db;

import java.sql.*;

public class DbConnect {
    private static String MysqlIP = "192.168.0.132";
    private static String MysqlPort = "3306";
    private static String MysqlDatabaseName = "signin_db";
    private static String MysqlUserName = "root";
    private static String MysqlUserPassword = "123456";
    private static String MysqlDriverName = "com.mysql.cj.jdbc.Driver";

    public static Connection getDBconnection(){
        String url1 = String.format("jdbc:mysql://%s:%s/%s", MysqlIP, MysqlPort, MysqlDatabaseName);
        String url2 = String.format("?user=%s&password=%s", MysqlUserName, MysqlUserPassword);
        String url3 = "&useUnicode=true&characterEncoding=UTF-8";
        String url = url1 + url2 + url3;
        try{
            Class.forName(MysqlDriverName);
            Connection con= DriverManager.getConnection(url);
            return con;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeDB(Connection con, PreparedStatement pstm, ResultSet rs){
        try{
            if(rs!=null) rs.close();
            if(pstm!=null) pstm.close();
            if(con!=null) con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
