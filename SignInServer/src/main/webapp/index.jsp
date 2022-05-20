<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>主页面</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js" type="text/javascript" charset="UTF-8"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <h1 style="text-align: center">健康状况打卡后台管理系统</h1>
        <ul class="nav nav-pills nav-justified">
            <li><a href="select_all.jsp" target="iframe_main">查询所有数据</a></li>
            <li><a href="select.jsp" target="iframe_main">查询数据</a></li>
            <li><a href="update.jsp" target="iframe_main">修改数据</a></li>
            <li><a href="delete.jsp" target="iframe_main">删除数据</a></li>
        </ul>
        <iframe name="iframe_main" width="100%" height="2000px"></iframe>
    </body>
</html>