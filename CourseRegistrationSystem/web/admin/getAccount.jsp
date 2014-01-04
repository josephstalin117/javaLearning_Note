<%-- 
    Document   : getAccount
    Created on : Jan 3, 2014, 11:19:45 AM
    Author     : josephstalin
--%>
<%@page import="CloudServlet.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="look" class="CloudServlet.ShowRecordByPage" scope="page"/>
        <jsp:setProperty name="look" property="*"/>
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

        <div class="container">
            <jsp:useBean id="query" class="CloudServlet.ShowRecordByPage" scope="session" />
            <jsp:setProperty name="query" property="showPage"/>
            <jsp:getProperty name="query" property="pageResult"/>

            <br>
            <table><tr>
                    <td>
                        <form action="">
                            <input type="hidden" name="showPage" value="1">
                            <input type="submit" name="first" value="first">
                        </form>
                    </td>
                    <td>
                        <form action="">
                            <input type="hidden" name="showPage" value="<%=query.getShowPage() - 1%>">
                            <input type="submit" name="previous" value="previous">
                        </form>
                    </td>
                    <td>
                        <form action="">
                            <input type="hidden" name="showPage" value="<%=query.getShowPage() + 1%>">
                            <input type="submit" name="next" value="next">
                        </form>
                    </td>
                    <td>
                        <form action="">
                            <input type="hidden" name="showPage" value="<%=query.getPageCount()%>">
                            <input type="submit" name="last" value="last">
                        </form>
                    </td>
                    <td>
                        <form action="">
                            <input type="text" name="showPage" >
                            <input type="submit" name="go" value="go">
                        </form>
                    </td>
                </tr>
            </table>
            <a href="admin.jsp">返回主页</a>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="../js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/offcanvas.js"></script>
    </body>
</html>
