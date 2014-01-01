<%-- 
    Document   : loginOut
    Created on : Dec 31, 2013, 9:02:22 PM
    Author     : josephstalin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
//            String loginOut = "loginOut";
//            session.setAttribute("error", loginOut);
        %>
    <center>
        <h1>注销成功！</h1>
        2秒后跳转到登录页面
        <p>
            <%        response.setHeader("refresh", "2;URL=index.jsp");
            %>
    </center>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
