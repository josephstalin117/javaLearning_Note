<%-- 
    Document   : index
    Created on : Dec 9, 2013, 3:13:23 PM
    Author     : josephstalin
--%>

<%@page import="bean.ShowRecordByPage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.ShowRecordByPage.*" %>

<jsp:useBean id="look" class="bean.ShowRecordByPage" scope="page"/>
<jsp:setProperty name="look" property="*"/>
<%
    look.setPageSize(10);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="query" class="bean.ShowRecordByPage" scope="session" />
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
                        <a href="">添加</a>
    </body>
</html>
