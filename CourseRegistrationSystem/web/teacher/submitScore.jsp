<%-- 
    Document   : submitScore
    Created on : Jan 2, 2014, 5:41:47 PM
    Author     : josephstalin
--%>
<%@page import="CloudServlet.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/offcanvas.css" rel="stylesheet">
        <title>JSP Page</title>
        <%
            LoginBean login = (LoginBean) session.getAttribute("login");

            if (login == null) {
                session.setAttribute("error", "nologin");
                response.sendRedirect("../index.jsp");
            }
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="../js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/offcanvas.js"></script>
    </body>
</html>
