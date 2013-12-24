<%-- 
    Document   : public
    Created on : Dec 23, 2013, 9:10:49 AM
    Author     : josephstalin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="deter" scope="page" class="javaBean.Determine"/>
    <body bgcolor="#0099FF" text="#FFFFFF" link="#00FF00">
        <%
            String tea_id = (String) session.getAttribute("id");
        %>
        <div align="center">
            <p><font color="#00FF00" size="+3" face="方正舒体">您所带的班级</font></p>
            <p>&nbsp; </p>
            <table width="75%" border="1">
                <tr> 
                    <td>班级号</td>
                    <td>课程名</td>
                    <td> 学生</td>
                </tr>
                <%
                    String class_id = null;
                    String cour_name = null;
                    ResultSet rs = deter.getClass(tea_id);
                    while (rs.next()) {
                        class_id = rs.getString("id");
                        cour_name = rs.getString("name");
                %>	
                <tr> 
                    <td><%=class_id%></td>
                    <td><%=cour_name%></td>
                    <td><a href="MarkSvlt?class_id=<%=class_id%>&cour_name=<%=cour_name%>&action=score ">学生</a></td>
                </tr>
                <%
                    }
                %>
            </table>
            <p align="left"><a href="teacher.jsp">&lt;&lt;Back</a></p>
        </div>
    </body>
</html>
