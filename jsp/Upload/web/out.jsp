<%-- 
    Document   : out
    Created on : Dec 18, 2013, 10:41:01 AM
    Author     : josephstalin
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<String> fileListInServer = (List<String>) request.getAttribute("downloadList");
        %>
        <%=fileListInServer%>
        <%
            String path = request.getContextPath();
        %>
        <img src="<%=path%>"> 
    </body>
</html>
