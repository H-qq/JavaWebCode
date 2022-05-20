<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="com.signin.beans.Record" %>
<%@ page import="java.util.List" %>
<%@ page import="com.signin.dao.RecordDAO" %><%--
  Created by IntelliJ IDEA.
  User: undercover
  Date: 2022/5/15
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="css/my.css">
    </head>
    <body>
        <center>
            <%

                RecordDAO recordDAO = new RecordDAO();
                List<Record> recordList = recordDAO.selectAll();
                int count = recordList.size();
                out.print("所有的打卡记录条数为：" + count);
            %>
            <table>
                <tr>
                    <td>记录条数</td><td>时间</td><td>姓名</td><td>体温</td><td>位置</td>
                </tr>
                <%
                    for (int i = 0; i < count; i++) {
                        out.print(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", i, recordList.get(i).getDate_time(), recordList.get(i).getName(), recordList.get(i).getTemp(), recordList.get(i).getLocation()));
                    }
                %>
            </table>
        </center>
    </body>
</html>
